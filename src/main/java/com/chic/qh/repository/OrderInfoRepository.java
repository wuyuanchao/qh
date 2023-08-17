package com.chic.qh.repository;

import com.chic.qh.repository.mapper.OrderInfoMapper;
import com.chic.qh.repository.model.OrderInfo;
import com.chic.qh.service.order.dto.OrderQueryDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import static com.chic.qh.repository.mapper.OrderInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;
/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—08—17 15:56
 */
@Mapper
public interface OrderInfoRepository extends OrderInfoMapper {

    default PageInfo<OrderInfo> queryPagedList(OrderQueryDTO dto) {
        return PageHelper.startPage(dto.getCurrent(), dto.getPageSize()).doSelectPageInfo(
                () -> select(c->c
                        .where(orderSn, isEqualToWhenPresent(dto.getOrderSn()))
                        .and(trackingNumber, isEqualToWhenPresent(dto.getTrackingNumber()))
                        .and(trackingNumber2, isEqualToWhenPresent(dto.getTrackingNumber2()))
                        .and(phoneNumber, isLikeWhenPresent(dto.getPhoneNumber()))
                        .and(status, isEqualToWhenPresent(dto.getStatus()))
                        .and(gmtCreated, isGreaterThanOrEqualToWhenPresent(dto.getGmtCreatedStart()))
                        .and(gmtCreated, isLessThanOrEqualToWhenPresent(dto.getGmtCreatedEnd()))
                        .orderBy(gmtCreated.descending())
                )
        );
    }

    @Update("update qh_order_info set `status` = #{status}, gmt_modify = UNIX_TIMESTAMP(NOW()) where order_id = #{orderId}")
    Integer updateStatus(@Param("orderId") Integer orderId, @Param("status") Byte status);
}
