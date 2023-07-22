package com.chic.qh.service.goods.dto;

import lombok.Data;

@Data
public class GoodsChannelConfigUpdateDTO {
    private Integer goodsId;
    private String channelCode;
    private String countryCode;
}
