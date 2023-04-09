package com.chic.qh.domain.core.service.enquiry.dto;

import lombok.Data;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—09 11:24
 */
@Data
public class EnquiryOrderUpdateDTO {

    private Integer enquiryOrderId;

    private Integer enquiryOrderGoodsId;

    private String goodsSn;

}
