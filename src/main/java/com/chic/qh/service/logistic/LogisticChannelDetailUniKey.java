package com.chic.qh.service.logistic;

import java.math.BigDecimal;
import java.util.Objects;

public class LogisticChannelDetailUniKey {
    private String country;
    private String shippingTime;
    private BigDecimal volWeightRate;

    public String getCountry() {
        return country;
    }

    public String getShippingTime() {
        return shippingTime;
    }

    public BigDecimal getVolWeightRate() {
        return volWeightRate;
    }

    public LogisticChannelDetailUniKey(String country, String shippingTime, BigDecimal volWeightRate) {
        this.country = country;
        this.shippingTime = shippingTime;
        this.volWeightRate = volWeightRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogisticChannelDetailUniKey that = (LogisticChannelDetailUniKey) o;
        return country.equals(that.country) &&
                shippingTime.equals(that.shippingTime) &&
                volWeightRate.compareTo(that.volWeightRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, shippingTime, volWeightRate);
    }

}
