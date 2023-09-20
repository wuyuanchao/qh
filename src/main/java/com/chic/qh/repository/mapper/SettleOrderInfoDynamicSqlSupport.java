package com.chic.qh.repository.mapper;

import java.math.BigDecimal;
import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class SettleOrderInfoDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_info")
    public static final SettleOrderInfo settleOrderInfo = new SettleOrderInfo();

    /**
     * Database Column Remarks:
     *   主键ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_settle_order_info.settle_order_id")
    public static final SqlColumn<Integer> settleOrderId = settleOrderInfo.settleOrderId;

    /**
     * Database Column Remarks:
     *   结算单sn
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_settle_order_info.settle_order_sn")
    public static final SqlColumn<String> settleOrderSn = settleOrderInfo.settleOrderSn;

    /**
     * Database Column Remarks:
     *   总金额
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_settle_order_info.total_amount")
    public static final SqlColumn<BigDecimal> totalAmount = settleOrderInfo.totalAmount;

    /**
     * Database Column Remarks:
     *   操作人ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_settle_order_info.operator_id")
    public static final SqlColumn<Integer> operatorId = settleOrderInfo.operatorId;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_settle_order_info.gmt_created")
    public static final SqlColumn<Integer> gmtCreated = settleOrderInfo.gmtCreated;

    /**
     * Database Column Remarks:
     *   修改时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_settle_order_info.gmt_modify")
    public static final SqlColumn<Integer> gmtModify = settleOrderInfo.gmtModify;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_info")
    public static final class SettleOrderInfo extends AliasableSqlTable<SettleOrderInfo> {
        public final SqlColumn<Integer> settleOrderId = column("settle_order_id", JDBCType.INTEGER);

        public final SqlColumn<String> settleOrderSn = column("settle_order_sn", JDBCType.VARCHAR);

        public final SqlColumn<BigDecimal> totalAmount = column("total_amount", JDBCType.DECIMAL);

        public final SqlColumn<Integer> operatorId = column("operator_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> gmtCreated = column("gmt_created", JDBCType.INTEGER);

        public final SqlColumn<Integer> gmtModify = column("gmt_modify", JDBCType.INTEGER);

        public SettleOrderInfo() {
            super("qh_settle_order_info", SettleOrderInfo::new);
        }
    }
}