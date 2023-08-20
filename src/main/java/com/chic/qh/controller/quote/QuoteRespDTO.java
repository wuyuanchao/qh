package com.chic.qh.controller.quote;

import com.chic.qh.repository.model.LogisticChannel;
import com.chic.qh.repository.model.GoodsQuoteDetail;
import com.chic.qh.service.goods.vo.GoodsVO;
import com.chic.qh.service.goods.vo.SkuVO;
import com.chic.qh.service.quote.QuoteResult;
import com.chic.qh.service.quote.WeightType;
import lombok.Data;

@Data
public class QuoteRespDTO {
    private GoodsVO goodsVo;

    private SkuVO currentSku;
    private String country;
    private Integer quantity;

    private QuoteResult result;

    private Byte availability;
    private String referenceUrl;
    private String processingTime;

    public static class Builder{
        private Builder(){}

        private QuoteRespDTO quoteRespDTO = new QuoteRespDTO();

        public static Builder create(){
            return new Builder();
        }

        public Builder goodsVo(GoodsVO goodsVo){
            quoteRespDTO.setGoodsVo(goodsVo);
            quoteRespDTO.setAvailability(goodsVo.getAvailability());
            quoteRespDTO.setProcessingTime(goodsVo.getProcessingTime());
            return this;
        }

        public Builder currentSku(SkuVO currentSku){
            quoteRespDTO.setCurrentSku(currentSku);
            quoteRespDTO.setReferenceUrl(currentSku.getLink());
            return this;
        }

        public Builder country(String country){
            quoteRespDTO.setCountry(country);
            return this;
        }

        public Builder quantity(Integer quantity){
            quoteRespDTO.setQuantity(quantity);
            return this;
        }

        public Builder quote(GoodsQuoteDetail goodsQuoteDetail, LogisticChannel channel) {
            QuoteResult result = new QuoteResult(channel.getCompany(), channel.getCode(),
                    quoteRespDTO.getCurrentSku().getSkuName(),
                    quoteRespDTO.getGoodsVo().getGoodsType() == 2,
                    quoteRespDTO.getGoodsVo().getGoodsType() == 3,
                    goodsQuoteDetail.getWeightType().equals(WeightType.ACTUAL_WEIGHT) ? goodsQuoteDetail.getActWeight() : goodsQuoteDetail.getVolWeight(),
                    goodsQuoteDetail.getActWeight(),
                    goodsQuoteDetail.getVolWeight(),
                    goodsQuoteDetail.getWeightType(),
                    goodsQuoteDetail.getAmount(), goodsQuoteDetail.getProductCost(), goodsQuoteDetail.getShippingCost(),
                    goodsQuoteDetail.getShippingTime());
            return this.quote(result);
        }

        public Builder quote(QuoteResult result){
            quoteRespDTO.setResult(result);
            return this;
        }

        public QuoteRespDTO build(){
            return quoteRespDTO;
        }

    }
}
