package com.chic.qh.service.order.dto;

import lombok.Data;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—09 11:24
 */
@Data
public class OrderQueryDTO {

    private Integer current;
    private Integer pageSize;

    private String orderSn;
    private String trackingNumber;
    private String phoneNumber;

    private Byte status;

    //创建时间查询
    private Integer gmtCreatedStart;
    private Integer gmtCreatedEnd;


}
