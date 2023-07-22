package com.chic.qh.service.quote.impl;

import com.chic.qh.configuration.AppConfig;
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

    @Override
    public QuoteResult quote(String country, String carrierCode, GoodsVO goodsVO, SkuVO skuVo, Integer quantity){
        ChannelConfig config = logisticService.getChannelConfig(carrierCode);
        VolumetricWeight volWeight = null;
        if(skuVo.getLength() != null && skuVo.getWidth() != null && skuVo.getHeight() != null) {
            volWeight = new VolumetricWeight(skuVo.getLength(), skuVo.getWidth(), skuVo.getHeight(),
                    config.getVolWeightRate(country).intValue());
        }
        BillingWeight billingWeight = BillingWeight.build(skuVo.getWeight(), volWeight);
        BigDecimal kg = new BigDecimal(billingWeight.getValue()).divide(new BigDecimal("1000"));
        LogisticChannelDetail detail = config.getConfig(country, kg);
        if(detail == null){
            throw new RuntimeException("找不到 线路[" +config.getLogisticChannel().getCode()+ "]中," +
                    "国家为[" +country+ "] 重量为[" + billingWeight.getValue() + "] 的物流价格数据，无法进行报价");
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
}
