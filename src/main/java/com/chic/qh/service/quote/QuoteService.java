package com.chic.qh.service.quote;

import com.chic.qh.repository.model.GoodsQuote;
import com.chic.qh.repository.model.GoodsQuoteDetail;
import com.chic.qh.service.goods.vo.GoodsVO;
import com.chic.qh.service.goods.vo.SkuVO;

import java.util.List;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—07 14:50
 */
public interface QuoteService {

    QuoteResult quote(String country, String carrierCode, GoodsVO goodsVO, SkuVO skuVo, Integer quantity);

    ConfigDTO getConfig();

    void updateConfig(String key, String value);

    void saveQuote(GoodsQuote goodsQuote, List<GoodsQuoteDetail> quoteList);

    GoodsQuoteDetail getQuote(SkuVO skuVO, String country, Integer quantity);

    GoodsQuoteDetail getQuote(SkuVO skuVO, String country, Integer quantity, String version);

    List<GoodsQuote> selectHistory(Integer goodsId);
}
