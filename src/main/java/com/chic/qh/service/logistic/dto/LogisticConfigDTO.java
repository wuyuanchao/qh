package com.chic.qh.service.logistic.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class LogisticConfigDTO {

    private Integer id;
    private String country;
    private String shippingTime;
    private BigDecimal volWeightRate;
    private List<Item> items;

    @Data
    public static class Item {
        private Integer id;
        private BigDecimal left;
        private BigDecimal right;
        private BigDecimal shippingFee;
        private BigDecimal extraFee;
    }

}
