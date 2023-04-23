package com.chic.qh.repository;

import com.chic.qh.domain.dal.mapper.EnquiryOrderGoodsMapper;
import com.chic.qh.domain.dal.model.EnquiryOrderGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import static com.chic.qh.domain.dal.mapper.EnquiryOrderGoodsDynamicSqlSupport.enquiryOrderId;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—07 14:53
 */
@Repository
public class EnquiryOrderGoodsRepository {

    @Resource
    private EnquiryOrderGoodsMapper enquiryOrderGoodsMapper;

    public List<EnquiryOrderGoods> queryOrderGoodsList(Integer _enquiryOrderId) {
        List<EnquiryOrderGoods> orderGoodsList = enquiryOrderGoodsMapper.select(c->c
                        .where(enquiryOrderId, isEqualToWhenPresent(_enquiryOrderId))
                );
        return orderGoodsList;
    }

    public void saveEnquiryOrderGoods(EnquiryOrderGoods orderGoods) {
        enquiryOrderGoodsMapper.insertSelective(orderGoods);
    }

    public void deleteByPrimaryKey(Integer recId) {
        enquiryOrderGoodsMapper.deleteByPrimaryKey(recId);
    }

    public void updateSelectiveByPrimaryKey(EnquiryOrderGoods orderGoods) {
        enquiryOrderGoodsMapper.updateByPrimaryKeySelective(orderGoods);
    }

    public void saveBatch(List<EnquiryOrderGoods> orderGoodsList) {
        enquiryOrderGoodsMapper.insertMultiple(orderGoodsList);
    }
}
