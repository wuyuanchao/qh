package com.chic.qh.service.goods.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—07 15:26
 */
@Data
public class GoodsListVO {

    private Long total;

    private List<GoodsVO> goodsList;

    public GoodsListVO() {
    }

    public GoodsListVO(Long total, List<GoodsVO> goodsList) {
        this.total = total;
        this.goodsList = goodsList;
    }
}
