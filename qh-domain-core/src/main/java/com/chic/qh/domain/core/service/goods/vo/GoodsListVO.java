package com.chic.qh.domain.core.service.goods.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—07 15:26
 */
@Data
public class GoodsListVO {

    private Integer total;

    private List<GoodsVO> goodsList;

    public GoodsListVO() {
    }

    public GoodsListVO(Integer total, List<GoodsVO> goodsList) {
        this.total = total;
        this.goodsList = goodsList;
    }
}
