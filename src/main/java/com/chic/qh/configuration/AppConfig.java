package com.chic.qh.configuration;

import com.chic.qh.repository.mapper.ApplicationConfigDynamicSqlSupport;
import com.chic.qh.repository.mapper.ApplicationConfigMapper;
import com.chic.qh.repository.model.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Component
public class AppConfig {
    @Autowired
    private ApplicationConfigMapper applicationConfigMapper;

    private BigDecimal exchangeRate;
    private BigDecimal operationFee;
    private BigDecimal amplifyRate;

    @PostConstruct
    public void init(){
        Map<String, String> configMap = applicationConfigMapper
                .select(c ->c.orderBy(ApplicationConfigDynamicSqlSupport.recId.descending()))
                .stream()
                .collect(Collectors.toMap(ApplicationConfig::getConfigKey, ApplicationConfig::getConfigContent));
        exchangeRate = Optional.ofNullable(configMap.get("exchange_rate")).map(BigDecimal::new)
                .orElseThrow(() -> new RuntimeException("exchange_rate has not config"));
        operationFee = Optional.ofNullable(configMap.get("operation_fee")).map(BigDecimal::new)
                .orElseThrow(() -> new RuntimeException("operation_fee has not config"));
        amplifyRate = Optional.ofNullable(configMap.get("amplify_rate")).map(BigDecimal::new)
                .orElseThrow(() -> new RuntimeException("amplify_rate has not config"));
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public BigDecimal getOperationFee() {
        return operationFee;
    }

    public BigDecimal getAmplifyRate() {
        return amplifyRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        updateConfig("exchange_rate", exchangeRate.toString());
        this.exchangeRate = exchangeRate;
    }

    public void setOperationFee(BigDecimal operationFee) {
        updateConfig("operation_fee", operationFee.toString());
        this.operationFee = operationFee;
    }

    public void setAmplifyRate(BigDecimal amplifyRate) {
        updateConfig("amplify_rate", amplifyRate.toString());
        this.amplifyRate = amplifyRate;
    }

    private void updateConfig(String configKey, String configContent){
        ApplicationConfig applicationConfig = applicationConfigMapper
                .selectOne(c -> c.where(ApplicationConfigDynamicSqlSupport.configKey, isEqualTo(configKey)))
                .orElseThrow(() -> new RuntimeException(configKey + " has not config"));
        applicationConfig.setConfigContent(configContent);
        applicationConfig.setUpdatedAt((int) Instant.now().getEpochSecond());
        applicationConfigMapper.updateByPrimaryKey(applicationConfig);
    }
}
