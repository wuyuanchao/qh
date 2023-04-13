package com.chic.qh.service.goods.dto;

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

    private String remark;

    private List<SkuAddUpdateDTO> skuList;


}
