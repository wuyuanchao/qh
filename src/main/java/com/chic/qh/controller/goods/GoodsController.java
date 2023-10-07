package com.chic.qh.controller.goods;

import com.chic.qh.service.goods.GoodsService;
import com.chic.qh.service.goods.dto.*;
import com.chic.qh.service.goods.vo.GoodsListVO;
import com.chic.qh.service.goods.vo.GoodsVO;
import com.chic.qh.service.goods.vo.SkuVO;
import com.chic.qh.support.utils.ExcelUtils;
import com.chic.qh.support.web.RespWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
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
    @RespWrap
    @PostMapping("/list")
    public GoodsListVO list(@RequestBody GoodsQueryDTO dto) {
        return goodsService.queryList(dto);
    }
    @RespWrap
    @GetMapping("/detail/{goodsSn}")
    public GoodsVO getGoodsDetail(@PathVariable("goodsSn") String goodsSn){
        return goodsService.getGoodsBySn(goodsSn);
    }

    /**
     * 添加商品
     * @param dto
     * @return
     */
    @RespWrap
    @PostMapping("/addGoods")
    public void addGoods(@RequestBody GoodsAddUpdateDTO dto) {
        goodsService.addGoods(dto);
    }

    /**
     * 编辑商品
     * @param dto
     * @return
     */
    @RespWrap
    @PostMapping("/updateGoods")
    public void updateGoods(@RequestBody GoodsAddUpdateDTO dto) {
        goodsService.updateGoods(dto);
    }

    /**
     * 删除商品
     * @param dto
     * @return
     */
    @RespWrap
    @PostMapping("/deleteGoods")
    public void deleteGoods(@RequestBody GoodsAddUpdateDTO dto) {
        goodsService.deleteGoods(dto);
    }

    /**
     * 查询商品sku列表
     * @param dto
     * @return
     */
    @RespWrap
    @PostMapping("/querySkuList")
    public List<SkuVO> querySkuList(@RequestBody SkuQueryDTO dto) {
        return goodsService.querySkuList(dto);
    }

    /**
     * 添加商品sku
     * @param dto
     * @return
     */
    @RespWrap
    @PostMapping("/addSku")
    public void addSku(@RequestBody SkuAddUpdateDTO dto) {
        goodsService.addSku(dto);
    }

    /**
     * 编辑商品sku
     * @param dto
     * @return
     */
    @RespWrap
    @PostMapping("/updateSku")
    public void updateSku(@RequestBody SkuAddUpdateDTO dto) {
        goodsService.updateSku(dto);
    }

    /**
     * 删除商品sku
     * @param dto
     * @return
     */
    @RespWrap
    @PostMapping("/deleteSku")
    public void deleteSku(@RequestBody SkuAddUpdateDTO dto) {
        goodsService.deleteSku(dto);
    }

    @RespWrap
    @GetMapping("/{goodsId}/comments")
    public List<GoodsCommentDTO> getGoodsComments(@PathVariable("goodsId") Integer goodsId, Authentication authentication){
        return goodsService.getGoodsComments(goodsId, authentication.getName());
    }

    @RespWrap
    @PostMapping("/{goodsId}/comments")
    public void addGoodsComments(@PathVariable("goodsId") Integer goodsId,
                                 @RequestBody GoodsCommentDTO comment,
                                 Authentication authentication){
        comment.setUser(authentication.getName());
        goodsService.addComment(comment);
    }

    @RespWrap
    @PostMapping("/deleteComment")
    public void deleteGoodsComment(@RequestBody GoodsCommentDTO comment, Authentication authentication){
        goodsService.deleteComment(comment.getRecId(), authentication.getName());
    }

    /**
     * Sku列表导出
     * @param goodsId
     * @param response
     */
    @PostMapping("exportSkuList/{goodsId}")
    public void exportSkuList(@PathVariable("goodsId") Integer goodsId, HttpServletResponse response) {
        //查询sku列表
        List<SkuListExcelVO> skuListExcelVOList = goodsService.exportSkuList(goodsId);
        //导出sku列表
        String fileName = "SkuListExport";
        ExcelUtils.exportExcel(skuListExcelVOList, SkuListExcelVO.class, fileName, response);
    }

    @RespWrap
    @PostMapping("/channels/config")
    public int editOrUpdateGoodsChannel(@RequestBody List<GoodsChannelConfigUpdateDTO> channelConfigs){
        return goodsService.batchUpdateGoodsChannel(channelConfigs);
    }

    @RespWrap
    @DeleteMapping("/{goodsId}/channels/{countryCode}")
    public int deleteGoodsChannel(@PathVariable("goodsId") Integer goodsId, @PathVariable("countryCode") String countryCode){
        return goodsService.deleteGoodsChannel(goodsId, countryCode);
    }

    @RespWrap
    @GetMapping("/{goodsId}/channels")
    public List<GoodsChannelRespDTO> getGoodsChannelList(@PathVariable("goodsId") Integer goodsId){
        return goodsService.getGoodsChannelDTOList(goodsId);
    }

    @PostMapping("/skuImport")
    public void orderImport(@RequestParam("file") MultipartFile file) {
        goodsService.importSku(file);
    }

}
