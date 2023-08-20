package com.chic.qh.service.quote.impl;

import com.chic.qh.configuration.AppConfig;
import com.chic.qh.repository.mapper.*;
import com.chic.qh.repository.model.GoodsQuote;
import com.chic.qh.repository.model.GoodsQuoteDetail;
import com.chic.qh.service.quote.ConfigDTO;
import com.chic.qh.repository.model.LogisticChannel;
import com.chic.qh.repository.model.LogisticChannelDetail;
import com.chic.qh.service.goods.vo.GoodsVO;
import com.chic.qh.service.goods.vo.SkuVO;
import com.chic.qh.service.logistic.ChannelConfig;
import com.chic.qh.service.logistic.LogisticService;
import com.chic.qh.service.quote.BillingWeight;
import com.chic.qh.service.quote.QuoteResult;
import com.chic.qh.service.quote.QuoteService;
import com.chic.qh.service.quote.VolumetricWeight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * @Description: 报价
 * @author: xumingwei
 * @date: 2023—04—07 14:51
 */
@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private LogisticService logisticService;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private GoodsQuoteDetailMapper goodsQuoteDetailMapper;
    @Autowired
    private GoodsQuoteMapper goodsQuoteMapper;
    private static final Map<String, String> countryMap = new HashMap();
    static{
        countryMap.put("US", "美国");
        countryMap.put("CA", "加拿大");
        countryMap.put("AU", "澳大利亚");
        countryMap.put("GB", "英国");
        countryMap.put("DE", "德国");
        countryMap.put("FR", "法国");
        countryMap.put("IT", "意大利");
        countryMap.put("IE", "爱尔兰");
        countryMap.put("IL", "以色列");
        countryMap.put("SE", "瑞典");
        countryMap.put("CH", "瑞士");
    }

    @Override
    public QuoteResult quote(String country, String carrierCode, GoodsVO goodsVO, SkuVO skuVo, Integer quantity){
        String countryName = countryMap.get(country);
        ChannelConfig config = logisticService.getChannelConfig(carrierCode);
        VolumetricWeight volWeight = null;
        if(skuVo.getLength() != null && skuVo.getWidth() != null && skuVo.getHeight() != null) {
            volWeight = new VolumetricWeight(skuVo.getLength(), skuVo.getWidth(), skuVo.getHeight(),
                    config.getVolWeightRate(countryName).intValue());
        }
        BillingWeight billingWeight = BillingWeight.build(skuVo.getWeight(), volWeight);
        BigDecimal kg = new BigDecimal(billingWeight.getValue()).divide(new BigDecimal("1000"));
        LogisticChannelDetail detail = config.getConfig(countryName, kg);
        if(detail == null){
            throw new RuntimeException("找不到 线路[" +config.getLogisticChannel().getCode()+ "]中," +
                    "国家为[" +countryName+ "] 重量为[" + billingWeight.getValue() + "] 的物流价格数据，无法进行报价");
        }
        BigDecimal shippingFee = kg
                .multiply(detail.getShippingFee())
                .add(detail.getExtraFee())
                .multiply(new BigDecimal(quantity))
                .multiply(appConfig.getAmplifyRate())
                .add(appConfig.getOperationFee())
                .divide(appConfig.getExchangeRate(), 2, RoundingMode.HALF_UP);
        BigDecimal productFee = skuVo.getPurPrice()
                .multiply(new BigDecimal(quantity))
                .multiply(appConfig.getAmplifyRate())
                .divide(appConfig.getExchangeRate(), 2, RoundingMode.HALF_UP);;
        BigDecimal total = shippingFee.add(productFee);
        LogisticChannel channel = config.getLogisticChannel();
        QuoteResult result = new QuoteResult(channel.getCompany(), channel.getCode(), skuVo.getSkuName(), false, false,
                new BigDecimal(billingWeight.getValue()),
                new BigDecimal(billingWeight.getActWeight()),
                new BigDecimal(billingWeight.getVolWeight()),
                billingWeight.getWeightType(),
                total, productFee, shippingFee, detail.getShippingTime());
        return result;
    }

    @Override
    public ConfigDTO getConfig(){
        ConfigDTO configDTO = new ConfigDTO();
        configDTO.setAmplifyRate(appConfig.getAmplifyRate());
        configDTO.setOperationFee(appConfig.getOperationFee());
        configDTO.setExchangeRate(appConfig.getExchangeRate());
        return configDTO;
    }

    @Override
    public void updateConfig(String key, String value) {
        switch (key){
            case "amplifyRate":
                appConfig.setAmplifyRate(new BigDecimal(value));
                break;
            case "operationFee":
                appConfig.setOperationFee(new BigDecimal(value));
                break;
            case "exchangeRate":
                appConfig.setExchangeRate(new BigDecimal(value));
                break;
            default:
                throw new RuntimeException("找不到key为[" + key + "]的配置项");
        }
    }

    @Override
    public void saveQuote(GoodsQuote goodsQuote, List<GoodsQuoteDetail> quoteList) {
        goodsQuoteMapper.insert(goodsQuote);
        quoteList.stream().forEach(x -> x.setQuoteId(goodsQuote.getRecId()));
        goodsQuoteDetailMapper.insertMultiple(quoteList);
    }

    @Override
    public GoodsQuoteDetail getQuote(SkuVO skuVO, String _country, Integer _quantity) {
        GoodsQuote quoteVersion = goodsQuoteMapper.selectOne(c -> c.where(GoodsQuoteDynamicSqlSupport.goodsId, isEqualTo(skuVO.getGoodsId()))
                .orderBy(GoodsQuoteDynamicSqlSupport.version.descending())
                .limit(1)).orElse(null);
        if(quoteVersion == null){
            return null;
        }
        return goodsQuoteDetailMapper.selectOne(c -> c.where(GoodsQuoteDetailDynamicSqlSupport.skuId, isEqualTo(skuVO.getSkuId()))
                .and(GoodsQuoteDetailDynamicSqlSupport.quoteId, isEqualTo(quoteVersion.getRecId()))
                .and(GoodsQuoteDetailDynamicSqlSupport.country, isEqualTo(_country))
                .and(GoodsQuoteDetailDynamicSqlSupport.qty, isEqualTo(_quantity))
                .limit(1)).orElse(null);
    }

    @Override
    public GoodsQuoteDetail getQuote(SkuVO skuVO, String _country, Integer _quantity, String version) {
        GoodsQuote quoteVersion = goodsQuoteMapper.selectOne(c -> c.where(GoodsQuoteDynamicSqlSupport.goodsId, isEqualTo(skuVO.getGoodsId()))
                .and(GoodsQuoteDynamicSqlSupport.version, isEqualTo(version))
                .limit(1)).orElse(null);
        if(quoteVersion == null){
            return null;
        }
        return goodsQuoteDetailMapper.selectOne(c -> c.where(GoodsQuoteDetailDynamicSqlSupport.skuId, isEqualTo(skuVO.getSkuId()))
                .and(GoodsQuoteDetailDynamicSqlSupport.quoteId, isEqualTo(quoteVersion.getRecId()))
                .and(GoodsQuoteDetailDynamicSqlSupport.country, isEqualTo(_country))
                .and(GoodsQuoteDetailDynamicSqlSupport.qty, isEqualTo(_quantity))
                .limit(1)).orElse(null);
    }

    @Override
    public List<GoodsQuote> selectHistory(Integer _goodsId) {
        return goodsQuoteMapper.select(c -> c.where(GoodsQuoteDynamicSqlSupport.goodsId, isEqualTo(_goodsId))
                .orderBy(GoodsQuoteDynamicSqlSupport.version.descending()));
    }

}
