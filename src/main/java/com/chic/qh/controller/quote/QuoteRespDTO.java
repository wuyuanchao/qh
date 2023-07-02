package com.chic.qh.controller.quote;

import com.chic.qh.service.goods.vo.GoodsVO;
import com.chic.qh.service.goods.vo.SkuVO;
import com.chic.qh.service.quote.QuoteResult;
import lombok.Data;

@Data
public class QuoteRespDTO {
    private GoodsVO goodsVo;

    private SkuVO currentSku;
    private String country;
    private Integer quantity;

    private QuoteResult result;

    private Byte availability;
    private String referenceUrl;
    private String processingTime;
}
