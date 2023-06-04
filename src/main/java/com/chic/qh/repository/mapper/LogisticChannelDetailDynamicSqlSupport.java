package com.chic.qh.repository.mapper;

import java.math.BigDecimal;
import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class LogisticChannelDetailDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    public static final LogisticChannelDetail logisticChannelDetail = new LogisticChannelDetail();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel_detail.rec_id")
    public static final SqlColumn<Integer> recId = logisticChannelDetail.recId;

    /**
     * Database Column Remarks:
     *   物流渠道ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel_detail.channel_id")
    public static final SqlColumn<Integer> channelId = logisticChannelDetail.channelId;

    /**
     * Database Column Remarks:
     *   国家
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel_detail.country")
    public static final SqlColumn<String> country = logisticChannelDetail.country;

    /**
     * Database Column Remarks:
     *   物流时效
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel_detail.shipping_time")
    public static final SqlColumn<String> shippingTime = logisticChannelDetail.shippingTime;

    /**
     * Database Column Remarks:
     *   计抛比
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel_detail.vol_weight_rate")
    public static final SqlColumn<BigDecimal> volWeightRate = logisticChannelDetail.volWeightRate;

    /**
     * Database Column Remarks:
     *   重量左值
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel_detail.weight_left")
    public static final SqlColumn<BigDecimal> weightLeft = logisticChannelDetail.weightLeft;

    /**
     * Database Column Remarks:
     *   重量右值
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel_detail.weight_right")
    public static final SqlColumn<BigDecimal> weightRight = logisticChannelDetail.weightRight;

    /**
     * Database Column Remarks:
     *   运费
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel_detail.shipping_fee")
    public static final SqlColumn<BigDecimal> shippingFee = logisticChannelDetail.shippingFee;

    /**
     * Database Column Remarks:
     *   挂号费
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel_detail.extra_fee")
    public static final SqlColumn<BigDecimal> extraFee = logisticChannelDetail.extraFee;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    public static final class LogisticChannelDetail extends AliasableSqlTable<LogisticChannelDetail> {
        public final SqlColumn<Integer> recId = column("rec_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> channelId = column("channel_id", JDBCType.INTEGER);

        public final SqlColumn<String> country = column("country", JDBCType.VARCHAR);

        public final SqlColumn<String> shippingTime = column("shipping_time", JDBCType.VARCHAR);

        public final SqlColumn<BigDecimal> volWeightRate = column("vol_weight_rate", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> weightLeft = column("weight_left", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> weightRight = column("weight_right", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> shippingFee = column("shipping_fee", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> extraFee = column("extra_fee", JDBCType.DECIMAL);

        public LogisticChannelDetail() {
            super("qh_logistic_channel_detail", LogisticChannelDetail::new);
        }
    }
}