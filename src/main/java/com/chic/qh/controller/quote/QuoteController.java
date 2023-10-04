package com.chic.qh.controller.quote;

import com.chic.qh.repository.model.GoodsQuote;
import com.chic.qh.service.goods.GoodsService;
import com.chic.qh.service.goods.vo.GoodsVO;
import com.chic.qh.service.logistic.LogisticService;
import com.chic.qh.service.quote.ConfigDTO;
import com.chic.qh.service.quote.GoodsQuoteDTO;
import com.chic.qh.service.quote.QuoteService;
import com.chic.qh.support.web.RespWrap;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

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
    @Autowired
    private LogisticService logisticService;

    @RespWrap
    @GetMapping("/{goodsId}/history")
    public List<GoodsQuote> getGoodsQuoteHistory(@PathVariable("goodsId") Integer goodsId){
        if(!goodsService.exist(goodsId)){
            throw new HttpClientErrorException(NOT_FOUND, "goodsId: " + goodsId + " not found!");
        }
        return quoteService.selectHistory(goodsId);
    }

    @RespWrap
    @GetMapping("/{goodsSn}/list/{version}")
    public GoodsQuoteDTO getQuoteResult(@PathVariable("goodsSn") String goodsSn,
                                        @PathVariable("version") String version){
        GoodsVO goods = goodsService.getGoodsBySn(goodsSn);
        if("preview".equals(version)){
            return quoteService.buildQuote(goods, "preview", "preview");
        }else{
            return quoteService.getQuoteDTO(goods, version);
        }
    }

    @RespWrap
    @GetMapping("/config")
    public ConfigDTO getApplicationConfig(){
        return quoteService.getConfig();
    }

    @RespWrap
    @PutMapping("/config/{key}")
    public void updateConfig(@PathVariable("key") String key, @RequestBody QCUpdateDTO dto){
        quoteService.updateConfig(key, dto.getValue());
    }

    @RespWrap
    @GetMapping("/supportedCountries")
    public List<String> supportedCountries(){
        return quoteService.supportedCountries();
    }

    @RespWrap
    @PostMapping("/{goodsId}")
    public void saveQuote(@PathVariable("goodsId") Integer goodsId, @RequestBody GoodsQuoteDTO dto){
        Assert.isTrue(goodsId.equals(dto.getGoodsId()), "goodsId not match!");
        quoteService.saveQuote(dto);
    }
}
