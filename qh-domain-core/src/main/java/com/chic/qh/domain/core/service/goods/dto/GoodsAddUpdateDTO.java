package com.chic.qh.domain.core.service.goods.dto;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—09 12:45
 */
@Data
public class GoodsAddUpdateDTO {

    private Integer goodsId;

    private String goodsName;

    private String goodsSn;

    private String link;

    private List<SkuAddUpdateDTO> skuList;


}
