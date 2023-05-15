package com.chic.qh.domain.dal.mapper;

import static com.chic.qh.domain.dal.mapper.UserInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.chic.qh.domain.dal.model.UserInfo;
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
public interface UserInfoMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    BasicColumn[] selectList = BasicColumn.columnList(userId, username, password, avatar, roleName, status, gmtCreated, gmtModify);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.userId")
    int insert(InsertStatementProvider<UserInfo> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.userId")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<UserInfo> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserInfoResult", value = {
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_created", property="gmtCreated", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.INTEGER)
    })
    List<UserInfo> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserInfoResult")
    Optional<UserInfo> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, userInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, userInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    default int deleteByPrimaryKey(Integer userId_) {
        return delete(c -> 
            c.where(userId, isEqualTo(userId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    default int insert(UserInfo row) {
        return MyBatis3Utils.insert(this::insert, row, userInfo, c ->
            c.map(username).toProperty("username")
            .map(password).toProperty("password")
            .map(avatar).toProperty("avatar")
            .map(roleName).toProperty("roleName")
            .map(status).toProperty("status")
            .map(gmtCreated).toProperty("gmtCreated")
            .map(gmtModify).toProperty("gmtModify")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    default int insertMultiple(Collection<UserInfo> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, userInfo, c ->
            c.map(username).toProperty("username")
            .map(password).toProperty("password")
            .map(avatar).toProperty("avatar")
            .map(roleName).toProperty("roleName")
            .map(status).toProperty("status")
            .map(gmtCreated).toProperty("gmtCreated")
            .map(gmtModify).toProperty("gmtModify")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    default int insertSelective(UserInfo row) {
        return MyBatis3Utils.insert(this::insert, row, userInfo, c ->
            c.map(username).toPropertyWhenPresent("username", row::getUsername)
            .map(password).toPropertyWhenPresent("password", row::getPassword)
            .map(avatar).toPropertyWhenPresent("avatar", row::getAvatar)
            .map(roleName).toPropertyWhenPresent("roleName", row::getRoleName)
            .map(status).toPropertyWhenPresent("status", row::getStatus)
            .map(gmtCreated).toPropertyWhenPresent("gmtCreated", row::getGmtCreated)
            .map(gmtModify).toPropertyWhenPresent("gmtModify", row::getGmtModify)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    default Optional<UserInfo> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, userInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    default List<UserInfo> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, userInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    default List<UserInfo> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, userInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    default Optional<UserInfo> selectByPrimaryKey(Integer userId_) {
        return selectOne(c ->
            c.where(userId, isEqualTo(userId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, userInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    static UpdateDSL<UpdateModel> updateAllColumns(UserInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(username).equalTo(row::getUsername)
                .set(password).equalTo(row::getPassword)
                .set(avatar).equalTo(row::getAvatar)
                .set(roleName).equalTo(row::getRoleName)
                .set(status).equalTo(row::getStatus)
                .set(gmtCreated).equalTo(row::getGmtCreated)
                .set(gmtModify).equalTo(row::getGmtModify);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UserInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(username).equalToWhenPresent(row::getUsername)
                .set(password).equalToWhenPresent(row::getPassword)
                .set(avatar).equalToWhenPresent(row::getAvatar)
                .set(roleName).equalToWhenPresent(row::getRoleName)
                .set(status).equalToWhenPresent(row::getStatus)
                .set(gmtCreated).equalToWhenPresent(row::getGmtCreated)
                .set(gmtModify).equalToWhenPresent(row::getGmtModify);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    default int updateByPrimaryKey(UserInfo row) {
        return update(c ->
            c.set(username).equalTo(row::getUsername)
            .set(password).equalTo(row::getPassword)
            .set(avatar).equalTo(row::getAvatar)
            .set(roleName).equalTo(row::getRoleName)
            .set(status).equalTo(row::getStatus)
            .set(gmtCreated).equalTo(row::getGmtCreated)
            .set(gmtModify).equalTo(row::getGmtModify)
            .where(userId, isEqualTo(row::getUserId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    default int updateByPrimaryKeySelective(UserInfo row) {
        return update(c ->
            c.set(username).equalToWhenPresent(row::getUsername)
            .set(password).equalToWhenPresent(row::getPassword)
            .set(avatar).equalToWhenPresent(row::getAvatar)
            .set(roleName).equalToWhenPresent(row::getRoleName)
            .set(status).equalToWhenPresent(row::getStatus)
            .set(gmtCreated).equalToWhenPresent(row::getGmtCreated)
            .set(gmtModify).equalToWhenPresent(row::getGmtModify)
            .where(userId, isEqualTo(row::getUserId))
        );
    }
}