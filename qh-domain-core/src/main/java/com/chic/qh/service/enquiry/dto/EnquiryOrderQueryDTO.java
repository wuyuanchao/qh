package com.chic.qh.service.enquiry.dto;

import lombok.Data;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—09 11:24
 */
@Data
public class EnquiryOrderQueryDTO {

    private Integer current;
    private Integer pageSize;

    private Integer enquiryOrderId;

    private String enquiryOrderSn;

    private String enquiryOrderName;

    private String customerInfo;


}
