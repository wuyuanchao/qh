package com.chic.qh.service.quote;

import com.chic.qh.service.goods.vo.GoodsVO;
import com.chic.qh.service.goods.vo.SkuVO;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—07 14:50
 */
public interface QuoteService {

    QuoteResult quote(String country, GoodsVO goodsVO, SkuVO skuVo, Integer quantity);
}
