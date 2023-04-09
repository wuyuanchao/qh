package com.chic.qh.domain.core.service.enquiry.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—07 15:26
 */
@Data
public class EnquiryOrderVO {

    private Integer enquiryOrderId;

    private String customerName;

    private String customerLink;

    private Integer addTime;

    private List<EnquiryOrderGoodsVO> orderGoodsList;





}
