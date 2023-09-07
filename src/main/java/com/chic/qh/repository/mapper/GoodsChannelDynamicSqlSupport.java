package com.chic.qh.repository.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class GoodsChannelDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    public static final GoodsChannel goodsChannel = new GoodsChannel();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.rec_id")
    public static final SqlColumn<Integer> recId = goodsChannel.recId;

    /**
     * Database Column Remarks:
     *   商品id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.goods_id")
    public static final SqlColumn<Integer> goodsId = goodsChannel.goodsId;

    /**
     * Database Column Remarks:
     *   ios国家码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.country_code")
    public static final SqlColumn<String> countryCode = goodsChannel.countryCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.channel_code")
    public static final SqlColumn<String> channelCode = goodsChannel.channelCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.updated_at")
    public static final SqlColumn<Integer> updatedAt = goodsChannel.updatedAt;

    /**
     * Database Column Remarks:
     *   渠道类型：1-普线， 2-快线
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_channel.channel_type")
    public static final SqlColumn<Byte> channelType = goodsChannel.channelType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    public static final class GoodsChannel extends AliasableSqlTable<GoodsChannel> {
        public final SqlColumn<Integer> recId = column("rec_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> goodsId = column("goods_id", JDBCType.INTEGER);

        public final SqlColumn<String> countryCode = column("country_code", JDBCType.VARCHAR);

        public final SqlColumn<String> channelCode = column("channel_code", JDBCType.VARCHAR);

        public final SqlColumn<Integer> updatedAt = column("updated_at", JDBCType.INTEGER);

        public final SqlColumn<Byte> channelType = column("channel_type", JDBCType.TINYINT);

        public GoodsChannel() {
            super("qh_goods_channel", GoodsChannel::new);
        }
    }
}