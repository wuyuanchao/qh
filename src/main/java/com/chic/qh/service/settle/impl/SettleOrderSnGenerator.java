package com.chic.qh.service.settle.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class SettleOrderSnGenerator {

    /**
     * 长度15
     */
    private static final String SHORT_YEAR_TO_SECOND_FORMAT_STR = "yyMMddHHmmssSSS";

    /**
     * 长度36
     */
    private static final char[] NUMBERS_AND_LETTERS = ("0123456789QWERTYUIOPASDFGHJKLZXCVBNM").toCharArray();

    /**
     * 获取当前时间的格式化字符串形式
     *
     * @param format 时间格式
     * @return 指定格式的时间字符串
     */
    private static String getNowTimeFormatStr(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String result = sdf.format(new Date());
        sdf = null;
        return result;
    }

    /**
     * 获取指定位数的随机字符串
     *
     * @param length 位数
     * @return 随机字符串
     */
    private static String createRandomString(int length) {
        if (length < 1) {
            return "";
        }
        int nextIntMax = NUMBERS_AND_LETTERS.length - 1;
        Random random = new Random();
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = NUMBERS_AND_LETTERS[random.nextInt(nextIntMax)];
        }
        return new String(randBuffer);
    }

    public static String get(){
        return "JSD" + getNowTimeFormatStr(SHORT_YEAR_TO_SECOND_FORMAT_STR) + createRandomString(5);
    }
}
