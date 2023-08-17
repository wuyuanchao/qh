package com.chic.qh.service.order.vo;

import com.chic.qh.repository.model.OrderInfo;
import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—07 15:26
 */
@Data
public class OrderListVO {

    private Long total;

    private List<OrderInfo> orderList;

    public OrderListVO() {
    }

    public OrderListVO(Long total, List<OrderInfo> orderList) {
        this.total = total;
        this.orderList = orderList;
    }
}
