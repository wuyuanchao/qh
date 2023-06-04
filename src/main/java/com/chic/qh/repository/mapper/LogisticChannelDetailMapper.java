package com.chic.qh.repository.mapper;

import static com.chic.qh.repository.mapper.LogisticChannelDetailDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.chic.qh.repository.model.LogisticChannelDetail;
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
public interface LogisticChannelDetailMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    BasicColumn[] selectList = BasicColumn.columnList(recId, channelId, country, shippingTime, volWeightRate, weightLeft, weightRight, shippingFee, extraFee);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.recId")
    int insert(InsertStatementProvider<LogisticChannelDetail> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.recId")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<LogisticChannelDetail> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="LogisticChannelDetailResult", value = {
        @Result(column="rec_id", property="recId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="channel_id", property="channelId", jdbcType=JdbcType.INTEGER),
        @Result(column="country", property="country", jdbcType=JdbcType.VARCHAR),
        @Result(column="shipping_time", property="shippingTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="vol_weight_rate", property="volWeightRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="weight_left", property="weightLeft", jdbcType=JdbcType.DECIMAL),
        @Result(column="weight_right", property="weightRight", jdbcType=JdbcType.DECIMAL),
        @Result(column="shipping_fee", property="shippingFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="extra_fee", property="extraFee", jdbcType=JdbcType.DECIMAL)
    })
    List<LogisticChannelDetail> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("LogisticChannelDetailResult")
    Optional<LogisticChannelDetail> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, logisticChannelDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, logisticChannelDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    default int deleteByPrimaryKey(Integer recId_) {
        return delete(c -> 
            c.where(recId, isEqualTo(recId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    default int insert(LogisticChannelDetail row) {
        return MyBatis3Utils.insert(this::insert, row, logisticChannelDetail, c ->
            c.map(channelId).toProperty("channelId")
            .map(country).toProperty("country")
            .map(shippingTime).toProperty("shippingTime")
            .map(volWeightRate).toProperty("volWeightRate")
            .map(weightLeft).toProperty("weightLeft")
            .map(weightRight).toProperty("weightRight")
            .map(shippingFee).toProperty("shippingFee")
            .map(extraFee).toProperty("extraFee")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    default int insertMultiple(Collection<LogisticChannelDetail> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, logisticChannelDetail, c ->
            c.map(channelId).toProperty("channelId")
            .map(country).toProperty("country")
            .map(shippingTime).toProperty("shippingTime")
            .map(volWeightRate).toProperty("volWeightRate")
            .map(weightLeft).toProperty("weightLeft")
            .map(weightRight).toProperty("weightRight")
            .map(shippingFee).toProperty("shippingFee")
            .map(extraFee).toProperty("extraFee")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    default int insertSelective(LogisticChannelDetail row) {
        return MyBatis3Utils.insert(this::insert, row, logisticChannelDetail, c ->
            c.map(channelId).toPropertyWhenPresent("channelId", row::getChannelId)
            .map(country).toPropertyWhenPresent("country", row::getCountry)
            .map(shippingTime).toPropertyWhenPresent("shippingTime", row::getShippingTime)
            .map(volWeightRate).toPropertyWhenPresent("volWeightRate", row::getVolWeightRate)
            .map(weightLeft).toPropertyWhenPresent("weightLeft", row::getWeightLeft)
            .map(weightRight).toPropertyWhenPresent("weightRight", row::getWeightRight)
            .map(shippingFee).toPropertyWhenPresent("shippingFee", row::getShippingFee)
            .map(extraFee).toPropertyWhenPresent("extraFee", row::getExtraFee)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    default Optional<LogisticChannelDetail> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, logisticChannelDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    default List<LogisticChannelDetail> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, logisticChannelDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    default List<LogisticChannelDetail> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, logisticChannelDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    default Optional<LogisticChannelDetail> selectByPrimaryKey(Integer recId_) {
        return selectOne(c ->
            c.where(recId, isEqualTo(recId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, logisticChannelDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    static UpdateDSL<UpdateModel> updateAllColumns(LogisticChannelDetail row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(channelId).equalTo(row::getChannelId)
                .set(country).equalTo(row::getCountry)
                .set(shippingTime).equalTo(row::getShippingTime)
                .set(volWeightRate).equalTo(row::getVolWeightRate)
                .set(weightLeft).equalTo(row::getWeightLeft)
                .set(weightRight).equalTo(row::getWeightRight)
                .set(shippingFee).equalTo(row::getShippingFee)
                .set(extraFee).equalTo(row::getExtraFee);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(LogisticChannelDetail row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(channelId).equalToWhenPresent(row::getChannelId)
                .set(country).equalToWhenPresent(row::getCountry)
                .set(shippingTime).equalToWhenPresent(row::getShippingTime)
                .set(volWeightRate).equalToWhenPresent(row::getVolWeightRate)
                .set(weightLeft).equalToWhenPresent(row::getWeightLeft)
                .set(weightRight).equalToWhenPresent(row::getWeightRight)
                .set(shippingFee).equalToWhenPresent(row::getShippingFee)
                .set(extraFee).equalToWhenPresent(row::getExtraFee);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    default int updateByPrimaryKey(LogisticChannelDetail row) {
        return update(c ->
            c.set(channelId).equalTo(row::getChannelId)
            .set(country).equalTo(row::getCountry)
            .set(shippingTime).equalTo(row::getShippingTime)
            .set(volWeightRate).equalTo(row::getVolWeightRate)
            .set(weightLeft).equalTo(row::getWeightLeft)
            .set(weightRight).equalTo(row::getWeightRight)
            .set(shippingFee).equalTo(row::getShippingFee)
            .set(extraFee).equalTo(row::getExtraFee)
            .where(recId, isEqualTo(row::getRecId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel_detail")
    default int updateByPrimaryKeySelective(LogisticChannelDetail row) {
        return update(c ->
            c.set(channelId).equalToWhenPresent(row::getChannelId)
            .set(country).equalToWhenPresent(row::getCountry)
            .set(shippingTime).equalToWhenPresent(row::getShippingTime)
            .set(volWeightRate).equalToWhenPresent(row::getVolWeightRate)
            .set(weightLeft).equalToWhenPresent(row::getWeightLeft)
            .set(weightRight).equalToWhenPresent(row::getWeightRight)
            .set(shippingFee).equalToWhenPresent(row::getShippingFee)
            .set(extraFee).equalToWhenPresent(row::getExtraFee)
            .where(recId, isEqualTo(row::getRecId))
        );
    }
}