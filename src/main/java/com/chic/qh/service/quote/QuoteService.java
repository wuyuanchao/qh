package com.chic.qh.service.quote;

import com.chic.qh.repository.model.GoodsQuote;
import com.chic.qh.repository.model.GoodsQuoteDetail;
import com.chic.qh.service.goods.vo.GoodsVO;
import com.chic.qh.service.goods.vo.SkuVO;

import java.util.List;
import java.util.Optional;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—07 14:50
 */
public interface QuoteService {

    List<String> supportedCountries();

    QuoteResult quote(String country, String carrierCode, GoodsVO goodsVO, SkuVO skuVo, Integer quantity);

    ConfigDTO getConfig();

    void updateConfig(String key, String value);

    void saveQuote(GoodsQuoteDTO goodsQuoteDTO);

    GoodsQuote getQuoteVersion(Integer goodsId);

    GoodsQuote getQuoteVersion(Integer goodsId, Integer orderTime);

    GoodsQuote getQuoteVersion(Integer goodsId, String version);

    GoodsQuoteDetail getQuoteDetails(SkuVO skuVO, String country, Integer quantity, Byte chanelType);

    GoodsQuoteDetail getQuoteDetails(SkuVO skuVO, String country, Integer quantity, Byte chanelType, String version);
    GoodsQuoteDetail getQuoteDetails(Integer skuId, String country, Integer quantity, Byte chanelType, Integer quoteId);

    List<GoodsQuote> selectHistory(Integer goodsId);

    GoodsQuoteDTO createQuote(GoodsVO goods, String quoteName, String version);

    GoodsQuoteDTO getQuoteDTO(Integer goodsId, String version);

    Optional<String> getQuotedCountry(GoodsQuote quoteVersion);
}
