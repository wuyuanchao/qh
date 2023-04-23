package com.chic.qh.service.goods.dto;

import lombok.Data;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—09 11:24
 */
@Data
public class GoodsQueryDTO {

    private Integer current;
    private Integer pageSize;

    private Integer goodsId;


}
