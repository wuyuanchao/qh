package com.chic.qh.controller.order;

import com.chic.qh.service.order.OrderService;
import com.chic.qh.service.order.dto.OrderEditDTO;
import com.chic.qh.service.order.dto.OrderQueryDTO;
import com.chic.qh.service.order.vo.OrderListVO;
import com.chic.qh.support.web.RespWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: 订单
 * @author: xumingwei
 * @date: 2023—04—07 14:34
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单列表
     * @param dto
     * @return
     */
    @RespWrap
    @PostMapping("/list")
    public OrderListVO list(@RequestBody OrderQueryDTO dto) {
        return orderService.queryPagedList(dto);
    }
    /**
     * 订单列表导入
     * @param file
     * @return
     */
    @PostMapping("/orderImport")
    public void orderImport(@RequestParam("file") MultipartFile file) {
        orderService.processOrderImport(file);
    }

    /**
     * 订单列表
     * @param dto
     * @return
     */
    @RespWrap
    @PostMapping("/updateStatus")
    public void updateStatus(@RequestBody OrderEditDTO dto) {
        orderService.updateStatus(dto);
    }

}
