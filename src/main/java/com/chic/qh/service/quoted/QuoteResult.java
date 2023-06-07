package com.chic.qh.service.quoted;

import java.math.BigDecimal;

/**
 * billingWeight	decimal(10, 3)
 * totalFee	decimal(10, 2)
 * baseFee	decimal(10, 2)
 * operationFee	decimal(10, 2)
 */
public class QuoteResult {

    private String carrierName;
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

    public QuoteResult(String carrierName, String productCode, Boolean isElectronic, Boolean isSpecial,
                       BigDecimal billingWeight, BigDecimal actWeight, BigDecimal volWeight, WeightType weightType,
                       BigDecimal totalFee, BigDecimal baseFee, BigDecimal operationFee, String time) {
        this.carrierName = carrierName;
        this.productCode = productCode;
        this.isElectronic = isElectronic;
        this.isSpecial = isSpecial;
        this.billingWeight = billingWeight;
        this.actWeight = actWeight;
        this.volWeight = volWeight;
        this.weightType = weightType;
        this.totalFee = totalFee;
        this.baseFee = baseFee;
        this.operationFee = operationFee;
        this.time = time;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Boolean getElectronic() {
        return isElectronic;
    }

    public void setElectronic(Boolean electronic) {
        isElectronic = electronic;
    }

    public Boolean getSpecial() {
        return isSpecial;
    }

    public void setSpecial(Boolean special) {
        isSpecial = special;
    }

    public BigDecimal getBillingWeight() {
        return billingWeight;
    }

    public void setBillingWeight(BigDecimal billingWeight) {
        this.billingWeight = billingWeight;
    }

    public BigDecimal getActWeight() {
        return actWeight;
    }

    public void setActWeight(BigDecimal actWeight) {
        this.actWeight = actWeight;
    }

    public BigDecimal getVolWeight() {
        return volWeight;
    }

    public void setVolWeight(BigDecimal volWeight) {
        this.volWeight = volWeight;
    }

    public WeightType getWeightType() {
        return weightType;
    }

    public void setWeightType(WeightType weightType) {
        this.weightType = weightType;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public BigDecimal getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(BigDecimal baseFee) {
        this.baseFee = baseFee;
    }

    public BigDecimal getOperationFee() {
        return operationFee;
    }

    public void setOperationFee(BigDecimal operationFee) {
        this.operationFee = operationFee;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "QuoteResult{" +
                "carrierName='" + carrierName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", isElectronic=" + isElectronic +
                ", isSpecial=" + isSpecial +
                ", billingWeight=" + billingWeight +
                ", actWeight=" + actWeight +
                ", volWeight=" + volWeight +
                ", weightType=" + weightType +
                ", totalFee=" + totalFee +
                ", baseFee=" + baseFee +
                ", operationFee=" + operationFee +
                ", time='" + time + '\'' +
                '}';
    }
}
