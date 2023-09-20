package com.chic.qh.repository.mapper;

import java.math.BigDecimal;
import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class SettleOrderDetailDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_detail")
    public static final SettleOrderDetail settleOrderDetail = new SettleOrderDetail();

    /**
     * Database Column Remarks:
     *   主键ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_settle_order_detail.rec_id")
    public static final SqlColumn<Integer> recId = settleOrderDetail.recId;

    /**
     * Database Column Remarks:
     *   结算单ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_settle_order_detail.settle_order_id")
    public static final SqlColumn<Integer> settleOrderId = settleOrderDetail.settleOrderId;

    /**
     * Database Column Remarks:
     *   订单ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_settle_order_detail.order_id")
    public static final SqlColumn<Integer> orderId = settleOrderDetail.orderId;

    /**
     * Database Column Remarks:
     *   订单SN
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_settle_order_detail.order_sn")
    public static final SqlColumn<String> orderSn = settleOrderDetail.orderSn;

    /**
     * Database Column Remarks:
     *   商品数量
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_settle_order_detail.quantity")
    public static final SqlColumn<Integer> quantity = settleOrderDetail.quantity;

    /**
     * Database Column Remarks:
     *   订单sku
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_settle_order_detail.sku")
    public static final SqlColumn<String> sku = settleOrderDetail.sku;

    /**
     * Database Column Remarks:
     *   skuId
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_settle_order_detail.sku_id")
    public static final SqlColumn<Integer> skuId = settleOrderDetail.skuId;

    /**
     * Database Column Remarks:
     *   金额
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_settle_order_detail.amount")
    public static final SqlColumn<BigDecimal> amount = settleOrderDetail.amount;

    /**
     * Database Column Remarks:
     *   报价ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_settle_order_detail.quote_id")
    public static final SqlColumn<Integer> quoteId = settleOrderDetail.quoteId;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_settle_order_detail.gmt_created")
    public static final SqlColumn<Integer> gmtCreated = settleOrderDetail.gmtCreated;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_detail")
    public static final class SettleOrderDetail extends AliasableSqlTable<SettleOrderDetail> {
        public final SqlColumn<Integer> recId = column("rec_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> settleOrderId = column("settle_order_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> orderId = column("order_id", JDBCType.INTEGER);

        public final SqlColumn<String> orderSn = column("order_sn", JDBCType.VARCHAR);

        public final SqlColumn<Integer> quantity = column("quantity", JDBCType.INTEGER);

        public final SqlColumn<String> sku = column("sku", JDBCType.VARCHAR);

        public final SqlColumn<Integer> skuId = column("sku_id", JDBCType.INTEGER);

        public final SqlColumn<BigDecimal> amount = column("amount", JDBCType.DECIMAL);

        public final SqlColumn<Integer> quoteId = column("quote_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> gmtCreated = column("gmt_created", JDBCType.INTEGER);

        public SettleOrderDetail() {
            super("qh_settle_order_detail", SettleOrderDetail::new);
        }
    }
}