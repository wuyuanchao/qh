package com.chic.qh.service.quote.impl;

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

/**
 * @Description: 报价
 * @author: xumingwei
 * @date: 2023—04—07 14:51
 */
@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private LogisticService logisticService;

    @Override
    public QuoteResult quote(String country, GoodsVO goodsVO, SkuVO skuVo){
        ChannelConfig config = logisticService.getChannelConfig(13);
        VolumetricWeight volWeight = null;
        if(skuVo.getLength() != null && skuVo.getWidth() != null && skuVo.getHeight() != null) {
            volWeight = new VolumetricWeight(skuVo.getLength(), skuVo.getWidth(), skuVo.getHeight(),
                    config.getVolWeightRate(country).intValue());
        }
        BillingWeight billingWeight = BillingWeight.build(skuVo.getWeight(), volWeight);
        LogisticChannelDetail detail = config.getConfig(country, new BigDecimal(billingWeight.getValue()));

        BigDecimal shippingFee = detail.getShippingFee()
                .multiply(new BigDecimal(billingWeight.getValue()).divide(new BigDecimal("100")))
                .add(detail.getExtraFee())
                .add(new BigDecimal("3"));
        BigDecimal cost = skuVo.getPurPrice().add(shippingFee);
        LogisticChannel channel = config.getLogisticChannel();
        QuoteResult result = new QuoteResult(channel.getCompany(), skuVo.getSkuName(), false, false,
                new BigDecimal(billingWeight.getValue()),
                new BigDecimal(billingWeight.getActWeight()),
                new BigDecimal(billingWeight.getVolWeight()),
                billingWeight.getWeightType(),
                cost, skuVo.getPurPrice(), shippingFee, detail.getShippingTime());
        return result;
    }
}
