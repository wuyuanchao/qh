package com.chic.qh.controller.settle;

import com.chic.qh.service.settle.SettleOrderService;
import com.chic.qh.service.settle.dto.SettleOrderDetailExcelVO;
import com.chic.qh.service.settle.dto.SettleOrderQueryDTO;
import com.chic.qh.service.settle.vo.SettleOrderListVO;
import com.chic.qh.support.utils.ExcelUtils;
import com.chic.qh.support.web.RespWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description: 结算单
 * @author: xumingwei
 * @date: 2023—09—17 16:34
 */
@RestController
@RequestMapping("/settleOrder")
public class SettleOrderController {

    @Autowired
    private SettleOrderService settleOrderService;

    /**
     * 结算单列表
     * @param dto
     * @return
     */
    @RespWrap
    @PostMapping("/list")
    public SettleOrderListVO list(@RequestBody SettleOrderQueryDTO dto) {
        return settleOrderService.queryPagedList(dto);
    }

    /**
     * 结算单明细导出
     * @param settleOrderId
     * @return
     */
    @PostMapping("exportSettleOrderDetailList/{settleOrderId}")
    public void exportSkuList(@PathVariable("settleOrderId") Integer settleOrderId, HttpServletResponse response) {
        //查询结算单明细列表
        List<SettleOrderDetailExcelVO> settleOrderDetailExcelVOList = settleOrderService.exportSettleOrderDetailList(settleOrderId);
        //导出结算单明细列表
        String fileName = "SettleOrderDetailListExport";
        ExcelUtils.exportExcel(settleOrderDetailExcelVOList, SettleOrderDetailExcelVO.class, fileName, response);
    }

}
