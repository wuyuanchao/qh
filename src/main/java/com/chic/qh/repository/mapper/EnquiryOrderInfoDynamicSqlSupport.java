package com.chic.qh.repository.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class EnquiryOrderInfoDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    public static final EnquiryOrderInfo enquiryOrderInfo = new EnquiryOrderInfo();

    /**
     * Database Column Remarks:
     *   询价单ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_enquiry_order_info.enquiry_order_id")
    public static final SqlColumn<Integer> enquiryOrderId = enquiryOrderInfo.enquiryOrderId;

    /**
     * Database Column Remarks:
     *   询价单SN
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_enquiry_order_info.enquiry_order_sn")
    public static final SqlColumn<String> enquiryOrderSn = enquiryOrderInfo.enquiryOrderSn;

    /**
     * Database Column Remarks:
     *   询价单名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_enquiry_order_info.enquiry_order_name")
    public static final SqlColumn<String> enquiryOrderName = enquiryOrderInfo.enquiryOrderName;

    /**
     * Database Column Remarks:
     *   客户信息
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_enquiry_order_info.customer_info")
    public static final SqlColumn<String> customerInfo = enquiryOrderInfo.customerInfo;

    /**
     * Database Column Remarks:
     *   客户链接
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_enquiry_order_info.customer_link")
    public static final SqlColumn<String> customerLink = enquiryOrderInfo.customerLink;

    /**
     * Database Column Remarks:
     *   备注
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_enquiry_order_info.remark")
    public static final SqlColumn<String> remark = enquiryOrderInfo.remark;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_enquiry_order_info.gmt_created")
    public static final SqlColumn<Integer> gmtCreated = enquiryOrderInfo.gmtCreated;

    /**
     * Database Column Remarks:
     *   修改时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_enquiry_order_info.gmt_modify")
    public static final SqlColumn<Integer> gmtModify = enquiryOrderInfo.gmtModify;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    public static final class EnquiryOrderInfo extends AliasableSqlTable<EnquiryOrderInfo> {
        public final SqlColumn<Integer> enquiryOrderId = column("enquiry_order_id", JDBCType.INTEGER);

        public final SqlColumn<String> enquiryOrderSn = column("enquiry_order_sn", JDBCType.VARCHAR);

        public final SqlColumn<String> enquiryOrderName = column("enquiry_order_name", JDBCType.VARCHAR);

        public final SqlColumn<String> customerInfo = column("customer_info", JDBCType.VARCHAR);

        public final SqlColumn<String> customerLink = column("customer_link", JDBCType.VARCHAR);

        public final SqlColumn<String> remark = column("remark", JDBCType.VARCHAR);

        public final SqlColumn<Integer> gmtCreated = column("gmt_created", JDBCType.INTEGER);

        public final SqlColumn<Integer> gmtModify = column("gmt_modify", JDBCType.INTEGER);

        public EnquiryOrderInfo() {
            super("qh_enquiry_order_info", EnquiryOrderInfo::new);
        }
    }
}