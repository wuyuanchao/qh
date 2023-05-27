package com.chic.qh.service.enquiry.impl;

import org.apache.commons.lang3.RandomUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderSnGenerator {
    private String ALPHA = "ABCDEFGHJKMNPQRSTUVWXYZ23456789";
    private String PRE = "JC";
    private DateTimeFormatter datetimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public OrderSnGenerator(){}

    public String get(){
        return PRE + datetimeFormatter.format(LocalDateTime.now()) + getSuffix();
    }

    private String getSuffix(){
        StringBuffer sn = new StringBuffer(4);
        for(int i=0;i<4;i++){
            int r = RandomUtils.nextInt(0, ALPHA.length());
            sn.append(ALPHA.charAt(r));
        }
        return sn.toString();
    }
}
