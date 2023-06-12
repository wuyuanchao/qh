package com.chic.qh.controller.quote;

import com.chic.qh.service.goods.vo.GoodsVO;
import com.chic.qh.service.goods.vo.SkuVO;
import com.chic.qh.service.quote.QuoteResult;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class QuoteRespDTO {
    private GoodsVO goodsVo;

    private SkuVO currentSku;
    private String country;
    private Integer quantity;

    private QuoteResult result;

    private String availability;

}
