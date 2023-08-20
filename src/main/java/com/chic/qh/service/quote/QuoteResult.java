package com.chic.qh.service.quote;

import com.chic.qh.repository.model.GoodsQuoteDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * billingWeight	decimal(10, 3)
 * totalFee	decimal(10, 2)
 * baseFee	decimal(10, 2)
 * operationFee	decimal(10, 2)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuoteResult {
    private String carrierCompany;
    private String carrierCode;
    private String productCode;
    private Boolean isElectronic;
    private Boolean isSpecial;

    private BigDecimal billingWeight;
    private BigDecimal actWeight;
    private BigDecimal volWeight;
    private WeightType weightType;

    private BigDecimal totalFee;
    private BigDecimal baseFee;
    private BigDecimal operationFee;

    private String time;

    public GoodsQuoteDetail convert2PO(int skuId, String country, int qty, String version){
        GoodsQuoteDetail quote = new GoodsQuoteDetail();
        quote.setSkuId(skuId);
        quote.setQty(qty);
        quote.setCountry(country);
        quote.setShippingChannel(carrierCode);
        quote.setAmount(totalFee);
        quote.setProductCost(baseFee);
        quote.setShippingCost(operationFee);
        quote.setWeightType(weightType);
        quote.setActWeight(actWeight);
        quote.setVolWeight(volWeight);
        quote.setShippingTime(time);
        quote.setCreatedAt((int)Instant.now().getEpochSecond());
        return quote;
    }

}
