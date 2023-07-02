package com.chic.qh.service.quote;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ConfigDTO {
    private BigDecimal exchangeRate;
    private BigDecimal operationFee;
    private BigDecimal amplifyRate;
}
