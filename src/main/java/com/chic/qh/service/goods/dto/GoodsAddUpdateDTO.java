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

    private String goodsImage;

    //商品类型(1-普通;2-带电;3-特货;)
    private Integer goodsType;

    //收获仓库
    private String depot;

    private List<SkuAddUpdateDTO> skuList;


}
