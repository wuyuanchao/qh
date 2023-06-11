package com.chic.qh.controller.quote;

import com.chic.qh.service.goods.GoodsService;
import com.chic.qh.service.goods.vo.GoodsVO;
import com.chic.qh.service.quote.QuoteService;
import com.chic.qh.support.web.RespWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 报价
 * @author: xumingwei
 * @date: 2023—04—07 14:30
 */
@RestController
@RequestMapping("/quote")
public class QuoteController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private QuoteService quoteService;
    @RespWrap
    @GetMapping("/{goodsSn}")
    public QuoteRespDTO quote(@PathVariable("goodsSn") String goodsSn) {
        GoodsVO goodsVO = goodsService.getGoodsBySn(goodsSn);
        QuoteRespDTO dto = new QuoteRespDTO();
        dto.setGoodsVo(goodsVO);
        dto.setCountry("US");
        dto.setResult(quoteService.quote("美国", goodsVO, goodsVO.getSkuList().get(0)));
        return dto;
    }

}
