package com.chic.qh.repository.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class GoodsCommentDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    public static final GoodsComment goodsComment = new GoodsComment();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.rec_id")
    public static final SqlColumn<Integer> recId = goodsComment.recId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.goods_id")
    public static final SqlColumn<Integer> goodsId = goodsComment.goodsId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.content")
    public static final SqlColumn<String> content = goodsComment.content;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.user")
    public static final SqlColumn<String> user = goodsComment.user;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_comment.created_at")
    public static final SqlColumn<Integer> createdAt = goodsComment.createdAt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    public static final class GoodsComment extends AliasableSqlTable<GoodsComment> {
        public final SqlColumn<Integer> recId = column("rec_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> goodsId = column("goods_id", JDBCType.INTEGER);

        public final SqlColumn<String> content = column("content", JDBCType.VARCHAR);

        public final SqlColumn<String> user = column("user", JDBCType.VARCHAR);

        public final SqlColumn<Integer> createdAt = column("created_at", JDBCType.INTEGER);

        public GoodsComment() {
            super("qh_goods_comment", GoodsComment::new);
        }
    }
}