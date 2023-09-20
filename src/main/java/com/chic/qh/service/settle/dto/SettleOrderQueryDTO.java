package com.chic.qh.service.settle.dto;

import lombok.Data;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—09 11:24
 */
@Data
public class SettleOrderQueryDTO {

    private Integer current;
    private Integer pageSize;

    private String settleOrderSn;

    //创建时间查询
    private Integer gmtCreatedStart;
    private Integer gmtCreatedEnd;


}
