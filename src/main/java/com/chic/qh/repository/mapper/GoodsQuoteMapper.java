package com.chic.qh.repository.mapper;

import static com.chic.qh.repository.mapper.GoodsQuoteDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.chic.qh.repository.model.GoodsQuote;
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
public interface GoodsQuoteMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    BasicColumn[] selectList = BasicColumn.columnList(recId, quoteName, goodsId, version, createdAt);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.recId")
    int insert(InsertStatementProvider<GoodsQuote> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.recId")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<GoodsQuote> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="GoodsQuoteResult", value = {
        @Result(column="rec_id", property="recId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="quote_name", property="quoteName", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_id", property="goodsId", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.INTEGER)
    })
    List<GoodsQuote> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("GoodsQuoteResult")
    Optional<GoodsQuote> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, goodsQuote, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, goodsQuote, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    default int deleteByPrimaryKey(Integer recId_) {
        return delete(c -> 
            c.where(recId, isEqualTo(recId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    default int insert(GoodsQuote row) {
        return MyBatis3Utils.insert(this::insert, row, goodsQuote, c ->
            c.map(quoteName).toProperty("quoteName")
            .map(goodsId).toProperty("goodsId")
            .map(version).toProperty("version")
            .map(createdAt).toProperty("createdAt")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    default int insertMultiple(Collection<GoodsQuote> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, goodsQuote, c ->
            c.map(quoteName).toProperty("quoteName")
            .map(goodsId).toProperty("goodsId")
            .map(version).toProperty("version")
            .map(createdAt).toProperty("createdAt")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    default int insertSelective(GoodsQuote row) {
        return MyBatis3Utils.insert(this::insert, row, goodsQuote, c ->
            c.map(quoteName).toPropertyWhenPresent("quoteName", row::getQuoteName)
            .map(goodsId).toPropertyWhenPresent("goodsId", row::getGoodsId)
            .map(version).toPropertyWhenPresent("version", row::getVersion)
            .map(createdAt).toPropertyWhenPresent("createdAt", row::getCreatedAt)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    default Optional<GoodsQuote> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, goodsQuote, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    default List<GoodsQuote> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, goodsQuote, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    default List<GoodsQuote> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, goodsQuote, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    default Optional<GoodsQuote> selectByPrimaryKey(Integer recId_) {
        return selectOne(c ->
            c.where(recId, isEqualTo(recId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, goodsQuote, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    static UpdateDSL<UpdateModel> updateAllColumns(GoodsQuote row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(quoteName).equalTo(row::getQuoteName)
                .set(goodsId).equalTo(row::getGoodsId)
                .set(version).equalTo(row::getVersion)
                .set(createdAt).equalTo(row::getCreatedAt);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(GoodsQuote row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(quoteName).equalToWhenPresent(row::getQuoteName)
                .set(goodsId).equalToWhenPresent(row::getGoodsId)
                .set(version).equalToWhenPresent(row::getVersion)
                .set(createdAt).equalToWhenPresent(row::getCreatedAt);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    default int updateByPrimaryKey(GoodsQuote row) {
        return update(c ->
            c.set(quoteName).equalTo(row::getQuoteName)
            .set(goodsId).equalTo(row::getGoodsId)
            .set(version).equalTo(row::getVersion)
            .set(createdAt).equalTo(row::getCreatedAt)
            .where(recId, isEqualTo(row::getRecId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote")
    default int updateByPrimaryKeySelective(GoodsQuote row) {
        return update(c ->
            c.set(quoteName).equalToWhenPresent(row::getQuoteName)
            .set(goodsId).equalToWhenPresent(row::getGoodsId)
            .set(version).equalToWhenPresent(row::getVersion)
            .set(createdAt).equalToWhenPresent(row::getCreatedAt)
            .where(recId, isEqualTo(row::getRecId))
        );
    }
}