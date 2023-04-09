package com.chic.qh.domain.core.service.goods.vo;

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

    private String link;

    private List<SkuVO> skuList;

}
