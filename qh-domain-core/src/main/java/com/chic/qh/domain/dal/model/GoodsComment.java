package com.chic.qh.domain.dal.model;

import javax.annotation.Generated;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table qh_goods_comment
 */
public class GoodsComment {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.rec_id")
    private Integer recId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.goods_id")
    private Integer goodsId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.content")
    private String content;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.user")
    private String user;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.created_at")
    private Integer createdAt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.rec_id")
    public Integer getRecId() {
        return recId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.rec_id")
    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.goods_id")
    public Integer getGoodsId() {
        return goodsId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.goods_id")
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.content")
    public String getContent() {
        return content;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.content")
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.user")
    public String getUser() {
        return user;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.user")
    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.created_at")
    public Integer getCreatedAt() {
        return createdAt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.created_at")
    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recId=").append(recId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", content=").append(content);
        sb.append(", user=").append(user);
        sb.append(", createdAt=").append(createdAt);
        sb.append("]");
        return sb.toString();
    }
}