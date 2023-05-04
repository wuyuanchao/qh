package com.chic.qh.controller.enquiry;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.chic.qh.result.ResponseEntity;
import com.chic.qh.service.enquiry.EnquiryService;
import com.chic.qh.service.enquiry.dto.*;
import com.chic.qh.service.enquiry.vo.EnquiryOrderGoodsVO;
import com.chic.qh.service.enquiry.vo.EnquiryOrderListVO;
import com.chic.qh.service.enquiry.vo.EnquiryOrderVO;
import com.chic.qh.service.goods.GoodsService;
import com.chic.qh.service.goods.vo.GoodsVO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    @Autowired
    private GoodsService goodsService;
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

    @GetMapping("/export/{id}")
    public void export(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        EnquiryOrderVO vo = enquiryService.queryDetailById(id);

        List<String> goodsSnList = vo.getOrderGoodsList().stream()
                .map(EnquiryOrderGoodsVO::getGoodsSn)
                .filter(x -> StringUtils.hasText(x))
                .collect(Collectors.toList());

        Map<String, GoodsVO> goodsIdx = goodsService.selectBySnList(goodsSnList).stream()
                .collect(Collectors.toMap(GoodsVO::getGoodsSn, Function.identity()));

        List<EnquiryOrderExportItem> exports = new ArrayList<>();
        for(EnquiryOrderGoodsVO o : vo.getOrderGoodsList()){
            GoodsVO g = goodsIdx.get(o.getGoodsSn());
            if(g == null || CollectionUtils.isEmpty(g.getSkuList())){
                exports.add(new EnquiryOrderExportItem(o.getGoodsName(), o.getLink()));
            }else{
                exports.addAll(g.getSkuList().stream().map(x -> new EnquiryOrderExportItem(o.getGoodsName(), o.getLink(), o.getRemark(),
                        x.getSkuName(), x.getLink(), x.getPurPrice(), x.getLength(), x.getWidth(), x.getHeight()))
                        .collect(Collectors.toList()));
            }
        }

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode(vo.getEnquiryOrderSn(), "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), EnquiryOrderExportItem.class)
                .sheet("模板")
                .doWrite(exports);
    }

    @Data
    @ColumnWidth(20)
    public static class EnquiryOrderExportItem{
        @ExcelProperty("客户名称")
        private String customerGoodsName;
        @ExcelProperty("客户链接")
        @ColumnWidth(40)
        private String customerGoodsLink;
        @ExcelProperty("备注")
        private String remark;
        @ExcelProperty("商品名称")
        private String goodsName;
        @ExcelProperty("商品链接")
        private String goodsLink;
        @ExcelProperty("采购价(元)")
        private BigDecimal price;
        @ExcelProperty("长")
        private Integer length;
        @ExcelProperty("宽")
        private Integer width;
        @ExcelProperty("高")
        private Integer height;

        public EnquiryOrderExportItem() {
        }

        public EnquiryOrderExportItem(String customerGoodsName, String customerGoodsLink) {
            this.customerGoodsName = customerGoodsName;
            this.customerGoodsLink = customerGoodsLink;
        }

        public EnquiryOrderExportItem(String customerGoodsName, String customerGoodsLink, String remark, String goodsName, String goodsLink, BigDecimal price, Integer length, Integer width, Integer height) {
            this.customerGoodsName = customerGoodsName;
            this.customerGoodsLink = customerGoodsLink;
            this.remark = remark;
            this.goodsName = goodsName;
            this.goodsLink = goodsLink;
            this.price = price;
            this.length = length;
            this.width = width;
            this.height = height;
        }
    }
}
