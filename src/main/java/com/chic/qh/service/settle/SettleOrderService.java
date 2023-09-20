package com.chic.qh.service.settle;

import com.chic.qh.repository.model.OrderInfo;
import com.chic.qh.service.settle.dto.SettleOrderDetailExcelVO;
import com.chic.qh.service.settle.dto.SettleOrderQueryDTO;
import com.chic.qh.service.settle.vo.SettleOrderListVO;

import java.util.List;

/**
 * @Description:
 * @author: Carney
 * @date: 2023-09-17 15:55
 */
public interface SettleOrderService {

    /**
     * 生成账单
     * @param orderInfoList
     */
    void createSettleOrder(List<OrderInfo> orderInfoList);


    /**
     * 结算单列表查询
     * @param dto
     * @return
     */
    SettleOrderListVO queryPagedList(SettleOrderQueryDTO dto);

    /**
     * 结算单明细导出查询
     * @param settleOrderId
     * @return
     */
    List<SettleOrderDetailExcelVO> exportSettleOrderDetailList(Integer settleOrderId);

}
