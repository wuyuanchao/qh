package com.chic.qh.service.quote;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class QuoteDetailDTO {
    public String getKeyId(){return skuId + "_" +country + "_" +channelCode+"_"+channelType;}

    private Integer skuId;
    private String country;
    private String channelCode;
    private Byte channelType;
    private String shippingTime;
    private BigDecimal amount1Pcs;
    private BigDecimal amount2Pcs;
    private BigDecimal amount3Pcs;
}
