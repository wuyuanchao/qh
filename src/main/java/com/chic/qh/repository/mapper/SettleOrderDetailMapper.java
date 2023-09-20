package com.chic.qh.repository.mapper;

import static com.chic.qh.repository.mapper.SettleOrderDetailDynamicSqlSupport.*;

import com.chic.qh.repository.model.SettleOrderDetail;
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
public interface SettleOrderDetailMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_detail")
    BasicColumn[] selectList = BasicColumn.columnList(recId, settleOrderId, orderId, orderSn, quantity, sku, skuId, amount, quoteId, gmtCreated);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_detail")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.recId")
    int insert(InsertStatementProvider<SettleOrderDetail> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_detail")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.recId")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<SettleOrderDetail> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_detail")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SettleOrderDetailResult", value = {
        @Result(column="rec_id", property="recId", jdbcType=JdbcType.INTEGER),
        @Result(column="settle_order_id", property="settleOrderId", jdbcType=JdbcType.INTEGER),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
        @Result(column="order_sn", property="orderSn", jdbcType=JdbcType.VARCHAR),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="sku", property="sku", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_id", property="skuId", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="quote_id", property="quoteId", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_created", property="gmtCreated", jdbcType=JdbcType.INTEGER)
    })
    List<SettleOrderDetail> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_detail")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SettleOrderDetailResult")
    Optional<SettleOrderDetail> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_detail")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, settleOrderDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_detail")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, settleOrderDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_detail")
    default int insert(SettleOrderDetail row) {
        return MyBatis3Utils.insert(this::insert, row, settleOrderDetail, c ->
            c.map(settleOrderId).toProperty("settleOrderId")
            .map(orderId).toProperty("orderId")
            .map(orderSn).toProperty("orderSn")
            .map(quantity).toProperty("quantity")
            .map(sku).toProperty("sku")
            .map(skuId).toProperty("skuId")
            .map(amount).toProperty("amount")
            .map(quoteId).toProperty("quoteId")
            .map(gmtCreated).toProperty("gmtCreated")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_detail")
    default int insertMultiple(Collection<SettleOrderDetail> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, settleOrderDetail, c ->
            c.map(settleOrderId).toProperty("settleOrderId")
            .map(orderId).toProperty("orderId")
            .map(orderSn).toProperty("orderSn")
            .map(quantity).toProperty("quantity")
            .map(sku).toProperty("sku")
            .map(skuId).toProperty("skuId")
            .map(amount).toProperty("amount")
            .map(quoteId).toProperty("quoteId")
            .map(gmtCreated).toProperty("gmtCreated")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_detail")
    default int insertSelective(SettleOrderDetail row) {
        return MyBatis3Utils.insert(this::insert, row, settleOrderDetail, c ->
            c.map(settleOrderId).toPropertyWhenPresent("settleOrderId", row::getSettleOrderId)
            .map(orderId).toPropertyWhenPresent("orderId", row::getOrderId)
            .map(orderSn).toPropertyWhenPresent("orderSn", row::getOrderSn)
            .map(quantity).toPropertyWhenPresent("quantity", row::getQuantity)
            .map(sku).toPropertyWhenPresent("sku", row::getSku)
            .map(skuId).toPropertyWhenPresent("skuId", row::getSkuId)
            .map(amount).toPropertyWhenPresent("amount", row::getAmount)
            .map(quoteId).toPropertyWhenPresent("quoteId", row::getQuoteId)
            .map(gmtCreated).toPropertyWhenPresent("gmtCreated", row::getGmtCreated)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_detail")
    default Optional<SettleOrderDetail> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, settleOrderDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_detail")
    default List<SettleOrderDetail> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, settleOrderDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_detail")
    default List<SettleOrderDetail> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, settleOrderDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_detail")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, settleOrderDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_detail")
    static UpdateDSL<UpdateModel> updateAllColumns(SettleOrderDetail row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(settleOrderId).equalTo(row::getSettleOrderId)
                .set(orderId).equalTo(row::getOrderId)
                .set(orderSn).equalTo(row::getOrderSn)
                .set(quantity).equalTo(row::getQuantity)
                .set(sku).equalTo(row::getSku)
                .set(skuId).equalTo(row::getSkuId)
                .set(amount).equalTo(row::getAmount)
                .set(quoteId).equalTo(row::getQuoteId)
                .set(gmtCreated).equalTo(row::getGmtCreated);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_settle_order_detail")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SettleOrderDetail row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(settleOrderId).equalToWhenPresent(row::getSettleOrderId)
                .set(orderId).equalToWhenPresent(row::getOrderId)
                .set(orderSn).equalToWhenPresent(row::getOrderSn)
                .set(quantity).equalToWhenPresent(row::getQuantity)
                .set(sku).equalToWhenPresent(row::getSku)
                .set(skuId).equalToWhenPresent(row::getSkuId)
                .set(amount).equalToWhenPresent(row::getAmount)
                .set(quoteId).equalToWhenPresent(row::getQuoteId)
                .set(gmtCreated).equalToWhenPresent(row::getGmtCreated);
    }
}