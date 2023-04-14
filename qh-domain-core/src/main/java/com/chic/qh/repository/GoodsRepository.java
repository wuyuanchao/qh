package com.chic.qh.repository;

import com.chic.qh.domain.dal.mapper.GoodsMapper;
import com.chic.qh.domain.dal.model.Goods;
import com.chic.qh.service.goods.dto.GoodsQueryDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.chic.qh.domain.dal.mapper.GoodsDynamicSqlSupport.gmtCreated;
import static com.chic.qh.domain.dal.mapper.GoodsDynamicSqlSupport.goodsId;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;
/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—04—09 12:28
 */
@Repository
public class GoodsRepository {

    @Autowired
    private GoodsMapper goodsMapper;

    public Page<Goods> queryPagedList(GoodsQueryDTO dto) {
        return PageHelper.startPage(dto.getPageIndex(), dto.getPageSize()).doSelectPage(
                () -> goodsMapper.select(c->c
                                .where(goodsId, isEqualToWhenPresent(dto.getGoodsId()))
                                .orderBy(gmtCreated.descending())
                        )
        );
    }

    public void saveGoods(Goods goods) {
        goodsMapper.insertSelective(goods);
    }

    public Goods getGoods(Integer goodsId){
        return goodsMapper.selectByPrimaryKey(goodsId).orElse(null);
    }

    public void updateGoods(Goods updateGoods) {
        goodsMapper.updateByPrimaryKeySelective(updateGoods);
    }

    public void deleteGoods(Integer goodsId) {
        goodsMapper.deleteByPrimaryKey(goodsId);
    }
}
