package com.chic.qh.service.goods.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—09 12:45
 */
@Data
public class SkuAddUpdateDTO {

    private Integer skuId;

    private Integer goodsId;

    private String skuName;

    private String skuNameEn;

    //供应商名称
    private String suppName;

    private String suppSkuId;

    private String link;

    //长度（cm）
    private Integer length;

    private Integer width;

    private Integer height;

    //面积
    private BigDecimal area;
    //重量
    private BigDecimal weight;
    //体积重
    private BigDecimal volumeWeight;
    //采购价
    private BigDecimal purPrice;

    private String color;

    private String size;

    private String remark;

    private String skuImage;


}
