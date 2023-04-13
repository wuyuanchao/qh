package com.chic.qh.controller.goods;

import com.chic.qh.result.ResponseEntity;
import com.chic.qh.service.goods.GoodsService;
import com.chic.qh.service.goods.dto.GoodsAddUpdateDTO;
import com.chic.qh.service.goods.dto.GoodsQueryDTO;
import com.chic.qh.service.goods.dto.SkuAddUpdateDTO;
import com.chic.qh.service.goods.dto.SkuQueryDTO;
import com.chic.qh.service.goods.vo.GoodsListVO;
import com.chic.qh.service.goods.vo.SkuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 商品
 * @author: xumingwei
 * @date: 2023—04—07 14:34
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 商品列表
     * @param dto
     * @return
     */
    @PostMapping("/list")
    public ResponseEntity list(@RequestBody GoodsQueryDTO dto) {
        GoodsListVO vo = goodsService.queryList(dto);
        return ResponseEntity.ok(vo);
    }

    /**
     * 添加商品
     * @param dto
     * @return
     */
    @PostMapping("/addGoods")
    public ResponseEntity addGoods(@RequestBody GoodsAddUpdateDTO dto) {
        goodsService.addGoods(dto);
        return ResponseEntity.ok();
    }

    /**
     * 编辑商品
     * @param dto
     * @return
     */
    @PostMapping("/updateGoods")
    public ResponseEntity updateGoods(@RequestBody GoodsAddUpdateDTO dto) {
        goodsService.updateGoods(dto);
        return ResponseEntity.ok();
    }

    /**
     * 删除商品
     * @param dto
     * @return
     */
    @PostMapping("/deleteGoods")
    public ResponseEntity deleteGoods(@RequestBody GoodsAddUpdateDTO dto) {
        goodsService.deleteGoods(dto);
        return ResponseEntity.ok();
    }

    /**
     * 查询商品sku列表
     * @param dto
     * @return
     */
    @PostMapping("/querySkuList")
    public ResponseEntity querySkuList(@RequestBody SkuQueryDTO dto) {
        List<SkuVO> voList = goodsService.querySkuList(dto);
        return ResponseEntity.ok(voList);
    }

    /**
     * 添加商品sku
     * @param dto
     * @return
     */
    @PostMapping("/addSku")
    public ResponseEntity addSku(@RequestBody SkuAddUpdateDTO dto) {
        goodsService.addSku(dto);
        return ResponseEntity.ok();
    }

    /**
     * 编辑商品sku
     * @param dto
     * @return
     */
    @PostMapping("/updateSku")
    public ResponseEntity updateSku(@RequestBody SkuAddUpdateDTO dto) {
        goodsService.updateSku(dto);
        return ResponseEntity.ok();
    }

    /**
     * 删除商品sku
     * @param dto
     * @return
     */
    @PostMapping("/deleteSku")
    public ResponseEntity deleteSku(@RequestBody SkuAddUpdateDTO dto) {
        goodsService.deleteSku(dto);
        return ResponseEntity.ok();
    }

}
