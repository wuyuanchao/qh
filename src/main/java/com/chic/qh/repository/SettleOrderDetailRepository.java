package com.chic.qh.repository;

import com.chic.qh.repository.mapper.SettleOrderDetailMapper;
import com.chic.qh.repository.model.SettleOrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import static com.chic.qh.repository.mapper.SettleOrderDetailDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @Description:
 * @author: Carney
 * @date: 2023-09-17 14:55
 */
@Mapper
public interface SettleOrderDetailRepository extends SettleOrderDetailMapper {

    default List<SettleOrderDetail> queryListBySettleOrderId(Integer _settleOrderId){
        return select(c->c.where(settleOrderId, isEqualTo(_settleOrderId)));
    }
}
