package com.chic.qh.service.goods.dto;

import lombok.Data;

@Data
public class GoodsChannelRespDTO {
    private Integer goodsId;
    private String countryCode;
    private String channelCode;
    private String channelName;
}
