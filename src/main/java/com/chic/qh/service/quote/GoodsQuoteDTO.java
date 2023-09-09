package com.chic.qh.service.quote;

import lombok.Data;

import java.util.List;

@Data
public class GoodsQuoteDTO {
    private Integer recId;
    private String quoteName;
    private Integer goodsId;
    private String version;
    private Integer createdAt;

    List<QuoteDetailDTO> quoteList;
}
