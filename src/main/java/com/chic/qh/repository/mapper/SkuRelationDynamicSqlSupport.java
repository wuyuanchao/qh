package com.chic.qh.repository.mapper;

import java.math.BigDecimal;
import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class SkuRelationDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    public static final SkuRelation skuRelation = new SkuRelation();

    /**
     * Database Column Remarks:
     *   skuId
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.sku_id")
    public static final SqlColumn<Integer> skuId = skuRelation.skuId;

    /**
     * Database Column Remarks:
     *   商品ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.goods_id")
    public static final SqlColumn<Integer> goodsId = skuRelation.goodsId;

    /**
     * Database Column Remarks:
     *   sku名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.sku_name")
    public static final SqlColumn<String> skuName = skuRelation.skuName;

    /**
     * Database Column Remarks:
     *   供应商名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.supp_name")
    public static final SqlColumn<String> suppName = skuRelation.suppName;

    /**
     * Database Column Remarks:
     *   供方skuId
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.supp_sku_id")
    public static final SqlColumn<String> suppSkuId = skuRelation.suppSkuId;

    /**
     * Database Column Remarks:
     *   供方链接
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.link")
    public static final SqlColumn<String> link = skuRelation.link;

    /**
     * Database Column Remarks:
     *   长度(cm)
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.length")
    public static final SqlColumn<Integer> length = skuRelation.length;

    /**
     * Database Column Remarks:
     *   宽度(cm)
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.width")
    public static final SqlColumn<Integer> width = skuRelation.width;

    /**
     * Database Column Remarks:
     *   高度(cm)
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.height")
    public static final SqlColumn<Integer> height = skuRelation.height;

    /**
     * Database Column Remarks:
     *   面积
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.area")
    public static final SqlColumn<BigDecimal> area = skuRelation.area;

    /**
     * Database Column Remarks:
     *   重量
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.weight")
    public static final SqlColumn<BigDecimal> weight = skuRelation.weight;

    /**
     * Database Column Remarks:
     *   体积重
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.volume_weight")
    public static final SqlColumn<BigDecimal> volumeWeight = skuRelation.volumeWeight;

    /**
     * Database Column Remarks:
     *   采购价
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.pur_price")
    public static final SqlColumn<BigDecimal> purPrice = skuRelation.purPrice;

    /**
     * Database Column Remarks:
     *   颜色
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.color")
    public static final SqlColumn<String> color = skuRelation.color;

    /**
     * Database Column Remarks:
     *   尺码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.size")
    public static final SqlColumn<String> size = skuRelation.size;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.gmt_created")
    public static final SqlColumn<Integer> gmtCreated = skuRelation.gmtCreated;

    /**
     * Database Column Remarks:
     *   修改时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.gmt_modify")
    public static final SqlColumn<Integer> gmtModify = skuRelation.gmtModify;

    /**
     * Database Column Remarks:
     *   备注
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.remark")
    public static final SqlColumn<String> remark = skuRelation.remark;

    /**
     * Database Column Remarks:
     *   sku图片
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_sku_relation.sku_image")
    public static final SqlColumn<String> skuImage = skuRelation.skuImage;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    public static final class SkuRelation extends AliasableSqlTable<SkuRelation> {
        public final SqlColumn<Integer> skuId = column("sku_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> goodsId = column("goods_id", JDBCType.INTEGER);

        public final SqlColumn<String> skuName = column("sku_name", JDBCType.VARCHAR);

        public final SqlColumn<String> suppName = column("supp_name", JDBCType.VARCHAR);

        public final SqlColumn<String> suppSkuId = column("supp_sku_id", JDBCType.VARCHAR);

        public final SqlColumn<String> link = column("link", JDBCType.VARCHAR);

        public final SqlColumn<Integer> length = column("length", JDBCType.INTEGER);

        public final SqlColumn<Integer> width = column("width", JDBCType.INTEGER);

        public final SqlColumn<Integer> height = column("height", JDBCType.INTEGER);

        public final SqlColumn<BigDecimal> area = column("area", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> weight = column("weight", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> volumeWeight = column("volume_weight", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> purPrice = column("pur_price", JDBCType.DECIMAL);

        public final SqlColumn<String> color = column("color", JDBCType.VARCHAR);

        public final SqlColumn<String> size = column("size", JDBCType.VARCHAR);

        public final SqlColumn<Integer> gmtCreated = column("gmt_created", JDBCType.INTEGER);

        public final SqlColumn<Integer> gmtModify = column("gmt_modify", JDBCType.INTEGER);

        public final SqlColumn<String> remark = column("remark", JDBCType.VARCHAR);

        public final SqlColumn<String> skuImage = column("sku_image", JDBCType.VARCHAR);

        public SkuRelation() {
            super("qh_sku_relation", SkuRelation::new);
        }
    }
}