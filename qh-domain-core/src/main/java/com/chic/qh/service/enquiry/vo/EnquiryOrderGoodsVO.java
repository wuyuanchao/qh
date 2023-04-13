package com.chic.qh.service.enquiry.vo;

import lombok.Data;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—07 15:26
 */
@Data
public class EnquiryOrderGoodsVO {

    private Integer recId;

    private Integer enquiryOrderId;

    private String goodsName;

    private String goodsSn;

    private String link;

    //关联类型（1-RTS;2-Similar;3-WFP;）
    private Byte relationType;

    private String remark;

    private Integer gmtCreated;

    private Integer gmtModify;




}
