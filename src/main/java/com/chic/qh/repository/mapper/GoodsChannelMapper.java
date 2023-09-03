package com.chic.qh.repository.mapper;

import static com.chic.qh.repository.mapper.GoodsChannelDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.chic.qh.repository.model.GoodsChannel;
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
public interface GoodsChannelMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    BasicColumn[] selectList = BasicColumn.columnList(recId, goodsId, countryCode, channelCode, updatedAt, channelType);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.recId")
    int insert(InsertStatementProvider<GoodsChannel> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.recId")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<GoodsChannel> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="GoodsChannelResult", value = {
        @Result(column="rec_id", property="recId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="goods_id", property="goodsId", jdbcType=JdbcType.INTEGER),
        @Result(column="country_code", property="countryCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_code", property="channelCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.INTEGER),
        @Result(column="channel_type", property="channelType", jdbcType=JdbcType.TINYINT)
    })
    List<GoodsChannel> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("GoodsChannelResult")
    Optional<GoodsChannel> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, goodsChannel, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, goodsChannel, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    default int deleteByPrimaryKey(Integer recId_) {
        return delete(c -> 
            c.where(recId, isEqualTo(recId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    default int insert(GoodsChannel row) {
        return MyBatis3Utils.insert(this::insert, row, goodsChannel, c ->
            c.map(goodsId).toProperty("goodsId")
            .map(countryCode).toProperty("countryCode")
            .map(channelCode).toProperty("channelCode")
            .map(updatedAt).toProperty("updatedAt")
            .map(channelType).toProperty("channelType")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    default int insertMultiple(Collection<GoodsChannel> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, goodsChannel, c ->
            c.map(goodsId).toProperty("goodsId")
            .map(countryCode).toProperty("countryCode")
            .map(channelCode).toProperty("channelCode")
            .map(updatedAt).toProperty("updatedAt")
            .map(channelType).toProperty("channelType")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    default int insertSelective(GoodsChannel row) {
        return MyBatis3Utils.insert(this::insert, row, goodsChannel, c ->
            c.map(goodsId).toPropertyWhenPresent("goodsId", row::getGoodsId)
            .map(countryCode).toPropertyWhenPresent("countryCode", row::getCountryCode)
            .map(channelCode).toPropertyWhenPresent("channelCode", row::getChannelCode)
            .map(updatedAt).toPropertyWhenPresent("updatedAt", row::getUpdatedAt)
            .map(channelType).toPropertyWhenPresent("channelType", row::getChannelType)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    default Optional<GoodsChannel> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, goodsChannel, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    default List<GoodsChannel> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, goodsChannel, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    default List<GoodsChannel> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, goodsChannel, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    default Optional<GoodsChannel> selectByPrimaryKey(Integer recId_) {
        return selectOne(c ->
            c.where(recId, isEqualTo(recId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, goodsChannel, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    static UpdateDSL<UpdateModel> updateAllColumns(GoodsChannel row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(goodsId).equalTo(row::getGoodsId)
                .set(countryCode).equalTo(row::getCountryCode)
                .set(channelCode).equalTo(row::getChannelCode)
                .set(updatedAt).equalTo(row::getUpdatedAt)
                .set(channelType).equalTo(row::getChannelType);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(GoodsChannel row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(goodsId).equalToWhenPresent(row::getGoodsId)
                .set(countryCode).equalToWhenPresent(row::getCountryCode)
                .set(channelCode).equalToWhenPresent(row::getChannelCode)
                .set(updatedAt).equalToWhenPresent(row::getUpdatedAt)
                .set(channelType).equalToWhenPresent(row::getChannelType);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    default int updateByPrimaryKey(GoodsChannel row) {
        return update(c ->
            c.set(goodsId).equalTo(row::getGoodsId)
            .set(countryCode).equalTo(row::getCountryCode)
            .set(channelCode).equalTo(row::getChannelCode)
            .set(updatedAt).equalTo(row::getUpdatedAt)
            .set(channelType).equalTo(row::getChannelType)
            .where(recId, isEqualTo(row::getRecId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_channel")
    default int updateByPrimaryKeySelective(GoodsChannel row) {
        return update(c ->
            c.set(goodsId).equalToWhenPresent(row::getGoodsId)
            .set(countryCode).equalToWhenPresent(row::getCountryCode)
            .set(channelCode).equalToWhenPresent(row::getChannelCode)
            .set(updatedAt).equalToWhenPresent(row::getUpdatedAt)
            .set(channelType).equalToWhenPresent(row::getChannelType)
            .where(recId, isEqualTo(row::getRecId))
        );
    }
}