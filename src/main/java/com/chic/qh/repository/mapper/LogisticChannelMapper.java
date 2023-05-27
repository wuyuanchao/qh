package com.chic.qh.repository.mapper;

import static com.chic.qh.repository.mapper.LogisticChannelDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.chic.qh.repository.model.LogisticChannel;
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
public interface LogisticChannelMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    BasicColumn[] selectList = BasicColumn.columnList(recId, name, code, company, cutOffTime, costTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.recId")
    int insert(InsertStatementProvider<LogisticChannel> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.recId")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<LogisticChannel> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="LogisticChannelResult", value = {
        @Result(column="rec_id", property="recId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
        @Result(column="cut_off_time", property="cutOffTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="cost_time", property="costTime", jdbcType=JdbcType.VARCHAR)
    })
    List<LogisticChannel> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("LogisticChannelResult")
    Optional<LogisticChannel> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, logisticChannel, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, logisticChannel, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    default int deleteByPrimaryKey(Integer recId_) {
        return delete(c -> 
            c.where(recId, isEqualTo(recId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    default int insert(LogisticChannel row) {
        return MyBatis3Utils.insert(this::insert, row, logisticChannel, c ->
            c.map(name).toProperty("name")
            .map(code).toProperty("code")
            .map(company).toProperty("company")
            .map(cutOffTime).toProperty("cutOffTime")
            .map(costTime).toProperty("costTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    default int insertMultiple(Collection<LogisticChannel> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, logisticChannel, c ->
            c.map(name).toProperty("name")
            .map(code).toProperty("code")
            .map(company).toProperty("company")
            .map(cutOffTime).toProperty("cutOffTime")
            .map(costTime).toProperty("costTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    default int insertSelective(LogisticChannel row) {
        return MyBatis3Utils.insert(this::insert, row, logisticChannel, c ->
            c.map(name).toPropertyWhenPresent("name", row::getName)
            .map(code).toPropertyWhenPresent("code", row::getCode)
            .map(company).toPropertyWhenPresent("company", row::getCompany)
            .map(cutOffTime).toPropertyWhenPresent("cutOffTime", row::getCutOffTime)
            .map(costTime).toPropertyWhenPresent("costTime", row::getCostTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    default Optional<LogisticChannel> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, logisticChannel, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    default List<LogisticChannel> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, logisticChannel, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    default List<LogisticChannel> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, logisticChannel, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    default Optional<LogisticChannel> selectByPrimaryKey(Integer recId_) {
        return selectOne(c ->
            c.where(recId, isEqualTo(recId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, logisticChannel, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    static UpdateDSL<UpdateModel> updateAllColumns(LogisticChannel row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalTo(row::getName)
                .set(code).equalTo(row::getCode)
                .set(company).equalTo(row::getCompany)
                .set(cutOffTime).equalTo(row::getCutOffTime)
                .set(costTime).equalTo(row::getCostTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(LogisticChannel row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalToWhenPresent(row::getName)
                .set(code).equalToWhenPresent(row::getCode)
                .set(company).equalToWhenPresent(row::getCompany)
                .set(cutOffTime).equalToWhenPresent(row::getCutOffTime)
                .set(costTime).equalToWhenPresent(row::getCostTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    default int updateByPrimaryKey(LogisticChannel row) {
        return update(c ->
            c.set(name).equalTo(row::getName)
            .set(code).equalTo(row::getCode)
            .set(company).equalTo(row::getCompany)
            .set(cutOffTime).equalTo(row::getCutOffTime)
            .set(costTime).equalTo(row::getCostTime)
            .where(recId, isEqualTo(row::getRecId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    default int updateByPrimaryKeySelective(LogisticChannel row) {
        return update(c ->
            c.set(name).equalToWhenPresent(row::getName)
            .set(code).equalToWhenPresent(row::getCode)
            .set(company).equalToWhenPresent(row::getCompany)
            .set(cutOffTime).equalToWhenPresent(row::getCutOffTime)
            .set(costTime).equalToWhenPresent(row::getCostTime)
            .where(recId, isEqualTo(row::getRecId))
        );
    }
}