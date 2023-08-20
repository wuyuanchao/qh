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

import java.time.Instant;

@SpringBootTest(classes = QhApplication.class)
@RunWith(SpringRunner.class)
public class GoodsTests {

    @Autowired
    GoodsService goodsService;

    @Autowired
    QuoteService quoteService;

    @Test
    public void testSaveQuote() {
        Goods goods = goodsService.getGoodsPOBySn("YV8YDUTUXV");
        goodsService.saveQuote(goods.getGoodsId(), "20230806 报价测试", String.valueOf(Instant.now().getEpochSecond()));
    }
}
