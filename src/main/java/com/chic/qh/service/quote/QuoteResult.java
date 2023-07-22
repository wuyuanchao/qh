package com.chic.qh.service.quote;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * billingWeight	decimal(10, 3)
 * totalFee	decimal(10, 2)
 * baseFee	decimal(10, 2)
 * operationFee	decimal(10, 2)
 */
@Data
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

}
