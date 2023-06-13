package com.chic.qh.repository.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class EnquiryOrderGoodsDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    public static final EnquiryOrderGoods enquiryOrderGoods = new EnquiryOrderGoods();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_enquiry_order_goods.rec_id")
    public static final SqlColumn<Integer> recId = enquiryOrderGoods.recId;

    /**
     * Database Column Remarks:
     *   询价单ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_enquiry_order_goods.enquiry_order_id")
    public static final SqlColumn<Integer> enquiryOrderId = enquiryOrderGoods.enquiryOrderId;

    /**
     * Database Column Remarks:
     *   商品名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_enquiry_order_goods.goods_name")
    public static final SqlColumn<String> goodsName = enquiryOrderGoods.goodsName;

    /**
     * Database Column Remarks:
     *   商品sn
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_enquiry_order_goods.goods_sn")
    public static final SqlColumn<String> goodsSn = enquiryOrderGoods.goodsSn;

    /**
     * Database Column Remarks:
     *   商品链接
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_enquiry_order_goods.link")
    public static final SqlColumn<String> link = enquiryOrderGoods.link;

    /**
     * Database Column Remarks:
     *   关联类型（1-RTS;2-Similar;3-WFP;）
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_enquiry_order_goods.relation_type")
    public static final SqlColumn<Byte> relationType = enquiryOrderGoods.relationType;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_enquiry_order_goods.gmt_created")
    public static final SqlColumn<Integer> gmtCreated = enquiryOrderGoods.gmtCreated;

    /**
     * Database Column Remarks:
     *   修改时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_enquiry_order_goods.gmt_modify")
    public static final SqlColumn<Integer> gmtModify = enquiryOrderGoods.gmtModify;

    /**
     * Database Column Remarks:
     *   备注
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_enquiry_order_goods.remark")
    public static final SqlColumn<String> remark = enquiryOrderGoods.remark;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    public static final class EnquiryOrderGoods extends AliasableSqlTable<EnquiryOrderGoods> {
        public final SqlColumn<Integer> recId = column("rec_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> enquiryOrderId = column("enquiry_order_id", JDBCType.INTEGER);

        public final SqlColumn<String> goodsName = column("goods_name", JDBCType.VARCHAR);

        public final SqlColumn<String> goodsSn = column("goods_sn", JDBCType.VARCHAR);

        public final SqlColumn<String> link = column("link", JDBCType.VARCHAR);

        public final SqlColumn<Byte> relationType = column("relation_type", JDBCType.TINYINT);

        public final SqlColumn<Integer> gmtCreated = column("gmt_created", JDBCType.INTEGER);

        public final SqlColumn<Integer> gmtModify = column("gmt_modify", JDBCType.INTEGER);

        public final SqlColumn<String> remark = column("remark", JDBCType.LONGVARCHAR);

        public EnquiryOrderGoods() {
            super("qh_enquiry_order_goods", EnquiryOrderGoods::new);
        }
    }
}