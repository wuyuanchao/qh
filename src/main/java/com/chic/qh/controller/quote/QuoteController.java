package com.chic.qh.controller.quote;

import com.chic.qh.repository.model.*;
import com.chic.qh.service.goods.GoodsService;
import com.chic.qh.service.quote.GoodsQuoteDTO;
import com.chic.qh.service.goods.vo.GoodsVO;
import com.chic.qh.service.goods.vo.SkuVO;
import com.chic.qh.service.logistic.ChannelConfig;
import com.chic.qh.service.logistic.LogisticService;
import com.chic.qh.service.quote.ConfigDTO;
import com.chic.qh.service.quote.QuoteResult;
import com.chic.qh.service.quote.QuoteService;
import com.chic.qh.support.web.RespWrap;
import io.jsonwebtoken.lang.Assert;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
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
            return quoteService.createQuote(goods, "preview", "preview");
        }else{
            return quoteService.getQuoteDTO(goods.getGoodsId(), version);
        }
    }

    @RespWrap
    @GetMapping("/{goodsSn}/preview")
    public QuoteRespDTO preview(@PathVariable("goodsSn") String goodsSn,
                                @RequestParam(name = "country", defaultValue = "US") String country,
                                @RequestParam(name = "quantity", defaultValue="1") Integer quantity,
                                @RequestParam(value = "skuId", required = false) Integer skuId,
                                @RequestParam(value = "channelType", defaultValue = "1") Byte channelType){
        return getQuoteResult(goodsSn, skuId, country, quantity, channelType, true);
    }

    @RespWrap
    @GetMapping("/{goodsSn}/history/{version}")
    public QuoteRespDTO history(@PathVariable("goodsSn") String goodsSn,
                                @PathVariable("version") String version,
                                @RequestParam(name = "country", required = false) String country,
                                @RequestParam(name = "quantity", defaultValue="1") Integer quantity,
                                @RequestParam(value = "skuId", required = false) Integer skuId,
                                @RequestParam(value = "channelType", defaultValue = "1") Byte channelType){
        return getQuoteResult(goodsSn, skuId, country, quantity, channelType, false, version);
    }

    @RespWrap
    @GetMapping("/{goodsSn}")
    public QuoteRespDTO quote(@PathVariable("goodsSn") String goodsSn,
                              @RequestParam(name = "quantity", defaultValue="1") Integer quantity,
                              @RequestParam(name = "country", required = false) String country,
                              @RequestParam(value = "skuId", required = false) Integer skuId,
                              @RequestParam(value = "channelType", defaultValue = "1") Byte channelType){
        return getQuoteResult(goodsSn, skuId, country, quantity, channelType, false);
    }

    private QuoteRespDTO getQuoteResult(String goodsSn, Integer skuId, String country, Integer quantity, Byte channelType, boolean preview){
        return getQuoteResult(goodsSn, skuId, country, quantity, channelType, preview, null);
    }
    private QuoteRespDTO getQuoteResult(String goodsSn, Integer skuId, String country, Integer quantity, Byte channelType, boolean preview, String version){
        GoodsVO goodsVO = goodsService.getGoodsBySn(goodsSn);
        if(goodsVO == null){
            throw new HttpClientErrorException(NOT_FOUND, "goodsSn: " + goodsSn + " not found!");
        }
        if(CollectionUtils.isEmpty(goodsVO.getSkuList())){
            throw new HttpClientErrorException(NOT_FOUND, "No sku in goods[" + goodsSn + "]!");
        }
        SkuVO skuVO;
        if(skuId == null){
            //没有选中sku时， 默认选中商品中的第一个sku
            skuVO = goodsVO.getSkuList().get(0);
        }else{
            skuVO = goodsVO.getSkuList().stream()
                    .filter(sku -> sku.getSkuId().equals(skuId))
                    .findFirst().orElse(null);
        }
        if(skuVO == null){
            throw new HttpClientErrorException(NOT_FOUND, "No sku[" + skuId + "] in goods[" + goodsSn + "]!");
        }
        if(skuVO.getParentId()!=0){
            Integer parentId = skuVO.getParentId();
            skuVO = goodsVO.getSkuList().stream()
                    .filter(sku -> sku.getSkuId().equals(parentId))
                    .findFirst().orElse(null);
            if(skuVO == null){
                throw new HttpClientErrorException(NOT_FOUND, "No parent sku[" + parentId + "] of sku["+ skuId+"] in goods[" + goodsSn + "]!");
            }
        }

        if(preview){
            if(StringUtils.isEmpty(country)){
                //通过已有数据 设置 country
                country = "US";
            }
            GoodsChannel goodsChannel = goodsService.getGoodsChannel(goodsVO.getGoodsId(), country, channelType);
            if(goodsChannel == null){
                throw new HttpClientErrorException(NOT_FOUND, "No Shipping line for goods[" + goodsSn + "] to country[" + country + "]  found!");
            }
            return preview(goodsVO, skuVO, quantity, country, goodsChannel);
        }else{
            GoodsQuoteDetail goodsQuoteDetails;
            if(StringUtils.isBlank(version)) {
                GoodsQuote quoteVersion = quoteService.getQuoteVersion(goodsVO.getGoodsId());
                if(quoteVersion == null){
                    throw new HttpClientErrorException(NOT_FOUND, "No quote for goods[" + goodsSn + "] found!");
                }
                if(StringUtils.isEmpty(country)){
                    country = quoteService.getQuotedCountry(quoteVersion)
                            .orElseThrow(() -> new HttpClientErrorException(NOT_FOUND, "No quote for goods[" + goodsSn + "] found!"));
                }
                goodsQuoteDetails = quoteService.getQuoteDetails(skuVO, country, quantity, channelType);
            }else{
                GoodsQuote quoteVersion = quoteService.getQuoteVersion(goodsVO.getGoodsId(), version);
                if(quoteVersion == null){
                    throw new HttpClientErrorException(NOT_FOUND, "No quote for goods[" + goodsSn + "] found!");
                }
                if(StringUtils.isEmpty(country)){
                    country = quoteService.getQuotedCountry(quoteVersion)
                            .orElseThrow(() -> new HttpClientErrorException(NOT_FOUND, "No quote for goods[" + goodsSn + "] found!"));;
                }
                goodsQuoteDetails = quoteService.getQuoteDetails(skuVO, country, quantity, channelType, version);
            }
            if(goodsQuoteDetails == null) {
                throw new HttpClientErrorException(NOT_FOUND, "No quote for goods[" + goodsSn + "] to country[" + country + "]  found!");
            }
            String carrierCode = goodsQuoteDetails.getShippingChannel();
            ChannelConfig channelConfig = logisticService.getChannelConfig(carrierCode);
            LogisticChannel channel = channelConfig.getLogisticChannel();

            return QuoteRespDTO.Builder.create()
                    .goodsVo(goodsVO)
                    .currentSku(skuVO)
                    .quantity(quantity)
                    .country(country)
                    .channelType(channelType)
                    .quote(goodsQuoteDetails, channel)
                    .build();
        }
    }

    private QuoteRespDTO preview(GoodsVO goodsVO, SkuVO skuVO, Integer quantity, String country, GoodsChannel goodsChannel){
        //当前国家从来没有报过价，则实时计算
        String carrierCode = goodsChannel.getChannelCode();
        QuoteResult quoteResult = quoteService.quote(country, carrierCode, goodsVO, skuVO, quantity);

        return QuoteRespDTO.Builder.create()
                .goodsVo(goodsVO)
                .currentSku(skuVO)
                .quantity(quantity)
                .country(country)
                .channelType(goodsChannel.getChannelType())
                .quote(quoteResult)
                .build();
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
