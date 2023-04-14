package com.chic.qh.repository;

import com.chic.qh.domain.dal.mapper.SkuRelationMapper;
import com.chic.qh.domain.dal.model.SkuRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.chic.qh.domain.dal.mapper.SkuRelationDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;
/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—09 12:28
 */
@Repository
public class SkuRelationRepository {

    @Autowired
    private SkuRelationMapper skuRelationMapper;


    public List<SkuRelation> querySkuList(Integer _goodsId) {
        List<SkuRelation> skuRelationList = skuRelationMapper.select(c -> c
                .where(goodsId, isEqualToWhenPresent(_goodsId))
                .orderBy(gmtCreated.descending())
        );
        return skuRelationList;
    }

    public void saveSkuRelation(SkuRelation skuRelation) {
        skuRelationMapper.insertSelective(skuRelation);
    }

    public void deleteSkuByGoodsId(Integer _goodsId) {
        skuRelationMapper.delete(c->c.where(goodsId, isEqualToWhenPresent(_goodsId)));
    }

    public SkuRelation getSku(Integer skuId) {
        return skuRelationMapper.selectByPrimaryKey(skuId).orElse(null);
    }

    public void updateSkuRelation(SkuRelation updateSku) {
        skuRelationMapper.updateByPrimaryKeySelective(updateSku);
    }

    public void deleteSkuBySkuId(Integer skuId) {
        skuRelationMapper.deleteByPrimaryKey(skuId);
    }
}
