package com.chic.qh.repository;

import com.chic.qh.domain.dal.mapper.GoodsCommentDynamicSqlSupport;
import com.chic.qh.domain.dal.mapper.GoodsCommentMapper;
import com.chic.qh.domain.dal.mapper.GoodsMapper;
import com.chic.qh.domain.dal.model.Goods;
import com.chic.qh.domain.dal.model.GoodsComment;
import com.chic.qh.service.goods.dto.GoodsQueryDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.chic.qh.domain.dal.mapper.GoodsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
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
    @Autowired
    private GoodsCommentMapper goodsCommentMapper;

    public Optional<Goods> selectByPrimaryKey(Integer goodsId){
        return goodsMapper.selectByPrimaryKey(goodsId);
    }

    public Optional<Goods> selectByGoodsSn(String _goodsSn){
        return goodsMapper.selectOne(c -> c.where(goodsSn, isEqualTo(_goodsSn)));
    }

    public Page<Goods> queryPagedList(GoodsQueryDTO dto) {
        return PageHelper.startPage(dto.getCurrent(), dto.getPageSize()).doSelectPage(
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

    public int addComment(GoodsComment comment){
        return goodsCommentMapper.insert(comment);
    }

    public List<GoodsComment> getComments(Integer _goodsId){
        return goodsCommentMapper.select(c ->
                c.where(GoodsCommentDynamicSqlSupport.goodsId, isEqualTo(_goodsId))
                        .orderBy(GoodsCommentDynamicSqlSupport.createdAt.descending()));
    }
}
