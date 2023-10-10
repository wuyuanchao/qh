package com.chic.qh.repository.mapper;

import static com.chic.qh.repository.mapper.OrderInfoDynamicSqlSupport.*;

import com.chic.qh.repository.model.OrderInfo;
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
public interface OrderInfoMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_order_info")
    BasicColumn[] selectList = BasicColumn.columnList(orderId, orderSn, trackingNumber, trackingNumber2, quantity, price, dxmSku, dxmProductCode, sku, productId, country, countryCode, province, city, address, zipCode, shippingName, phoneNumber, orderTime, payTime, shippingTime, shippingMethod, status, gmtCreated, gmtModify);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_order_info")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.orderId")
    int insert(InsertStatementProvider<OrderInfo> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_order_info")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.orderId")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<OrderInfo> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_order_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="OrderInfoResult", value = {
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
        @Result(column="order_sn", property="orderSn", jdbcType=JdbcType.VARCHAR),
        @Result(column="tracking_number", property="trackingNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="tracking_number2", property="trackingNumber2", jdbcType=JdbcType.VARCHAR),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="dxm_sku", property="dxmSku", jdbcType=JdbcType.VARCHAR),
        @Result(column="dxm_product_code", property="dxmProductCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku", property="sku", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="country", property="country", jdbcType=JdbcType.VARCHAR),
        @Result(column="country_code", property="countryCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="zip_code", property="zipCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="shipping_name", property="shippingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_number", property="phoneNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_time", property="orderTime", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.INTEGER),
        @Result(column="shipping_time", property="shippingTime", jdbcType=JdbcType.INTEGER),
        @Result(column="shipping_method", property="shippingMethod", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_created", property="gmtCreated", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.INTEGER)
    })
    List<OrderInfo> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_order_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("OrderInfoResult")
    Optional<OrderInfo> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_order_info")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, orderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_order_info")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, orderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_order_info")
    default int insert(OrderInfo row) {
        return MyBatis3Utils.insert(this::insert, row, orderInfo, c ->
            c.map(orderSn).toProperty("orderSn")
            .map(trackingNumber).toProperty("trackingNumber")
            .map(trackingNumber2).toProperty("trackingNumber2")
            .map(quantity).toProperty("quantity")
            .map(price).toProperty("price")
            .map(dxmSku).toProperty("dxmSku")
            .map(dxmProductCode).toProperty("dxmProductCode")
            .map(sku).toProperty("sku")
            .map(productId).toProperty("productId")
            .map(country).toProperty("country")
            .map(countryCode).toProperty("countryCode")
            .map(province).toProperty("province")
            .map(city).toProperty("city")
            .map(address).toProperty("address")
            .map(zipCode).toProperty("zipCode")
            .map(shippingName).toProperty("shippingName")
            .map(phoneNumber).toProperty("phoneNumber")
            .map(orderTime).toProperty("orderTime")
            .map(payTime).toProperty("payTime")
            .map(shippingTime).toProperty("shippingTime")
            .map(shippingMethod).toProperty("shippingMethod")
            .map(status).toProperty("status")
            .map(gmtCreated).toProperty("gmtCreated")
            .map(gmtModify).toProperty("gmtModify")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_order_info")
    default int insertMultiple(Collection<OrderInfo> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, orderInfo, c ->
            c.map(orderSn).toProperty("orderSn")
            .map(trackingNumber).toProperty("trackingNumber")
            .map(trackingNumber2).toProperty("trackingNumber2")
            .map(quantity).toProperty("quantity")
            .map(price).toProperty("price")
            .map(dxmSku).toProperty("dxmSku")
            .map(dxmProductCode).toProperty("dxmProductCode")
            .map(sku).toProperty("sku")
            .map(productId).toProperty("productId")
            .map(country).toProperty("country")
            .map(countryCode).toProperty("countryCode")
            .map(province).toProperty("province")
            .map(city).toProperty("city")
            .map(address).toProperty("address")
            .map(zipCode).toProperty("zipCode")
            .map(shippingName).toProperty("shippingName")
            .map(phoneNumber).toProperty("phoneNumber")
            .map(orderTime).toProperty("orderTime")
            .map(payTime).toProperty("payTime")
            .map(shippingTime).toProperty("shippingTime")
            .map(shippingMethod).toProperty("shippingMethod")
            .map(status).toProperty("status")
            .map(gmtCreated).toProperty("gmtCreated")
            .map(gmtModify).toProperty("gmtModify")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_order_info")
    default int insertSelective(OrderInfo row) {
        return MyBatis3Utils.insert(this::insert, row, orderInfo, c ->
            c.map(orderSn).toPropertyWhenPresent("orderSn", row::getOrderSn)
            .map(trackingNumber).toPropertyWhenPresent("trackingNumber", row::getTrackingNumber)
            .map(trackingNumber2).toPropertyWhenPresent("trackingNumber2", row::getTrackingNumber2)
            .map(quantity).toPropertyWhenPresent("quantity", row::getQuantity)
            .map(price).toPropertyWhenPresent("price", row::getPrice)
            .map(dxmSku).toPropertyWhenPresent("dxmSku", row::getDxmSku)
            .map(dxmProductCode).toPropertyWhenPresent("dxmProductCode", row::getDxmProductCode)
            .map(sku).toPropertyWhenPresent("sku", row::getSku)
            .map(productId).toPropertyWhenPresent("productId", row::getProductId)
            .map(country).toPropertyWhenPresent("country", row::getCountry)
            .map(countryCode).toPropertyWhenPresent("countryCode", row::getCountryCode)
            .map(province).toPropertyWhenPresent("province", row::getProvince)
            .map(city).toPropertyWhenPresent("city", row::getCity)
            .map(address).toPropertyWhenPresent("address", row::getAddress)
            .map(zipCode).toPropertyWhenPresent("zipCode", row::getZipCode)
            .map(shippingName).toPropertyWhenPresent("shippingName", row::getShippingName)
            .map(phoneNumber).toPropertyWhenPresent("phoneNumber", row::getPhoneNumber)
            .map(orderTime).toPropertyWhenPresent("orderTime", row::getOrderTime)
            .map(payTime).toPropertyWhenPresent("payTime", row::getPayTime)
            .map(shippingTime).toPropertyWhenPresent("shippingTime", row::getShippingTime)
            .map(shippingMethod).toPropertyWhenPresent("shippingMethod", row::getShippingMethod)
            .map(status).toPropertyWhenPresent("status", row::getStatus)
            .map(gmtCreated).toPropertyWhenPresent("gmtCreated", row::getGmtCreated)
            .map(gmtModify).toPropertyWhenPresent("gmtModify", row::getGmtModify)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_order_info")
    default Optional<OrderInfo> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, orderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_order_info")
    default List<OrderInfo> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, orderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_order_info")
    default List<OrderInfo> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, orderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_order_info")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, orderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_order_info")
    static UpdateDSL<UpdateModel> updateAllColumns(OrderInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(orderSn).equalTo(row::getOrderSn)
                .set(trackingNumber).equalTo(row::getTrackingNumber)
                .set(trackingNumber2).equalTo(row::getTrackingNumber2)
                .set(quantity).equalTo(row::getQuantity)
                .set(price).equalTo(row::getPrice)
                .set(dxmSku).equalTo(row::getDxmSku)
                .set(dxmProductCode).equalTo(row::getDxmProductCode)
                .set(sku).equalTo(row::getSku)
                .set(productId).equalTo(row::getProductId)
                .set(country).equalTo(row::getCountry)
                .set(countryCode).equalTo(row::getCountryCode)
                .set(province).equalTo(row::getProvince)
                .set(city).equalTo(row::getCity)
                .set(address).equalTo(row::getAddress)
                .set(zipCode).equalTo(row::getZipCode)
                .set(shippingName).equalTo(row::getShippingName)
                .set(phoneNumber).equalTo(row::getPhoneNumber)
                .set(orderTime).equalTo(row::getOrderTime)
                .set(payTime).equalTo(row::getPayTime)
                .set(shippingTime).equalTo(row::getShippingTime)
                .set(shippingMethod).equalTo(row::getShippingMethod)
                .set(status).equalTo(row::getStatus)
                .set(gmtCreated).equalTo(row::getGmtCreated)
                .set(gmtModify).equalTo(row::getGmtModify);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_order_info")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(OrderInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(orderSn).equalToWhenPresent(row::getOrderSn)
                .set(trackingNumber).equalToWhenPresent(row::getTrackingNumber)
                .set(trackingNumber2).equalToWhenPresent(row::getTrackingNumber2)
                .set(quantity).equalToWhenPresent(row::getQuantity)
                .set(price).equalToWhenPresent(row::getPrice)
                .set(dxmSku).equalToWhenPresent(row::getDxmSku)
                .set(dxmProductCode).equalToWhenPresent(row::getDxmProductCode)
                .set(sku).equalToWhenPresent(row::getSku)
                .set(productId).equalToWhenPresent(row::getProductId)
                .set(country).equalToWhenPresent(row::getCountry)
                .set(countryCode).equalToWhenPresent(row::getCountryCode)
                .set(province).equalToWhenPresent(row::getProvince)
                .set(city).equalToWhenPresent(row::getCity)
                .set(address).equalToWhenPresent(row::getAddress)
                .set(zipCode).equalToWhenPresent(row::getZipCode)
                .set(shippingName).equalToWhenPresent(row::getShippingName)
                .set(phoneNumber).equalToWhenPresent(row::getPhoneNumber)
                .set(orderTime).equalToWhenPresent(row::getOrderTime)
                .set(payTime).equalToWhenPresent(row::getPayTime)
                .set(shippingTime).equalToWhenPresent(row::getShippingTime)
                .set(shippingMethod).equalToWhenPresent(row::getShippingMethod)
                .set(status).equalToWhenPresent(row::getStatus)
                .set(gmtCreated).equalToWhenPresent(row::getGmtCreated)
                .set(gmtModify).equalToWhenPresent(row::getGmtModify);
    }
}