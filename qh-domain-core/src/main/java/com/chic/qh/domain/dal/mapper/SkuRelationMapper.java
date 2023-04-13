package com.chic.qh.domain.dal.mapper;

import static com.chic.qh.domain.dal.mapper.SkuRelationDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.chic.qh.domain.dal.model.SkuRelation;
import java.util.List;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.MyBatis3DeleteModelAdapter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.MyBatis3UpdateModelAdapter;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

@Mapper
public interface SkuRelationMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.skuId")
    int insert(InsertStatementProvider<SkuRelation> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SkuRelationResult")
    SkuRelation selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SkuRelationResult", value = {
        @Result(column="sku_id", property="skuId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="goods_id", property="goodsId", jdbcType=JdbcType.INTEGER),
        @Result(column="sku_name", property="skuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="supp_name", property="suppName", jdbcType=JdbcType.VARCHAR),
        @Result(column="supp_sku_id", property="suppSkuId", jdbcType=JdbcType.VARCHAR),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="length", property="length", jdbcType=JdbcType.INTEGER),
        @Result(column="width", property="width", jdbcType=JdbcType.INTEGER),
        @Result(column="height", property="height", jdbcType=JdbcType.INTEGER),
        @Result(column="area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="weight", property="weight", jdbcType=JdbcType.DECIMAL),
        @Result(column="volume_weight", property="volumeWeight", jdbcType=JdbcType.DECIMAL),
        @Result(column="pur_price", property="purPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="color", property="color", jdbcType=JdbcType.VARCHAR),
        @Result(column="size", property="size", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_created", property="gmtCreated", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.INTEGER)
    })
    List<SkuRelation> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(skuRelation);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, skuRelation);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default int deleteByPrimaryKey(Integer skuId_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, skuRelation)
                .where(skuId, isEqualTo(skuId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default int insert(SkuRelation record) {
        return insert(SqlBuilder.insert(record)
                .into(skuRelation)
                .map(goodsId).toProperty("goodsId")
                .map(skuName).toProperty("skuName")
                .map(suppName).toProperty("suppName")
                .map(suppSkuId).toProperty("suppSkuId")
                .map(link).toProperty("link")
                .map(length).toProperty("length")
                .map(width).toProperty("width")
                .map(height).toProperty("height")
                .map(area).toProperty("area")
                .map(weight).toProperty("weight")
                .map(volumeWeight).toProperty("volumeWeight")
                .map(purPrice).toProperty("purPrice")
                .map(color).toProperty("color")
                .map(size).toProperty("size")
                .map(gmtCreated).toProperty("gmtCreated")
                .map(gmtModify).toProperty("gmtModify")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default int insertSelective(SkuRelation record) {
        return insert(SqlBuilder.insert(record)
                .into(skuRelation)
                .map(goodsId).toPropertyWhenPresent("goodsId", record::getGoodsId)
                .map(skuName).toPropertyWhenPresent("skuName", record::getSkuName)
                .map(suppName).toPropertyWhenPresent("suppName", record::getSuppName)
                .map(suppSkuId).toPropertyWhenPresent("suppSkuId", record::getSuppSkuId)
                .map(link).toPropertyWhenPresent("link", record::getLink)
                .map(length).toPropertyWhenPresent("length", record::getLength)
                .map(width).toPropertyWhenPresent("width", record::getWidth)
                .map(height).toPropertyWhenPresent("height", record::getHeight)
                .map(area).toPropertyWhenPresent("area", record::getArea)
                .map(weight).toPropertyWhenPresent("weight", record::getWeight)
                .map(volumeWeight).toPropertyWhenPresent("volumeWeight", record::getVolumeWeight)
                .map(purPrice).toPropertyWhenPresent("purPrice", record::getPurPrice)
                .map(color).toPropertyWhenPresent("color", record::getColor)
                .map(size).toPropertyWhenPresent("size", record::getSize)
                .map(gmtCreated).toPropertyWhenPresent("gmtCreated", record::getGmtCreated)
                .map(gmtModify).toPropertyWhenPresent("gmtModify", record::getGmtModify)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<SkuRelation>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, skuId, goodsId, skuName, suppName, suppSkuId, link, length, width, height, area, weight, volumeWeight, purPrice, color, size, gmtCreated, gmtModify)
                .from(skuRelation);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<SkuRelation>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, skuId, goodsId, skuName, suppName, suppSkuId, link, length, width, height, area, weight, volumeWeight, purPrice, color, size, gmtCreated, gmtModify)
                .from(skuRelation);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default SkuRelation selectByPrimaryKey(Integer skuId_) {
        return SelectDSL.selectWithMapper(this::selectOne, skuId, goodsId, skuName, suppName, suppSkuId, link, length, width, height, area, weight, volumeWeight, purPrice, color, size, gmtCreated, gmtModify)
                .from(skuRelation)
                .where(skuId, isEqualTo(skuId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(SkuRelation record) {
        return UpdateDSL.updateWithMapper(this::update, skuRelation)
                .set(goodsId).equalTo(record::getGoodsId)
                .set(skuName).equalTo(record::getSkuName)
                .set(suppName).equalTo(record::getSuppName)
                .set(suppSkuId).equalTo(record::getSuppSkuId)
                .set(link).equalTo(record::getLink)
                .set(length).equalTo(record::getLength)
                .set(width).equalTo(record::getWidth)
                .set(height).equalTo(record::getHeight)
                .set(area).equalTo(record::getArea)
                .set(weight).equalTo(record::getWeight)
                .set(volumeWeight).equalTo(record::getVolumeWeight)
                .set(purPrice).equalTo(record::getPurPrice)
                .set(color).equalTo(record::getColor)
                .set(size).equalTo(record::getSize)
                .set(gmtCreated).equalTo(record::getGmtCreated)
                .set(gmtModify).equalTo(record::getGmtModify);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(SkuRelation record) {
        return UpdateDSL.updateWithMapper(this::update, skuRelation)
                .set(goodsId).equalToWhenPresent(record::getGoodsId)
                .set(skuName).equalToWhenPresent(record::getSkuName)
                .set(suppName).equalToWhenPresent(record::getSuppName)
                .set(suppSkuId).equalToWhenPresent(record::getSuppSkuId)
                .set(link).equalToWhenPresent(record::getLink)
                .set(length).equalToWhenPresent(record::getLength)
                .set(width).equalToWhenPresent(record::getWidth)
                .set(height).equalToWhenPresent(record::getHeight)
                .set(area).equalToWhenPresent(record::getArea)
                .set(weight).equalToWhenPresent(record::getWeight)
                .set(volumeWeight).equalToWhenPresent(record::getVolumeWeight)
                .set(purPrice).equalToWhenPresent(record::getPurPrice)
                .set(color).equalToWhenPresent(record::getColor)
                .set(size).equalToWhenPresent(record::getSize)
                .set(gmtCreated).equalToWhenPresent(record::getGmtCreated)
                .set(gmtModify).equalToWhenPresent(record::getGmtModify);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default int updateByPrimaryKey(SkuRelation record) {
        return UpdateDSL.updateWithMapper(this::update, skuRelation)
                .set(goodsId).equalTo(record::getGoodsId)
                .set(skuName).equalTo(record::getSkuName)
                .set(suppName).equalTo(record::getSuppName)
                .set(suppSkuId).equalTo(record::getSuppSkuId)
                .set(link).equalTo(record::getLink)
                .set(length).equalTo(record::getLength)
                .set(width).equalTo(record::getWidth)
                .set(height).equalTo(record::getHeight)
                .set(area).equalTo(record::getArea)
                .set(weight).equalTo(record::getWeight)
                .set(volumeWeight).equalTo(record::getVolumeWeight)
                .set(purPrice).equalTo(record::getPurPrice)
                .set(color).equalTo(record::getColor)
                .set(size).equalTo(record::getSize)
                .set(gmtCreated).equalTo(record::getGmtCreated)
                .set(gmtModify).equalTo(record::getGmtModify)
                .where(skuId, isEqualTo(record::getSkuId))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default int updateByPrimaryKeySelective(SkuRelation record) {
        return UpdateDSL.updateWithMapper(this::update, skuRelation)
                .set(goodsId).equalToWhenPresent(record::getGoodsId)
                .set(skuName).equalToWhenPresent(record::getSkuName)
                .set(suppName).equalToWhenPresent(record::getSuppName)
                .set(suppSkuId).equalToWhenPresent(record::getSuppSkuId)
                .set(link).equalToWhenPresent(record::getLink)
                .set(length).equalToWhenPresent(record::getLength)
                .set(width).equalToWhenPresent(record::getWidth)
                .set(height).equalToWhenPresent(record::getHeight)
                .set(area).equalToWhenPresent(record::getArea)
                .set(weight).equalToWhenPresent(record::getWeight)
                .set(volumeWeight).equalToWhenPresent(record::getVolumeWeight)
                .set(purPrice).equalToWhenPresent(record::getPurPrice)
                .set(color).equalToWhenPresent(record::getColor)
                .set(size).equalToWhenPresent(record::getSize)
                .set(gmtCreated).equalToWhenPresent(record::getGmtCreated)
                .set(gmtModify).equalToWhenPresent(record::getGmtModify)
                .where(skuId, isEqualTo(record::getSkuId))
                .build()
                .execute();
    }
}