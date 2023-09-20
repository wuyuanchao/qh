package com.chic.qh.repository.mapper;

import static com.chic.qh.repository.mapper.SettleOrderInfoDynamicSqlSupport.*;

import com.chic.qh.repository.model.SettleOrderInfo;
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
public interface SettleOrderInfoMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_info")
    BasicColumn[] selectList = BasicColumn.columnList(settleOrderId, settleOrderSn, totalAmount, operatorId, gmtCreated, gmtModify);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_info")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.settleOrderId")
    int insert(InsertStatementProvider<SettleOrderInfo> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_info")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.settleOrderId")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<SettleOrderInfo> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SettleOrderInfoResult", value = {
        @Result(column="settle_order_id", property="settleOrderId", jdbcType=JdbcType.INTEGER),
        @Result(column="settle_order_sn", property="settleOrderSn", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="operator_id", property="operatorId", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_created", property="gmtCreated", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.INTEGER)
    })
    List<SettleOrderInfo> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SettleOrderInfoResult")
    Optional<SettleOrderInfo> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_info")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, settleOrderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_info")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, settleOrderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_info")
    default int insert(SettleOrderInfo row) {
        return MyBatis3Utils.insert(this::insert, row, settleOrderInfo, c ->
            c.map(settleOrderSn).toProperty("settleOrderSn")
            .map(totalAmount).toProperty("totalAmount")
            .map(operatorId).toProperty("operatorId")
            .map(gmtCreated).toProperty("gmtCreated")
            .map(gmtModify).toProperty("gmtModify")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_info")
    default int insertMultiple(Collection<SettleOrderInfo> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, settleOrderInfo, c ->
            c.map(settleOrderSn).toProperty("settleOrderSn")
            .map(totalAmount).toProperty("totalAmount")
            .map(operatorId).toProperty("operatorId")
            .map(gmtCreated).toProperty("gmtCreated")
            .map(gmtModify).toProperty("gmtModify")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_info")
    default int insertSelective(SettleOrderInfo row) {
        return MyBatis3Utils.insert(this::insert, row, settleOrderInfo, c ->
            c.map(settleOrderSn).toPropertyWhenPresent("settleOrderSn", row::getSettleOrderSn)
            .map(totalAmount).toPropertyWhenPresent("totalAmount", row::getTotalAmount)
            .map(operatorId).toPropertyWhenPresent("operatorId", row::getOperatorId)
            .map(gmtCreated).toPropertyWhenPresent("gmtCreated", row::getGmtCreated)
            .map(gmtModify).toPropertyWhenPresent("gmtModify", row::getGmtModify)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_info")
    default Optional<SettleOrderInfo> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, settleOrderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_info")
    default List<SettleOrderInfo> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, settleOrderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_info")
    default List<SettleOrderInfo> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, settleOrderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_info")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, settleOrderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_info")
    static UpdateDSL<UpdateModel> updateAllColumns(SettleOrderInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(settleOrderSn).equalTo(row::getSettleOrderSn)
                .set(totalAmount).equalTo(row::getTotalAmount)
                .set(operatorId).equalTo(row::getOperatorId)
                .set(gmtCreated).equalTo(row::getGmtCreated)
                .set(gmtModify).equalTo(row::getGmtModify);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_info")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SettleOrderInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(settleOrderSn).equalToWhenPresent(row::getSettleOrderSn)
                .set(totalAmount).equalToWhenPresent(row::getTotalAmount)
                .set(operatorId).equalToWhenPresent(row::getOperatorId)
                .set(gmtCreated).equalToWhenPresent(row::getGmtCreated)
                .set(gmtModify).equalToWhenPresent(row::getGmtModify);
    }
}