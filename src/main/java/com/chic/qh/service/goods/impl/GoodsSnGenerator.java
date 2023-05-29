package com.chic.qh.service.goods.impl;

import org.apache.commons.lang3.RandomUtils;

public class GoodsSnGenerator {
    private String ALPHA = "ABCDEFGHJKMNPQRSTUVWXYZ23456789";
    private int snLength = 10;

    public GoodsSnGenerator(){}

    public GoodsSnGenerator(int snLength) {
        this.snLength = snLength;
    }

    public String get(){
        StringBuffer sn = new StringBuffer(snLength);
        //第一位不以数字开始
        char firstChar = ALPHA.charAt(RandomUtils.nextInt(0, ALPHA.length() - 8 ));
        sn.append(firstChar);
        for(int i=1;i<snLength;i++){
            int r = RandomUtils.nextInt(0, ALPHA.length());
            sn.append(ALPHA.charAt(r));
        }
        return sn.toString();
    }
}
