package com.chic.qh.domain.core.service.goods.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—09 12:44
 */
@Data
public class SkuVO {

    private Integer goodsId;

    private Integer skuId;

    private String suppSkuId;

    private String skuName;

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

    //供应商名称
    private String suppName;

    //交付时间（天）
    private BigDecimal deliveryTime;

    //收货仓库
    private String depotName;

    private String remark;

}
