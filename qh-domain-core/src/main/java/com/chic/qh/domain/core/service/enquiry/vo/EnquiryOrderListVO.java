package com.chic.qh.domain.core.service.enquiry.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—07 15:26
 */
@Data
public class EnquiryOrderListVO {

    private Integer total;

    private List<EnquiryOrderVO> orderList;

    public EnquiryOrderListVO() {
    }

    public EnquiryOrderListVO(Integer total, List<EnquiryOrderVO> orderList) {
        this.total = total;
        this.orderList = orderList;
    }
}
