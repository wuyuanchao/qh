package com.chic.qh.controller.enquiry;

import com.chic.qh.domain.core.result.ResponseEntity;
import com.chic.qh.domain.core.service.enquiry.EnquiryService;
import com.chic.qh.domain.core.service.enquiry.dto.*;
import com.chic.qh.domain.core.service.enquiry.vo.EnquiryOrderListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        enquiryService.updateGoodsSn(dto);
        return ResponseEntity.ok();
    }
}
