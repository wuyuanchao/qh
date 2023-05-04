package com.chic.qh.service.goods.vo;

import lombok.Data;

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

    private String goodsSn;

    private String remark;

    private String goodsImage;

    private List<SkuVO> skuList;

}
