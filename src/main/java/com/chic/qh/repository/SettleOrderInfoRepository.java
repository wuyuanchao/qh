package com.chic.qh.repository;

import com.chic.qh.repository.mapper.SettleOrderInfoMapper;
import com.chic.qh.repository.model.SettleOrderInfo;
import com.chic.qh.service.settle.dto.SettleOrderQueryDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;

import static com.chic.qh.repository.mapper.SettleOrderInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @Description:
 * @author: Carney
 * @date: 2023-09-17 14:54
 */
@Mapper
public interface SettleOrderInfoRepository extends SettleOrderInfoMapper {


    default PageInfo<SettleOrderInfo> queryPagedList(SettleOrderQueryDTO dto){
        return PageHelper.startPage(dto.getCurrent(), dto.getPageSize()).doSelectPageInfo(
                () -> select(c->c
                        .where(settleOrderSn, isEqualToWhenPresent(dto.getSettleOrderSn()))
                        .and(gmtCreated, isGreaterThanOrEqualToWhenPresent(dto.getGmtCreatedStart()))
                        .and(gmtCreated, isLessThanOrEqualToWhenPresent(dto.getGmtCreatedEnd()))
                        .orderBy(gmtCreated.descending())
                )
        );
    }

    default SettleOrderInfo queryBySettleOrderId(Integer _settleOrderId){
        return selectOne(c->c.where(settleOrderId, isEqualTo(_settleOrderId)).limit(1L)).orElse(null);
    }
}
