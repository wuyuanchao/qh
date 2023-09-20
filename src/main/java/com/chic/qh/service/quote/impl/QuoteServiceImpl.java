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
        Integer now = (int)Instant.now().getEpochSecond();
        GoodsQuote goodsQuote = new GoodsQuote();
        goodsQuote.setGoodsId(goodsQuoteDTO.getGoodsId());
        goodsQuote.setVersion(goodsQuoteDTO.getVersion());
        goodsQuote.setQuoteName(goodsQuoteDTO.getQuoteName());
        goodsQuote.setCreatedAt((int) Instant.now().getEpochSecond());
        goodsQuoteMapper.insert(goodsQuote);
        List<QuoteDetailDTO> detailDTOList = goodsQuoteDTO.getQuoteList();
        List<GoodsQuoteDetail> quoteList = detailDTOList.stream().flatMap(x -> {
            GoodsQuoteDetail detail1 = new GoodsQuoteDetail();
            GoodsQuoteDetail detail2 = new GoodsQuoteDetail();
            GoodsQuoteDetail detail3 = new GoodsQuoteDetail();
            detail1.setAmount(x.getAmount1Pcs());
            detail1.setSkuId(x.getSkuId());
            detail1.setShippingChannel(x.getChannelCode());
            detail1.setCountry(x.getCountry());
            detail1.setChannelType(x.getChannelType());
            detail1.setQty(1);
            detail1.setShippingTime(x.getShippingTime());
            detail1.setActWeight(BigDecimal.ZERO);
            detail1.setVolWeight(BigDecimal.ZERO);
            detail1.setWeightType(WeightType.ACTUAL_WEIGHT);
            detail1.setProductCost(BigDecimal.ZERO);
            detail1.setShippingCost(BigDecimal.ZERO);
            detail1.setQuoteId(goodsQuote.getRecId());
            detail1.setCreatedAt(now);

            detail2.setAmount(x.getAmount2Pcs());
            detail2.setSkuId(x.getSkuId());
            detail2.setShippingChannel(x.getChannelCode());
            detail2.setCountry(x.getCountry());
            detail2.setChannelType(x.getChannelType());
            detail2.setQty(2);
            detail2.setShippingTime(x.getShippingTime());
            detail2.setActWeight(BigDecimal.ZERO);
            detail2.setVolWeight(BigDecimal.ZERO);
            detail2.setWeightType(WeightType.ACTUAL_WEIGHT);
            detail2.setProductCost(BigDecimal.ZERO);
            detail2.setShippingCost(BigDecimal.ZERO);
            detail2.setQuoteId(goodsQuote.getRecId());
            detail2.setCreatedAt(now);

            detail3.setAmount(x.getAmount3Pcs());
            detail3.setSkuId(x.getSkuId());
            detail3.setShippingChannel(x.getChannelCode());
            detail3.setCountry(x.getCountry());
            detail3.setChannelType(x.getChannelType());
            detail3.setQty(3);
            detail3.setShippingTime(x.getShippingTime());
            detail3.setActWeight(BigDecimal.ZERO);
            detail3.setVolWeight(BigDecimal.ZERO);
            detail3.setWeightType(WeightType.ACTUAL_WEIGHT);
            detail3.setProductCost(BigDecimal.ZERO);
            detail3.setShippingCost(BigDecimal.ZERO);
            detail3.setQuoteId(goodsQuote.getRecId());
            detail3.setCreatedAt(now);

            return Arrays.asList(detail1, detail2, detail3).stream();
        }).collect(Collectors.toList());

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
    public GoodsQuoteDTO createQuote(GoodsVO goods, String quoteName, String version){
        List<GoodsChannel> channels = goodsService.getGoodsChannelList(goods.getGoodsId());
        if(CollectionUtils.isEmpty(channels)){
            throw new RuntimeException("商品没有配置渠道!goodsSn:" + goods.getGoodsSn());
        }
        GoodsQuoteDTO dto = new GoodsQuoteDTO();
        dto.setGoodsId(goods.getGoodsId());
        dto.setQuoteName(quoteName);
        dto.setVersion(version);

        List<QuoteDetailDTO> quoteList = new ArrayList<>();

        for (SkuVO skuVO : goods.getSkuList()) {
            if(skuVO.getParentId() != 0){
                continue;
            }
            for (GoodsChannel channel : channels) {
                QuoteDetailDTO detailDTO = new QuoteDetailDTO();
                detailDTO.setSkuId(skuVO.getSkuId());
                detailDTO.setCountry(channel.getCountryCode());
                detailDTO.setChannelCode(channel.getChannelCode());
                detailDTO.setChannelType(channel.getChannelType());
                QuoteResult r1 = this.quote(channel.getCountryCode(), channel.getChannelCode(), goods, skuVO, 1);
                detailDTO.setAmount1Pcs(r1.getTotalFee());
                QuoteResult r2 = this.quote(channel.getCountryCode(), channel.getChannelCode(), goods, skuVO, 2);
                detailDTO.setAmount2Pcs(r2.getTotalFee());
                QuoteResult r3 = this.quote(channel.getCountryCode(), channel.getChannelCode(), goods, skuVO, 3);
                detailDTO.setAmount3Pcs(r3.getTotalFee());

                detailDTO.setShippingTime(r3.getTime());

                quoteList.add(detailDTO);
            }
        }
        Assert.notEmpty(quoteList, "报价列表不能为空!");

        dto.setQuoteList(quoteList);
        return dto;
    }

    @Override
    public GoodsQuoteDTO getQuoteDTO(Integer goodsId, String version) {
        GoodsQuote quoteVersion;
        if("latest".equals(version)) {
            quoteVersion = goodsQuoteMapper.selectOne(c -> c.where(GoodsQuoteDynamicSqlSupport.goodsId, isEqualTo(goodsId))
                    .orderBy(GoodsQuoteDynamicSqlSupport.version.descending())
                    .limit(1)).orElse(null);
        }else{
            quoteVersion = goodsQuoteMapper.selectOne(c -> c.where(GoodsQuoteDynamicSqlSupport.goodsId, isEqualTo(goodsId))
                    .and(GoodsQuoteDynamicSqlSupport.version, isEqualTo(version))
                    .limit(1)).orElse(null);
        }
        if(quoteVersion == null){
            return null;
        }
        GoodsQuoteDTO dto = new GoodsQuoteDTO();
        dto.setRecId(quoteVersion.getRecId());
        dto.setGoodsId(quoteVersion.getGoodsId());
        dto.setQuoteName(quoteVersion.getQuoteName());
        dto.setVersion(quoteVersion.getVersion());
        dto.setCreatedAt(quoteVersion.getCreatedAt());

        //todo: 查询出报价明细并转换成dto
        return dto;
    }

    @Override
    public Optional<String> getQuotedCountry(GoodsQuote quoteVersion) {
        return goodsQuoteDetailMapper.selectOne(c -> c.where(GoodsQuoteDetailDynamicSqlSupport.quoteId, isEqualTo(quoteVersion.getRecId()))
                .limit(1)).map(x -> x.getCountry());
    }

}
