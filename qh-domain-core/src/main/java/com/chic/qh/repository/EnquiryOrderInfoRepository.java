package com.chic.qh.repository;

import com.chic.qh.domain.dal.mapper.EnquiryOrderInfoMapper;
import com.chic.qh.domain.dal.model.EnquiryOrderInfo;
import com.chic.qh.service.enquiry.dto.EnquiryOrderQueryDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.chic.qh.domain.dal.mapper.EnquiryOrderInfoDynamicSqlSupport.enquiryOrderId;
import static com.chic.qh.domain.dal.mapper.EnquiryOrderInfoDynamicSqlSupport.gmtCreated;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—07 14:53
 */
@Repository
public class EnquiryOrderInfoRepository {

    @Autowired
    private EnquiryOrderInfoMapper enquiryOrderInfoMapper;

    public Page<EnquiryOrderInfo> queryPagedList(EnquiryOrderQueryDTO dto) {
        return PageHelper.startPage(dto.getPageIndex(), dto.getPageSize()).doSelectPage(
                () -> enquiryOrderInfoMapper.selectByExample()
                        .where(enquiryOrderId, isEqualToWhenPresent(dto.getEnquiryOrderId()))
                        .orderBy(gmtCreated.descending())
                        .build()
                        .execute()
        );
    }

    public void saveEnquiryOrder(EnquiryOrderInfo orderInfo) {
        enquiryOrderInfoMapper.insertSelective(orderInfo);
    }
}
