package com.chic.qh.repository;

import com.chic.qh.repository.mapper.*;
import com.chic.qh.repository.model.Goods;
import com.chic.qh.repository.model.GoodsChannel;
import com.chic.qh.repository.model.GoodsComment;
import com.chic.qh.service.goods.dto.GoodsQueryDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static com.chic.qh.repository.mapper.GoodsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

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
    @Autowired
    private GoodsChannelMapper goodsChannelMapper;

    public Optional<Goods> selectByPrimaryKey(Integer goodsId){
        return goodsMapper.selectByPrimaryKey(goodsId);
    }

    public Optional<Goods> selectByGoodsSn(String _goodsSn){
        return goodsMapper.selectOne(c -> c.where(goodsSn, isEqualTo(_goodsSn)));
    }

    public Page<Goods> queryPagedList(GoodsQueryDTO dto) {
        String sn = StringUtils.hasText(dto.getQ()) ? dto.getQ() + "%" : null;
        String txt = StringUtils.hasText(dto.getQ()) ? "%" + dto.getQ() + "%" : null;
        return PageHelper.startPage(dto.getCurrent(), dto.getPageSize()).doSelectPage(
                () -> goodsMapper.select(c->c
                                .where(goodsSn, isLikeWhenPresent(sn))
                                .and(status, isNotEqualTo((byte)3))
                                .or(goodsName, isLikeWhenPresent(txt))
                                .or(goodsName, isLikeWhenPresent(txt))
                                .or(remark, isLikeWhenPresent(txt))
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
        return goodsCommentMapper.insertSelective(comment);
    }

    public List<GoodsComment> getComments(Integer _goodsId){
        return goodsCommentMapper.select(c ->
                c.where(GoodsCommentDynamicSqlSupport.goodsId, isEqualTo(_goodsId))
                        .and(GoodsCommentDynamicSqlSupport.status, isEqualTo((byte)1))
                        .orderBy(GoodsCommentDynamicSqlSupport.createdAt.descending()));
    }

    public List<Goods> selectBySnList(List<String> snList) {
        return goodsMapper.select(c -> c.where(goodsSn, isIn(snList)));
    }

    public GoodsComment getComment(Integer commentId) {
        return goodsCommentMapper.selectByPrimaryKey(commentId).orElse(null);
    }

    public int deleteComment(Integer commentId) {
        GoodsComment goodsComment = new GoodsComment();
        goodsComment.setRecId(commentId);
        goodsComment.setStatus((byte)2);
        goodsComment.setUpdatedAt((int) Instant.now().getEpochSecond());
        return goodsCommentMapper.updateByPrimaryKeySelective(goodsComment);
    }

    public int addGoodsChannel(GoodsChannel channel) {
        return goodsChannelMapper.insert(channel);
    }

    public Optional<GoodsChannel> selectGoodsChannel(Integer goodsId, String countryCode) {
        return goodsChannelMapper.selectOne(c -> c.where(GoodsChannelDynamicSqlSupport.goodsId, isEqualTo(goodsId))
                .and(GoodsChannelDynamicSqlSupport.countryCode, isEqualTo(countryCode)));
    }

    public int updateGoodsChannel(GoodsChannel channel) {
        return goodsChannelMapper.updateByPrimaryKeySelective(channel);
    }

    public List<GoodsChannel> getGoodsChannelList(Integer goodsId) {
        return goodsChannelMapper.select(c -> c.where(GoodsChannelDynamicSqlSupport.goodsId, isEqualTo(goodsId)));
    }

    public GoodsChannel getGoodsChannel(Integer goodsId, String countryCode) {
        return  goodsChannelMapper.selectOne(c -> c.where(GoodsChannelDynamicSqlSupport.goodsId, isEqualTo(goodsId))
                .and(GoodsChannelDynamicSqlSupport.countryCode, isEqualTo(countryCode))).orElse(null);
    }

    public int deleteGoodsChannel(Integer goodsId, String countryCode) {
        return goodsChannelMapper.delete(c -> c.where(GoodsChannelDynamicSqlSupport.goodsId, isEqualTo(goodsId))
                .and(GoodsChannelDynamicSqlSupport.countryCode, isEqualTo(countryCode)));
    }
}
