package com.chic.qh.controller.enquiry;

import com.chic.qh.result.ResponseEntity;
import com.chic.qh.service.enquiry.EnquiryService;
import com.chic.qh.service.enquiry.dto.*;
import com.chic.qh.service.enquiry.vo.EnquiryOrderListVO;
import com.chic.qh.service.enquiry.vo.EnquiryOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

/**
 * @Description: 询价
 * @author: xumingwei
 * @date: 2023—04—07 14:34
 */
@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

    @Autowired
    private EnquiryService enquiryService;

    /**
     * 询价单列表
     * @param dto
     * @return
     */
    @PostMapping("/list")
    public ResponseEntity list(@RequestBody EnquiryOrderQueryDTO dto) {
        EnquiryOrderListVO vo = enquiryService.queryList(dto);
        return ResponseEntity.ok(vo);
    }

    /**
     * 查询询价单详情
     * @param enquiryOrderId
     * @return
     */
    @GetMapping("/detail/{enquiryOrderId}")
    public ResponseEntity detail(@PathVariable Integer enquiryOrderId){
        EnquiryOrderVO vo = enquiryService.queryDetailById(enquiryOrderId);
        return ResponseEntity.ok(vo);
    }

    /**
     * 新建询价单
     * @param dto
     * @return
     */
    @PostMapping("/addEnquiryOrder")
    public ResponseEntity addEnquiryOrder(@RequestBody EnquiryOrderAddDTO dto) {
        enquiryService.addEnquiryOrder(dto);
        return ResponseEntity.ok();
    }

    /**
     * 添加询价单商品
     * @param dto
     * @return
     */
    @PostMapping("/addEnquiryOrderGoods")
    public ResponseEntity addEnquiryOrderGoods(@RequestBody EnquiryOrderGoodsAddDTO dto) {
        enquiryService.addEnquiryOrderGoods(dto);
        return ResponseEntity.ok();
    }

    /**
     * 删除询价单商品
     * @param dto
     * @return
     */
    @PostMapping("/deleteEnquiryOrderGoods")
    public ResponseEntity deleteEnquiryOrderGoods(@RequestBody EnquiryOrderGoodsDeleteDTO dto) {
        enquiryService.deleteEnquiryOrderGoods(dto);
        return ResponseEntity.ok();
    }

    /**
     * 更新询价单商品sn
     * @param dto
     * @return
     */
    @PostMapping("/updateGoodsSn")
    public ResponseEntity updateGoodsSn(@RequestBody EnquiryOrderUpdateDTO dto) {
        try {
            enquiryService.updateGoodsSn(dto);
            return ResponseEntity.ok();
        }catch (NoSuchElementException e){
            return ResponseEntity.error(e.getMessage());
        }
    }
}
