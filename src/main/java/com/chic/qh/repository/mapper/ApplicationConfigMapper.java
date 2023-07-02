package com.chic.qh.repository.mapper;

import static com.chic.qh.repository.mapper.ApplicationConfigDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.chic.qh.repository.model.ApplicationConfig;
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
public interface ApplicationConfigMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    BasicColumn[] selectList = BasicColumn.columnList(recId, configKey, configContent, updatedAt);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.recId")
    int insert(InsertStatementProvider<ApplicationConfig> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.recId")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<ApplicationConfig> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ApplicationConfigResult", value = {
        @Result(column="rec_id", property="recId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="config_key", property="configKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="config_content", property="configContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.INTEGER)
    })
    List<ApplicationConfig> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ApplicationConfigResult")
    Optional<ApplicationConfig> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, applicationConfig, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, applicationConfig, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    default int deleteByPrimaryKey(Integer recId_) {
        return delete(c -> 
            c.where(recId, isEqualTo(recId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    default int insert(ApplicationConfig row) {
        return MyBatis3Utils.insert(this::insert, row, applicationConfig, c ->
            c.map(configKey).toProperty("configKey")
            .map(configContent).toProperty("configContent")
            .map(updatedAt).toProperty("updatedAt")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    default int insertMultiple(Collection<ApplicationConfig> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, applicationConfig, c ->
            c.map(configKey).toProperty("configKey")
            .map(configContent).toProperty("configContent")
            .map(updatedAt).toProperty("updatedAt")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    default int insertSelective(ApplicationConfig row) {
        return MyBatis3Utils.insert(this::insert, row, applicationConfig, c ->
            c.map(configKey).toPropertyWhenPresent("configKey", row::getConfigKey)
            .map(configContent).toPropertyWhenPresent("configContent", row::getConfigContent)
            .map(updatedAt).toPropertyWhenPresent("updatedAt", row::getUpdatedAt)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    default Optional<ApplicationConfig> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, applicationConfig, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    default List<ApplicationConfig> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, applicationConfig, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    default List<ApplicationConfig> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, applicationConfig, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    default Optional<ApplicationConfig> selectByPrimaryKey(Integer recId_) {
        return selectOne(c ->
            c.where(recId, isEqualTo(recId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, applicationConfig, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    static UpdateDSL<UpdateModel> updateAllColumns(ApplicationConfig row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(configKey).equalTo(row::getConfigKey)
                .set(configContent).equalTo(row::getConfigContent)
                .set(updatedAt).equalTo(row::getUpdatedAt);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ApplicationConfig row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(configKey).equalToWhenPresent(row::getConfigKey)
                .set(configContent).equalToWhenPresent(row::getConfigContent)
                .set(updatedAt).equalToWhenPresent(row::getUpdatedAt);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    default int updateByPrimaryKey(ApplicationConfig row) {
        return update(c ->
            c.set(configKey).equalTo(row::getConfigKey)
            .set(configContent).equalTo(row::getConfigContent)
            .set(updatedAt).equalTo(row::getUpdatedAt)
            .where(recId, isEqualTo(row::getRecId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    default int updateByPrimaryKeySelective(ApplicationConfig row) {
        return update(c ->
            c.set(configKey).equalToWhenPresent(row::getConfigKey)
            .set(configContent).equalToWhenPresent(row::getConfigContent)
            .set(updatedAt).equalToWhenPresent(row::getUpdatedAt)
            .where(recId, isEqualTo(row::getRecId))
        );
    }
}