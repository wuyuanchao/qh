package com.chic.qh.service.enquiry.vo;

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

    private String enquiryOrderSn;

    private String enquiryOrderName;

    private String customerInfo;

    private String customerLink;

    private String remark;

    private Integer gmtCreated;

    private Integer gmtModify;

    private List<EnquiryOrderGoodsVO> orderGoodsList;





}
