package com.chic.qh.domain.dal.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class GoodsDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    public static final Goods goods = new Goods();

    /**
     * Database Column Remarks:
     *   商品ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods.goods_id")
    public static final SqlColumn<Integer> goodsId = goods.goodsId;

    /**
     * Database Column Remarks:
     *   商品sn
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods.goods_sn")
    public static final SqlColumn<String> goodsSn = goods.goodsSn;

    /**
     * Database Column Remarks:
     *   商品名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods.goods_name")
    public static final SqlColumn<String> goodsName = goods.goodsName;

    /**
     * Database Column Remarks:
     *   备注
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods.remark")
    public static final SqlColumn<String> remark = goods.remark;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods.gmt_created")
    public static final SqlColumn<Integer> gmtCreated = goods.gmtCreated;

    /**
     * Database Column Remarks:
     *   修改时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods.gmt_modify")
    public static final SqlColumn<Integer> gmtModify = goods.gmtModify;

    /**
     * Database Column Remarks:
     *   商品主图链接
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_goods.goods_image")
    public static final SqlColumn<String> goodsImage = goods.goodsImage;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    public static final class Goods extends AliasableSqlTable<Goods> {
        public final SqlColumn<Integer> goodsId = column("goods_id", JDBCType.INTEGER);

        public final SqlColumn<String> goodsSn = column("goods_sn", JDBCType.VARCHAR);

        public final SqlColumn<String> goodsName = column("goods_name", JDBCType.VARCHAR);

        public final SqlColumn<String> remark = column("remark", JDBCType.VARCHAR);

        public final SqlColumn<Integer> gmtCreated = column("gmt_created", JDBCType.INTEGER);

        public final SqlColumn<Integer> gmtModify = column("gmt_modify", JDBCType.INTEGER);

        public final SqlColumn<String> goodsImage = column("goods_image", JDBCType.VARCHAR);

        public Goods() {
            super("qh_goods", Goods::new);
        }
    }
}