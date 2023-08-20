package com.chic.qh.service.goods.vo;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—09 12:44
 */
@Data
public class GoodsVO {

    private Integer goodsId;

    private String goodsName;

    private String goodsNameEn;

    private String goodsSn;

    private String remark;

    private String remarkEn;

    private String goodsImage;

    private List<String> imageUrls;

    //商品类型(1-普通;2-带电;3-特货;)
    private Integer goodsType = 2;

    private String depot;

    private List<String> goodsTags; // = Arrays.asList("red", "blue");

    private List<SkuVO> skuList;

    private Byte availability;

    private String processingTime;

    private Byte status;
}
