package com.chic.qh.domain.core.service.enquiry.dto;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—09 11:24
 */
@Data
public class EnquiryOrderAddDTO {

    private String customerName;

    private String customerLink;

    private List<EnquiryOrderGoodsDTO> goodsList;

    @Data
    public static class EnquiryOrderGoodsDTO{

        private String goodsName;

        private String goodsSn;

        private String link;
    }


}
