package com.chic.qh.service.quote.impl;

import com.chic.qh.configuration.AppConfig;
import com.chic.qh.repository.mapper.*;
import com.chic.qh.repository.model.*;
import com.chic.qh.service.goods.GoodsService;
import com.chic.qh.service.quote.*;
import com.chic.qh.service.goods.vo.GoodsVO;
import com.chic.qh.service.goods.vo.SkuVO;
import com.chic.qh.service.logistic.ChannelConfig;
import com.chic.qh.service.logistic.LogisticService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isLessThanOrEqualTo;

/**
 * @Description: 报价
 * @author: xumingwei
 * @date: 2023—04—07 14:51
 */
@Service
@Transactional
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private LogisticService logisticService;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsQuoteDetailMapper goodsQuoteDetailMapper;
    @Autowired
    private GoodsQuoteMapper goodsQuoteMapper;

    @Data
    @AllArgsConstructor
    public static class CountryEntry{
        private String isoCode;
        private String cnName;
    }
    private static final List<CountryEntry> supportedCountries = Arrays.asList(
            new CountryEntry("US", "美国"),
            new CountryEntry("CA", "加拿大"),
            new CountryEntry("AU", "澳大利亚"),
            new CountryEntry("GB", "英国"),
            new CountryEntry("DE", "德国"),
            new CountryEntry("FR", "法国"),
            new CountryEntry("IT", "意大利"),
            new CountryEntry("IE", "爱尔兰"),
            new CountryEntry("IL", "以色列"),
            new CountryEntry("SE", "瑞典"),
            new CountryEntry("CH", "瑞士"),
            new CountryEntry("NZ", "新西兰"),
            new CountryEntry("BR", "巴西")
    );
    private static final Map<String, String> countryMap = supportedCountries.stream()
            .collect(Collectors.toMap( CountryEntry::getIsoCode, CountryEntry::getCnName ));

    @Override
    public List<String> supportedCountries(){
        return this.supportedCountries.stream().map(CountryEntry::getIsoCode).collect(Collectors.toList());
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
    public void saveQuote(GoodsQuoteDTO goodsQuoteDTO) {
        //将页面dto转换为po
        GoodsQuoteDTO.PoBuilder poBuilder = GoodsQuoteDTO.BuildPO(goodsQuoteDTO);
        GoodsQuote goodsQuote = poBuilder.getGoodsQuote();
        List<GoodsQuoteDetail> quoteList = poBuilder.getDetails();
        goodsQuoteMapper.insert(goodsQuote);
        quoteList.stream().forEach(x -> x.setQuoteId(goodsQuote.getRecId()));
        goodsQuoteDetailMapper.insertMultiple(quoteList);
    }



    @Override
    public GoodsQuote getQuoteVersion(Integer _goodsId) {
        return goodsQuoteMapper.selectOne(c -> c.where(GoodsQuoteDynamicSqlSupport.goodsId, isEqualTo(_goodsId))
                .orderBy(GoodsQuoteDynamicSqlSupport.version.descending())
                .limit(1)).orElse(null);
    }

    @Override
    public GoodsQuote getQuoteVersion(Integer _goodsId, Integer _orderTime) {
        return goodsQuoteMapper.selectOne(c -> c
                            .where(GoodsQuoteDynamicSqlSupport.goodsId, isEqualTo(_goodsId))
                            .and(GoodsQuoteDynamicSqlSupport.version, isLessThanOrEqualTo(String.valueOf(_orderTime)))
                            .orderBy(GoodsQuoteDynamicSqlSupport.version.descending())
                            .limit(1)
        ).orElse(null);
    }

    @Override
    public GoodsQuote getQuoteVersion(Integer _goodsId, String version) {
        return goodsQuoteMapper.selectOne(c -> c.where(GoodsQuoteDynamicSqlSupport.goodsId, isEqualTo(_goodsId))
                .and(GoodsQuoteDynamicSqlSupport.version, isEqualTo(version))
                .limit(1)).orElse(null);
    }

    @Override
    public GoodsQuoteDetail getQuoteDetails(SkuVO skuVO, String _country, Integer _quantity, Byte _channelType) {
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
                .and(GoodsQuoteDetailDynamicSqlSupport.channelType, isEqualTo(_channelType))
                .limit(1)).orElse(null);
    }

    @Override
    public GoodsQuoteDetail getQuoteDetails(SkuVO skuVO, String _country, Integer _quantity, Byte _channelType, String version) {
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
                .and(GoodsQuoteDetailDynamicSqlSupport.channelType, isEqualTo(_channelType))
                .limit(1)).orElse(null);
    }

    @Override
    public GoodsQuoteDetail getQuoteDetails(Integer _skuId, String _country, Integer _quantity, Byte _channelType, Integer _quoteId) {
        return goodsQuoteDetailMapper.selectOne(c -> c.where(GoodsQuoteDetailDynamicSqlSupport.skuId, isEqualTo(_skuId))
                .and(GoodsQuoteDetailDynamicSqlSupport.quoteId, isEqualTo(_quoteId))
                .and(GoodsQuoteDetailDynamicSqlSupport.country, isEqualTo(_country))
                .and(GoodsQuoteDetailDynamicSqlSupport.qty, isEqualTo(_quantity))
                .and(GoodsQuoteDetailDynamicSqlSupport.channelType, isEqualTo(_channelType))
                .limit(1)).orElse(null);
    }

    @Override
    public List<GoodsQuote> selectHistory(Integer _goodsId) {
        return goodsQuoteMapper.select(c -> c.where(GoodsQuoteDynamicSqlSupport.goodsId, isEqualTo(_goodsId))
                .orderBy(GoodsQuoteDynamicSqlSupport.version.descending()));
    }

    @Override
    public GoodsQuoteDTO buildQuote(GoodsVO goodsVo, String quoteName, String version){
        List<GoodsChannel> channels = goodsService.getGoodsChannelList(goodsVo.getGoodsId());
        if(CollectionUtils.isEmpty(channels)){
            throw new RuntimeException("商品没有配置渠道!goodsSn:" + goodsVo.getGoodsSn());
        }
        GoodsQuoteDTO dto = new GoodsQuoteDTO();
        dto.setGoodsId(goodsVo.getGoodsId());
        dto.setQuoteName(quoteName);
        dto.setVersion(version);

        List<QuoteDetailDTO> quoteList = new ArrayList<>();

        for (SkuVO skuVO : goodsVo.getSkuList()) {
            if(skuVO.getParentId() != 0){
                continue;
            }
            for (GoodsChannel channel : channels) {
                QuoteDetailDTO detailDTO = new QuoteDetailDTO();
                detailDTO.setSkuId(skuVO.getSkuId());
                detailDTO.setCountry(channel.getCountryCode());
                detailDTO.setChannelCode(channel.getChannelCode());
                detailDTO.setChannelType(channel.getChannelType());
                QuoteResult r1 = this.quote(channel.getCountryCode(), channel.getChannelCode(), goodsVo, skuVO, 1);
                detailDTO.setAmount1Pcs(r1.getTotalFee());
                QuoteResult r2 = this.quote(channel.getCountryCode(), channel.getChannelCode(), goodsVo, skuVO, 2);
                detailDTO.setAmount2Pcs(r2.getTotalFee());
                QuoteResult r3 = this.quote(channel.getCountryCode(), channel.getChannelCode(), goodsVo, skuVO, 3);
                detailDTO.setAmount3Pcs(r3.getTotalFee());

                detailDTO.setShippingTime(r3.getTime());

                quoteList.add(detailDTO);
            }
        }
        Assert.notEmpty(quoteList, "报价列表不能为空!");

        dto.setQuoteList(quoteList);
        dto.setGoodsVo(goodsVo);
        return dto;
    }

    @Override
    public GoodsQuoteDTO getQuoteDTO(GoodsVO goods, String version) {
        GoodsQuote quoteVersion;
        if("latest".equals(version)) {
            quoteVersion = goodsQuoteMapper.selectOne(c -> c.where(GoodsQuoteDynamicSqlSupport.goodsId, isEqualTo(goods.getGoodsId()))
                    .orderBy(GoodsQuoteDynamicSqlSupport.version.descending())
                    .limit(1)).orElse(null);
        }else{
            quoteVersion = goodsQuoteMapper.selectOne(c -> c.where(GoodsQuoteDynamicSqlSupport.goodsId, isEqualTo(goods.getGoodsId()))
                    .and(GoodsQuoteDynamicSqlSupport.version, isEqualTo(version))
                    .limit(1)).orElse(null);
        }
        if(quoteVersion == null){
            return null;
        }
        List<GoodsQuoteDetail> details = goodsQuoteDetailMapper.select(c ->
                c.where(GoodsQuoteDetailDynamicSqlSupport.quoteId, isEqualTo(quoteVersion.getRecId())));

        GoodsQuoteDTO.DtoBuilder builder = GoodsQuoteDTO.BuildDTO(goods);
        builder.setQuoteVersion(quoteVersion);
        builder.setQuoteList(details);
        //todo: 查询出报价明细并转换成dto
        return builder.build();
    }

    @Override
    public Optional<String> getQuotedCountry(GoodsQuote quoteVersion) {
        return goodsQuoteDetailMapper.selectOne(c -> c.where(GoodsQuoteDetailDynamicSqlSupport.quoteId, isEqualTo(quoteVersion.getRecId()))
                .limit(1)).map(x -> x.getCountry());
    }

}
