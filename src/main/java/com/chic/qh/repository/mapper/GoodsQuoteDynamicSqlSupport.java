package com.chic.qh.repository.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class GoodsQuoteDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    public static final GoodsQuote goodsQuote = new GoodsQuote();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote.rec_id")
    public static final SqlColumn<Integer> recId = goodsQuote.recId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote.quote_name")
    public static final SqlColumn<String> quoteName = goodsQuote.quoteName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote.goods_id")
    public static final SqlColumn<Integer> goodsId = goodsQuote.goodsId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote.version")
    public static final SqlColumn<String> version = goodsQuote.version;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote.created_at")
    public static final SqlColumn<Integer> createdAt = goodsQuote.createdAt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    public static final class GoodsQuote extends AliasableSqlTable<GoodsQuote> {
        public final SqlColumn<Integer> recId = column("rec_id", JDBCType.INTEGER);

        public final SqlColumn<String> quoteName = column("quote_name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> goodsId = column("goods_id", JDBCType.INTEGER);

        public final SqlColumn<String> version = column("version", JDBCType.VARCHAR);

        public final SqlColumn<Integer> createdAt = column("created_at", JDBCType.INTEGER);

        public GoodsQuote() {
            super("qh_goods_quote", GoodsQuote::new);
        }
    }
}