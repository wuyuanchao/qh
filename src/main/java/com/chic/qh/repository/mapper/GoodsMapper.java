package com.chic.qh.repository.mapper;

import static com.chic.qh.repository.mapper.GoodsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.chic.qh.repository.model.Goods;
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
public interface GoodsMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    BasicColumn[] selectList = BasicColumn.columnList(goodsId, goodsSn, goodsName, remark, gmtCreated, gmtModify, goodsImage, goodsType, depot, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.goodsId")
    int insert(InsertStatementProvider<Goods> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.goodsId")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Goods> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="GoodsResult", value = {
        @Result(column="goods_id", property="goodsId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="goods_sn", property="goodsSn", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_name", property="goodsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_created", property="gmtCreated", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.INTEGER),
        @Result(column="goods_image", property="goodsImage", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_type", property="goodsType", jdbcType=JdbcType.INTEGER),
        @Result(column="depot", property="depot", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<Goods> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("GoodsResult")
    Optional<Goods> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, goods, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, goods, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default int deleteByPrimaryKey(Integer goodsId_) {
        return delete(c -> 
            c.where(goodsId, isEqualTo(goodsId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default int insert(Goods row) {
        return MyBatis3Utils.insert(this::insert, row, goods, c ->
            c.map(goodsSn).toProperty("goodsSn")
            .map(goodsName).toProperty("goodsName")
            .map(remark).toProperty("remark")
            .map(gmtCreated).toProperty("gmtCreated")
            .map(gmtModify).toProperty("gmtModify")
            .map(goodsImage).toProperty("goodsImage")
            .map(goodsType).toProperty("goodsType")
            .map(depot).toProperty("depot")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default int insertMultiple(Collection<Goods> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, goods, c ->
            c.map(goodsSn).toProperty("goodsSn")
            .map(goodsName).toProperty("goodsName")
            .map(remark).toProperty("remark")
            .map(gmtCreated).toProperty("gmtCreated")
            .map(gmtModify).toProperty("gmtModify")
            .map(goodsImage).toProperty("goodsImage")
            .map(goodsType).toProperty("goodsType")
            .map(depot).toProperty("depot")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default int insertSelective(Goods row) {
        return MyBatis3Utils.insert(this::insert, row, goods, c ->
            c.map(goodsSn).toPropertyWhenPresent("goodsSn", row::getGoodsSn)
            .map(goodsName).toPropertyWhenPresent("goodsName", row::getGoodsName)
            .map(remark).toPropertyWhenPresent("remark", row::getRemark)
            .map(gmtCreated).toPropertyWhenPresent("gmtCreated", row::getGmtCreated)
            .map(gmtModify).toPropertyWhenPresent("gmtModify", row::getGmtModify)
            .map(goodsImage).toPropertyWhenPresent("goodsImage", row::getGoodsImage)
            .map(goodsType).toPropertyWhenPresent("goodsType", row::getGoodsType)
            .map(depot).toPropertyWhenPresent("depot", row::getDepot)
            .map(status).toPropertyWhenPresent("status", row::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default Optional<Goods> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, goods, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default List<Goods> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, goods, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default List<Goods> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, goods, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default Optional<Goods> selectByPrimaryKey(Integer goodsId_) {
        return selectOne(c ->
            c.where(goodsId, isEqualTo(goodsId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, goods, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    static UpdateDSL<UpdateModel> updateAllColumns(Goods row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(goodsSn).equalTo(row::getGoodsSn)
                .set(goodsName).equalTo(row::getGoodsName)
                .set(remark).equalTo(row::getRemark)
                .set(gmtCreated).equalTo(row::getGmtCreated)
                .set(gmtModify).equalTo(row::getGmtModify)
                .set(goodsImage).equalTo(row::getGoodsImage)
                .set(goodsType).equalTo(row::getGoodsType)
                .set(depot).equalTo(row::getDepot)
                .set(status).equalTo(row::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Goods row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(goodsSn).equalToWhenPresent(row::getGoodsSn)
                .set(goodsName).equalToWhenPresent(row::getGoodsName)
                .set(remark).equalToWhenPresent(row::getRemark)
                .set(gmtCreated).equalToWhenPresent(row::getGmtCreated)
                .set(gmtModify).equalToWhenPresent(row::getGmtModify)
                .set(goodsImage).equalToWhenPresent(row::getGoodsImage)
                .set(goodsType).equalToWhenPresent(row::getGoodsType)
                .set(depot).equalToWhenPresent(row::getDepot)
                .set(status).equalToWhenPresent(row::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default int updateByPrimaryKey(Goods row) {
        return update(c ->
            c.set(goodsSn).equalTo(row::getGoodsSn)
            .set(goodsName).equalTo(row::getGoodsName)
            .set(remark).equalTo(row::getRemark)
            .set(gmtCreated).equalTo(row::getGmtCreated)
            .set(gmtModify).equalTo(row::getGmtModify)
            .set(goodsImage).equalTo(row::getGoodsImage)
            .set(goodsType).equalTo(row::getGoodsType)
            .set(depot).equalTo(row::getDepot)
            .set(status).equalTo(row::getStatus)
            .where(goodsId, isEqualTo(row::getGoodsId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods")
    default int updateByPrimaryKeySelective(Goods row) {
        return update(c ->
            c.set(goodsSn).equalToWhenPresent(row::getGoodsSn)
            .set(goodsName).equalToWhenPresent(row::getGoodsName)
            .set(remark).equalToWhenPresent(row::getRemark)
            .set(gmtCreated).equalToWhenPresent(row::getGmtCreated)
            .set(gmtModify).equalToWhenPresent(row::getGmtModify)
            .set(goodsImage).equalToWhenPresent(row::getGoodsImage)
            .set(goodsType).equalToWhenPresent(row::getGoodsType)
            .set(depot).equalToWhenPresent(row::getDepot)
            .set(status).equalToWhenPresent(row::getStatus)
            .where(goodsId, isEqualTo(row::getGoodsId))
        );
    }
}