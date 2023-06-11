package com.chic.qh.controller.quote;

import com.chic.qh.service.goods.vo.GoodsVO;
import com.chic.qh.service.quote.QuoteResult;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class QuoteRespDTO {
    private GoodsVO goodsVo;

    private String currentSku;
    private String country;
    private String currency;

    private QuoteResult result;

    private String availability;

}
