package com.chic.qh.repository;

import com.chic.qh.domain.dal.mapper.EnquiryOrderInfoMapper;
import com.chic.qh.domain.dal.model.EnquiryOrderInfo;
import com.chic.qh.service.enquiry.dto.EnquiryOrderQueryDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public PageInfo<EnquiryOrderInfo> queryPagedList(EnquiryOrderQueryDTO dto) {
        return PageHelper.startPage(dto.getPageIndex(), dto.getPageSize()).doSelectPageInfo(
                () -> enquiryOrderInfoMapper.select(c->c
                                .where(enquiryOrderId, isEqualToWhenPresent(dto.getEnquiryOrderId()))
                                .orderBy(gmtCreated.descending())
                        )
        );
    }

    public void saveEnquiryOrder(EnquiryOrderInfo orderInfo) {
        enquiryOrderInfoMapper.insertSelective(orderInfo);
    }
}
