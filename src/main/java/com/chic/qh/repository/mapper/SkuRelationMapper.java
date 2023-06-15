package com.chic.qh.repository.mapper;

import static com.chic.qh.repository.mapper.SkuRelationDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.chic.qh.repository.model.SkuRelation;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface SkuRelationMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    BasicColumn[] selectList = BasicColumn.columnList(skuId, goodsId, skuName, skuNameEn, suppName, suppSkuId, link, length, width, height, area, weight, volumeWeight, purPrice, color, size, gmtCreated, gmtModify, remark, skuImage);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.skuId")
    int insert(InsertStatementProvider<SkuRelation> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.skuId")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<SkuRelation> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SkuRelationResult", value = {
        @Result(column="sku_id", property="skuId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="goods_id", property="goodsId", jdbcType=JdbcType.INTEGER),
        @Result(column="sku_name", property="skuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_name_en", property="skuNameEn", jdbcType=JdbcType.VARCHAR),
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
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_image", property="skuImage", jdbcType=JdbcType.VARCHAR)
    })
    List<SkuRelation> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SkuRelationResult")
    Optional<SkuRelation> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, skuRelation, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, skuRelation, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default int deleteByPrimaryKey(Integer skuId_) {
        return delete(c -> 
            c.where(skuId, isEqualTo(skuId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default int insert(SkuRelation row) {
        return MyBatis3Utils.insert(this::insert, row, skuRelation, c ->
            c.map(goodsId).toProperty("goodsId")
            .map(skuName).toProperty("skuName")
            .map(skuNameEn).toProperty("skuNameEn")
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
            .map(remark).toProperty("remark")
            .map(skuImage).toProperty("skuImage")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default int insertMultiple(Collection<SkuRelation> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, skuRelation, c ->
            c.map(goodsId).toProperty("goodsId")
            .map(skuName).toProperty("skuName")
            .map(skuNameEn).toProperty("skuNameEn")
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
            .map(remark).toProperty("remark")
            .map(skuImage).toProperty("skuImage")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default int insertSelective(SkuRelation row) {
        return MyBatis3Utils.insert(this::insert, row, skuRelation, c ->
            c.map(goodsId).toPropertyWhenPresent("goodsId", row::getGoodsId)
            .map(skuName).toPropertyWhenPresent("skuName", row::getSkuName)
            .map(skuNameEn).toPropertyWhenPresent("skuNameEn", row::getSkuNameEn)
            .map(suppName).toPropertyWhenPresent("suppName", row::getSuppName)
            .map(suppSkuId).toPropertyWhenPresent("suppSkuId", row::getSuppSkuId)
            .map(link).toPropertyWhenPresent("link", row::getLink)
            .map(length).toPropertyWhenPresent("length", row::getLength)
            .map(width).toPropertyWhenPresent("width", row::getWidth)
            .map(height).toPropertyWhenPresent("height", row::getHeight)
            .map(area).toPropertyWhenPresent("area", row::getArea)
            .map(weight).toPropertyWhenPresent("weight", row::getWeight)
            .map(volumeWeight).toPropertyWhenPresent("volumeWeight", row::getVolumeWeight)
            .map(purPrice).toPropertyWhenPresent("purPrice", row::getPurPrice)
            .map(color).toPropertyWhenPresent("color", row::getColor)
            .map(size).toPropertyWhenPresent("size", row::getSize)
            .map(gmtCreated).toPropertyWhenPresent("gmtCreated", row::getGmtCreated)
            .map(gmtModify).toPropertyWhenPresent("gmtModify", row::getGmtModify)
            .map(remark).toPropertyWhenPresent("remark", row::getRemark)
            .map(skuImage).toPropertyWhenPresent("skuImage", row::getSkuImage)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default Optional<SkuRelation> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, skuRelation, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default List<SkuRelation> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, skuRelation, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default List<SkuRelation> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, skuRelation, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default Optional<SkuRelation> selectByPrimaryKey(Integer skuId_) {
        return selectOne(c ->
            c.where(skuId, isEqualTo(skuId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, skuRelation, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    static UpdateDSL<UpdateModel> updateAllColumns(SkuRelation row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(goodsId).equalTo(row::getGoodsId)
                .set(skuName).equalTo(row::getSkuName)
                .set(skuNameEn).equalTo(row::getSkuNameEn)
                .set(suppName).equalTo(row::getSuppName)
                .set(suppSkuId).equalTo(row::getSuppSkuId)
                .set(link).equalTo(row::getLink)
                .set(length).equalTo(row::getLength)
                .set(width).equalTo(row::getWidth)
                .set(height).equalTo(row::getHeight)
                .set(area).equalTo(row::getArea)
                .set(weight).equalTo(row::getWeight)
                .set(volumeWeight).equalTo(row::getVolumeWeight)
                .set(purPrice).equalTo(row::getPurPrice)
                .set(color).equalTo(row::getColor)
                .set(size).equalTo(row::getSize)
                .set(gmtCreated).equalTo(row::getGmtCreated)
                .set(gmtModify).equalTo(row::getGmtModify)
                .set(remark).equalTo(row::getRemark)
                .set(skuImage).equalTo(row::getSkuImage);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SkuRelation row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(goodsId).equalToWhenPresent(row::getGoodsId)
                .set(skuName).equalToWhenPresent(row::getSkuName)
                .set(skuNameEn).equalToWhenPresent(row::getSkuNameEn)
                .set(suppName).equalToWhenPresent(row::getSuppName)
                .set(suppSkuId).equalToWhenPresent(row::getSuppSkuId)
                .set(link).equalToWhenPresent(row::getLink)
                .set(length).equalToWhenPresent(row::getLength)
                .set(width).equalToWhenPresent(row::getWidth)
                .set(height).equalToWhenPresent(row::getHeight)
                .set(area).equalToWhenPresent(row::getArea)
                .set(weight).equalToWhenPresent(row::getWeight)
                .set(volumeWeight).equalToWhenPresent(row::getVolumeWeight)
                .set(purPrice).equalToWhenPresent(row::getPurPrice)
                .set(color).equalToWhenPresent(row::getColor)
                .set(size).equalToWhenPresent(row::getSize)
                .set(gmtCreated).equalToWhenPresent(row::getGmtCreated)
                .set(gmtModify).equalToWhenPresent(row::getGmtModify)
                .set(remark).equalToWhenPresent(row::getRemark)
                .set(skuImage).equalToWhenPresent(row::getSkuImage);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default int updateByPrimaryKey(SkuRelation row) {
        return update(c ->
            c.set(goodsId).equalTo(row::getGoodsId)
            .set(skuName).equalTo(row::getSkuName)
            .set(skuNameEn).equalTo(row::getSkuNameEn)
            .set(suppName).equalTo(row::getSuppName)
            .set(suppSkuId).equalTo(row::getSuppSkuId)
            .set(link).equalTo(row::getLink)
            .set(length).equalTo(row::getLength)
            .set(width).equalTo(row::getWidth)
            .set(height).equalTo(row::getHeight)
            .set(area).equalTo(row::getArea)
            .set(weight).equalTo(row::getWeight)
            .set(volumeWeight).equalTo(row::getVolumeWeight)
            .set(purPrice).equalTo(row::getPurPrice)
            .set(color).equalTo(row::getColor)
            .set(size).equalTo(row::getSize)
            .set(gmtCreated).equalTo(row::getGmtCreated)
            .set(gmtModify).equalTo(row::getGmtModify)
            .set(remark).equalTo(row::getRemark)
            .set(skuImage).equalTo(row::getSkuImage)
            .where(skuId, isEqualTo(row::getSkuId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_sku_relation")
    default int updateByPrimaryKeySelective(SkuRelation row) {
        return update(c ->
            c.set(goodsId).equalToWhenPresent(row::getGoodsId)
            .set(skuName).equalToWhenPresent(row::getSkuName)
            .set(skuNameEn).equalToWhenPresent(row::getSkuNameEn)
            .set(suppName).equalToWhenPresent(row::getSuppName)
            .set(suppSkuId).equalToWhenPresent(row::getSuppSkuId)
            .set(link).equalToWhenPresent(row::getLink)
            .set(length).equalToWhenPresent(row::getLength)
            .set(width).equalToWhenPresent(row::getWidth)
            .set(height).equalToWhenPresent(row::getHeight)
            .set(area).equalToWhenPresent(row::getArea)
            .set(weight).equalToWhenPresent(row::getWeight)
            .set(volumeWeight).equalToWhenPresent(row::getVolumeWeight)
            .set(purPrice).equalToWhenPresent(row::getPurPrice)
            .set(color).equalToWhenPresent(row::getColor)
            .set(size).equalToWhenPresent(row::getSize)
            .set(gmtCreated).equalToWhenPresent(row::getGmtCreated)
            .set(gmtModify).equalToWhenPresent(row::getGmtModify)
            .set(remark).equalToWhenPresent(row::getRemark)
            .set(skuImage).equalToWhenPresent(row::getSkuImage)
            .where(skuId, isEqualTo(row::getSkuId))
        );
    }
}