package com.chic.qh.service.settle.vo;

import com.chic.qh.repository.model.SettleOrderInfo;
import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—07 15:26
 */
@Data
public class SettleOrderListVO {

    private Long total;

    private List<SettleOrderInfo> settleOrderInfoList;

    public SettleOrderListVO() {
    }

    public SettleOrderListVO(Long total, List<SettleOrderInfo> settleOrderInfoList) {
        this.total = total;
        this.settleOrderInfoList = settleOrderInfoList;
    }
}
