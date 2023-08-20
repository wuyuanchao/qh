package com.chic.qh;

import com.chic.qh.repository.model.Goods;
import com.chic.qh.repository.model.GoodsQuoteDetail;
import com.chic.qh.service.goods.GoodsService;
import com.chic.qh.service.goods.vo.GoodsVO;
import com.chic.qh.service.quote.QuoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QuoteTests {
    @Autowired
    GoodsService goodsService;
    @Autowired
    QuoteService quoteService;
    @Test
    public void testQuoteDetail(){
        GoodsVO goods = goodsService.getGoods(32);
        GoodsQuoteDetail detail = quoteService.getQuote(goods.getSkuList().get(0), "US", 1);
        System.out.println(detail);
    }
}
