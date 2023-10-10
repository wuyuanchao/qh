package com.chic.qh.repository.mapper;

import java.math.BigDecimal;
import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class OrderInfoDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_order_info")
    public static final OrderInfo orderInfo = new OrderInfo();

    /**
     * Database Column Remarks:
     *   Order ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.order_id")
    public static final SqlColumn<Integer> orderId = orderInfo.orderId;

    /**
     * Database Column Remarks:
     *   订单编号
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.order_sn")
    public static final SqlColumn<String> orderSn = orderInfo.orderSn;

    /**
     * Database Column Remarks:
     *   物流单号
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.tracking_number")
    public static final SqlColumn<String> trackingNumber = orderInfo.trackingNumber;

    /**
     * Database Column Remarks:
     *   物流单号2
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.tracking_number2")
    public static final SqlColumn<String> trackingNumber2 = orderInfo.trackingNumber2;

    /**
     * Database Column Remarks:
     *   商品数量
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.quantity")
    public static final SqlColumn<Integer> quantity = orderInfo.quantity;

    /**
     * Database Column Remarks:
     *   价格
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.price")
    public static final SqlColumn<BigDecimal> price = orderInfo.price;

    /**
     * Database Column Remarks:
     *   店小蜜SKU
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.dxm_sku")
    public static final SqlColumn<String> dxmSku = orderInfo.dxmSku;

    /**
     * Database Column Remarks:
     *   店小蜜商品code
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.dxm_product_code")
    public static final SqlColumn<String> dxmProductCode = orderInfo.dxmProductCode;

    /**
     * Database Column Remarks:
     *   sku
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.sku")
    public static final SqlColumn<String> sku = orderInfo.sku;

    /**
     * Database Column Remarks:
     *   商品ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.product_id")
    public static final SqlColumn<String> productId = orderInfo.productId;

    /**
     * Database Column Remarks:
     *   国家
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.country")
    public static final SqlColumn<String> country = orderInfo.country;

    /**
     * Database Column Remarks:
     *   国家码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.country_code")
    public static final SqlColumn<String> countryCode = orderInfo.countryCode;

    /**
     * Database Column Remarks:
     *   省
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.province")
    public static final SqlColumn<String> province = orderInfo.province;

    /**
     * Database Column Remarks:
     *   市
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.city")
    public static final SqlColumn<String> city = orderInfo.city;

    /**
     * Database Column Remarks:
     *   详细地址
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.address")
    public static final SqlColumn<String> address = orderInfo.address;

    /**
     * Database Column Remarks:
     *   邮编
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.zip_code")
    public static final SqlColumn<String> zipCode = orderInfo.zipCode;

    /**
     * Database Column Remarks:
     *   收件人
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.shipping_name")
    public static final SqlColumn<String> shippingName = orderInfo.shippingName;

    /**
     * Database Column Remarks:
     *   手机号
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.phone_number")
    public static final SqlColumn<String> phoneNumber = orderInfo.phoneNumber;

    /**
     * Database Column Remarks:
     *   下单时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.order_time")
    public static final SqlColumn<Integer> orderTime = orderInfo.orderTime;

    /**
     * Database Column Remarks:
     *   支付时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.pay_time")
    public static final SqlColumn<Integer> payTime = orderInfo.payTime;

    /**
     * Database Column Remarks:
     *   发货时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.shipping_time")
    public static final SqlColumn<Integer> shippingTime = orderInfo.shippingTime;

    /**
     * Database Column Remarks:
     *   发货方式
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.shipping_method")
    public static final SqlColumn<String> shippingMethod = orderInfo.shippingMethod;

    /**
     * Database Column Remarks:
     *   状态 1-有效;2-无效;
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.status")
    public static final SqlColumn<Byte> status = orderInfo.status;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.gmt_created")
    public static final SqlColumn<Integer> gmtCreated = orderInfo.gmtCreated;

    /**
     * Database Column Remarks:
     *   修改时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_order_info.gmt_modify")
    public static final SqlColumn<Integer> gmtModify = orderInfo.gmtModify;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_order_info")
    public static final class OrderInfo extends AliasableSqlTable<OrderInfo> {
        public final SqlColumn<Integer> orderId = column("order_id", JDBCType.INTEGER);

        public final SqlColumn<String> orderSn = column("order_sn", JDBCType.VARCHAR);

        public final SqlColumn<String> trackingNumber = column("tracking_number", JDBCType.VARCHAR);

        public final SqlColumn<String> trackingNumber2 = column("tracking_number2", JDBCType.VARCHAR);

        public final SqlColumn<Integer> quantity = column("quantity", JDBCType.INTEGER);

        public final SqlColumn<BigDecimal> price = column("price", JDBCType.DECIMAL);

        public final SqlColumn<String> dxmSku = column("dxm_sku", JDBCType.VARCHAR);

        public final SqlColumn<String> dxmProductCode = column("dxm_product_code", JDBCType.VARCHAR);

        public final SqlColumn<String> sku = column("sku", JDBCType.VARCHAR);

        public final SqlColumn<String> productId = column("product_id", JDBCType.VARCHAR);

        public final SqlColumn<String> country = column("country", JDBCType.VARCHAR);

        public final SqlColumn<String> countryCode = column("country_code", JDBCType.VARCHAR);

        public final SqlColumn<String> province = column("province", JDBCType.VARCHAR);

        public final SqlColumn<String> city = column("city", JDBCType.VARCHAR);

        public final SqlColumn<String> address = column("address", JDBCType.VARCHAR);

        public final SqlColumn<String> zipCode = column("zip_code", JDBCType.VARCHAR);

        public final SqlColumn<String> shippingName = column("shipping_name", JDBCType.VARCHAR);

        public final SqlColumn<String> phoneNumber = column("phone_number", JDBCType.VARCHAR);

        public final SqlColumn<Integer> orderTime = column("order_time", JDBCType.INTEGER);

        public final SqlColumn<Integer> payTime = column("pay_time", JDBCType.INTEGER);

        public final SqlColumn<Integer> shippingTime = column("shipping_time", JDBCType.INTEGER);

        public final SqlColumn<String> shippingMethod = column("shipping_method", JDBCType.VARCHAR);

        public final SqlColumn<Byte> status = column("status", JDBCType.TINYINT);

        public final SqlColumn<Integer> gmtCreated = column("gmt_created", JDBCType.INTEGER);

        public final SqlColumn<Integer> gmtModify = column("gmt_modify", JDBCType.INTEGER);

        public OrderInfo() {
            super("qh_order_info", OrderInfo::new);
        }
    }
}