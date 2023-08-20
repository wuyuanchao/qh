package com.chic.qh.repository.mapper;

import com.chic.qh.service.quote.WeightType;
import java.math.BigDecimal;
import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class GoodsQuoteDetailDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    public static final GoodsQuoteDetail goodsQuoteDetail = new GoodsQuoteDetail();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote_detail.rec_id")
    public static final SqlColumn<Integer> recId = goodsQuoteDetail.recId;

    /**
     * Database Column Remarks:
     *   版本号。暂时简单使用时间戳
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote_detail.quote_id")
    public static final SqlColumn<Integer> quoteId = goodsQuoteDetail.quoteId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote_detail.sku_id")
    public static final SqlColumn<Integer> skuId = goodsQuoteDetail.skuId;

    /**
     * Database Column Remarks:
     *   数量
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote_detail.qty")
    public static final SqlColumn<Integer> qty = goodsQuoteDetail.qty;

    /**
     * Database Column Remarks:
     *   ISO两位国家码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote_detail.country")
    public static final SqlColumn<String> country = goodsQuoteDetail.country;

    /**
     * Database Column Remarks:
     *   线路
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote_detail.shipping_channel")
    public static final SqlColumn<String> shippingChannel = goodsQuoteDetail.shippingChannel;

    /**
     * Database Column Remarks:
     *   物流时效
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote_detail.shipping_time")
    public static final SqlColumn<String> shippingTime = goodsQuoteDetail.shippingTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote_detail.amount")
    public static final SqlColumn<BigDecimal> amount = goodsQuoteDetail.amount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote_detail.product_cost")
    public static final SqlColumn<BigDecimal> productCost = goodsQuoteDetail.productCost;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote_detail.shipping_cost")
    public static final SqlColumn<BigDecimal> shippingCost = goodsQuoteDetail.shippingCost;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote_detail.weight_type")
    public static final SqlColumn<WeightType> weightType = goodsQuoteDetail.weightType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote_detail.vol_weight")
    public static final SqlColumn<BigDecimal> volWeight = goodsQuoteDetail.volWeight;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote_detail.act_weight")
    public static final SqlColumn<BigDecimal> actWeight = goodsQuoteDetail.actWeight;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods_quote_detail.created_at")
    public static final SqlColumn<Integer> createdAt = goodsQuoteDetail.createdAt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    public static final class GoodsQuoteDetail extends AliasableSqlTable<GoodsQuoteDetail> {
        public final SqlColumn<Integer> recId = column("rec_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> quoteId = column("quote_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> skuId = column("sku_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> qty = column("qty", JDBCType.INTEGER);

        public final SqlColumn<String> country = column("country", JDBCType.CHAR);

        public final SqlColumn<String> shippingChannel = column("shipping_channel", JDBCType.VARCHAR);

        public final SqlColumn<String> shippingTime = column("shipping_time", JDBCType.VARCHAR);

        public final SqlColumn<BigDecimal> amount = column("amount", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> productCost = column("product_cost", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> shippingCost = column("shipping_cost", JDBCType.DECIMAL);

        public final SqlColumn<WeightType> weightType = column("weight_type", JDBCType.VARCHAR);

        public final SqlColumn<BigDecimal> volWeight = column("vol_weight", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> actWeight = column("act_weight", JDBCType.DECIMAL);

        public final SqlColumn<Integer> createdAt = column("created_at", JDBCType.INTEGER);

        public GoodsQuoteDetail() {
            super("qh_goods_quote_detail", GoodsQuoteDetail::new);
        }
    }
}