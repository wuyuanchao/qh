package com.chic.qh.service.logistic;

import com.chic.qh.repository.model.LogisticChannel;
import com.chic.qh.repository.model.LogisticChannelDetail;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChannelConfig {

    private LogisticChannel logisticChannel;

    private Map<String, RangeMap<BigDecimal, LogisticChannelDetail>> configMap;
    private Map<String, LogisticChannelDetailUniKey> keys;

    public ChannelConfig(LogisticChannel logisticChannel,
                         ArrayListMultimap<LogisticChannelDetailUniKey, LogisticChannelDetail> countryMap) {
        this.logisticChannel = logisticChannel;
        this.configMap = new HashMap();

        keys = countryMap.keySet().stream().collect(Collectors.toMap(x -> x.getCountry(), x -> x));
        for(LogisticChannelDetailUniKey countryCode : countryMap.keySet()){
            /**
             * 重量区间必须连续
             * 否则将导致总体区间包含间隔(gap)，从而在询价时，如果重量落在间隔上，报错时提示信息不能自洽
             * 比如：重量区间(0, 10], (15, 20] 那么总区间为 (0, 20], 如果询价时重量为 13，
             *  报错提示（明显是错误的提示）将为：OutOfRangeException: value: 13 out of range: (0..20]
             */
            List<LogisticChannelDetail> details = countryMap.get(countryCode);
            TreeRangeMap<BigDecimal, LogisticChannelDetail> trm = TreeRangeMap.create();
            details.stream().forEach(x -> {
                Range<BigDecimal> wr = Range.closedOpen(x.getWeightLeft(), x.getWeightRight());
                trm.put(wr, x);
            });
            configMap.put(countryCode.getCountry(), trm);
        }
    }

    public LogisticChannel getLogisticChannel() {
        return logisticChannel;
    }

    public Range<BigDecimal> getChannelWeightRange(String country) {
        return configMap.get(country).span();
    }

    public LogisticChannelDetail getConfig(String country, BigDecimal weight){
        if(!configMap.containsKey(country)) {
            return null;
        }
        return configMap.get(country).get(weight);
    }

    public BigDecimal getVolWeightRate(String country){
        return keys.get(country).getVolWeightRate();
    }
}
