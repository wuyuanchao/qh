package com.chic.qh.service.quote;

import com.chic.qh.repository.model.GoodsQuote;
import com.chic.qh.repository.model.GoodsQuoteDetail;
import com.chic.qh.service.goods.vo.GoodsVO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Data
public class GoodsQuoteDTO {
    private Integer recId;
    private String quoteName;
    private Integer goodsId;
    private GoodsVO goodsVo;
    private String version;
    private Integer createdAt;

    List<QuoteDetailDTO> quoteList;

    public static PoBuilder BuildPO(GoodsQuoteDTO dto){
        return new PoBuilder(dto);
    }

    public static class PoBuilder {
        private Integer now;
        private GoodsQuote goodsQuote;
        private List<GoodsQuoteDetail> details;

        public PoBuilder(GoodsQuoteDTO goodsQuoteDTO){
            this.now = (int)Instant.now().getEpochSecond();

            GoodsQuote goodsQuote = new GoodsQuote();
            goodsQuote.setGoodsId(goodsQuoteDTO.getGoodsId());
            goodsQuote.setVersion(goodsQuoteDTO.getVersion());
            goodsQuote.setQuoteName(goodsQuoteDTO.getQuoteName());
            goodsQuote.setCreatedAt(this.now);

            this.goodsQuote = goodsQuote;

            this.details = goodsQuoteDTO.getQuoteList().stream()
                    .flatMap(x -> Arrays.asList(
                                buildDetail(x, 1),
                                buildDetail(x, 2),
                                buildDetail(x, 3)
                        ).stream())
                    .collect(Collectors.toList());
        }

        public GoodsQuote getGoodsQuote(){
            return this.goodsQuote;
        }

        public List<GoodsQuoteDetail> getDetails(){
            return this.details;
        }

        //一个dto包含 1pcs 2pcs 3pcs 的报价，可以转换成3个GoodsQuoteDetail
        private GoodsQuoteDetail buildDetail(QuoteDetailDTO dto, int qty){
            GoodsQuoteDetail detail = new GoodsQuoteDetail();
            detail.setSkuId(dto.getSkuId());
            detail.setQty(qty);
            detail.setShippingChannel(dto.getChannelCode());
            detail.setCountry(dto.getCountry());
            detail.setChannelType(dto.getChannelType());
            detail.setShippingTime(dto.getShippingTime());
            detail.setActWeight(BigDecimal.ZERO);
            detail.setVolWeight(BigDecimal.ZERO);
            detail.setWeightType(WeightType.ACTUAL_WEIGHT);
            detail.setProductCost(BigDecimal.ZERO);
            detail.setShippingCost(BigDecimal.ZERO);
            detail.setCreatedAt(now);
            if(qty == 1){
                detail.setAmount(dto.getAmount1Pcs());
            }else if(qty == 2){
                detail.setAmount(dto.getAmount2Pcs());
            }else if (qty == 3){
                detail.setAmount(dto.getAmount3Pcs());
            }else {
                throw new RuntimeException("qty只能为1,2,3");
            }
            return detail;
        }
    }

    public static DtoBuilder BuildDTO(GoodsVO goodsVo){
        return new DtoBuilder(goodsVo);
    }

    public static class DtoBuilder{
        private GoodsVO goodsVo;
        private GoodsQuoteDTO dto;

        public DtoBuilder(GoodsVO goodsVo){
            this.dto = new GoodsQuoteDTO();
            this.goodsVo = goodsVo;
        }

        public DtoBuilder setQuoteVersion(GoodsQuote quoteVersion){
            dto.setRecId(quoteVersion.getRecId());
            dto.setGoodsId(quoteVersion.getGoodsId());
            dto.setGoodsVo(goodsVo);
            dto.setQuoteName(quoteVersion.getQuoteName());
            dto.setVersion(quoteVersion.getVersion());
            dto.setCreatedAt(quoteVersion.getCreatedAt());
            return this;
        }

        public DtoBuilder setQuoteList(List<GoodsQuoteDetail> details){
            Map<QuoteDetailKey, List<GoodsQuoteDetail>> group = details.stream().collect(Collectors.groupingBy(x -> new QuoteDetailKey(x.getSkuId(), x.getCountry(), x.getShippingChannel(), x.getChannelType())));
            List<QuoteDetailDTO> quoteList = group.entrySet().stream().map(x -> {
                QuoteDetailDTO dto = new QuoteDetailDTO();
                dto.setCountry(x.getKey().getCountry());
                dto.setSkuId(x.getKey().getSkuId());
                dto.setChannelCode(x.getKey().getChannelCode());
                dto.setChannelType(x.getKey().getChannelType());
                dto.setShippingTime(x.getValue().get(0).getShippingTime());
                dto.setAmount1Pcs(x.getValue().stream().filter(y -> y.getQty() == 1).findFirst().map(GoodsQuoteDetail::getAmount).orElse(BigDecimal.ZERO));
                dto.setAmount2Pcs(x.getValue().stream().filter(y -> y.getQty() == 2).findFirst().map(GoodsQuoteDetail::getAmount).orElse(BigDecimal.ZERO));
                dto.setAmount3Pcs(x.getValue().stream().filter(y -> y.getQty() == 3).findFirst().map(GoodsQuoteDetail::getAmount).orElse(BigDecimal.ZERO));
                return dto;
            }).sorted(Comparator.comparing(QuoteDetailDTO::getCountry).thenComparing(QuoteDetailDTO::getChannelType))
                    .collect(Collectors.toList());
            dto.setQuoteList(quoteList);
            return this;
        }

        public GoodsQuoteDTO build(){
            return dto;
        }
    }

    public static class QuoteDetailKey{
        private Integer skuId;
        private String country;
        private String channelCode;
        private Byte channelType;

        public QuoteDetailKey(){}

        public QuoteDetailKey(Integer skuId, String country, String channelCode, Byte channelType) {
            this.skuId = skuId;
            this.country = country;
            this.channelCode = channelCode;
            this.channelType = channelType;
        }

        public Integer getSkuId() {
            return skuId;
        }

        public void setSkuId(Integer skuId) {
            this.skuId = skuId;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getChannelCode() {
            return channelCode;
        }

        public void setChannelCode(String channelCode) {
            this.channelCode = channelCode;
        }

        public Byte getChannelType() {
            return channelType;
        }

        public void setChannelType(Byte channelType) {
            this.channelType = channelType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            QuoteDetailKey that = (QuoteDetailKey) o;
            return Objects.equals(skuId, that.skuId) && Objects.equals(country, that.country) && Objects.equals(channelCode, that.channelCode) && Objects.equals(channelType, that.channelType);
        }

        @Override
        public int hashCode() {
            return Objects.hash(skuId, country, channelCode, channelType);
        }
    }
}
