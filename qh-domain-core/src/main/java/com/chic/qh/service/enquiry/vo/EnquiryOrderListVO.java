package com.chic.qh.service.enquiry.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—07 15:26
 */
@Data
public class EnquiryOrderListVO {

    private Long total;

    private List<EnquiryOrderVO> orderList;

    public EnquiryOrderListVO() {
    }

    public EnquiryOrderListVO(Long total, List<EnquiryOrderVO> orderList) {
        this.total = total;
        this.orderList = orderList;
    }
}
