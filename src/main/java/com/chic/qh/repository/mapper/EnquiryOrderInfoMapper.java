package com.chic.qh.repository.mapper;

import static com.chic.qh.repository.mapper.EnquiryOrderInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.chic.qh.repository.model.EnquiryOrderInfo;
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
public interface EnquiryOrderInfoMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    BasicColumn[] selectList = BasicColumn.columnList(enquiryOrderId, enquiryOrderSn, enquiryOrderName, customerInfo, customerLink, remark, gmtCreated, gmtModify);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.enquiryOrderId")
    int insert(InsertStatementProvider<EnquiryOrderInfo> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.enquiryOrderId")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<EnquiryOrderInfo> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="EnquiryOrderInfoResult", value = {
        @Result(column="enquiry_order_id", property="enquiryOrderId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="enquiry_order_sn", property="enquiryOrderSn", jdbcType=JdbcType.VARCHAR),
        @Result(column="enquiry_order_name", property="enquiryOrderName", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_info", property="customerInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_link", property="customerLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_created", property="gmtCreated", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.INTEGER)
    })
    List<EnquiryOrderInfo> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("EnquiryOrderInfoResult")
    Optional<EnquiryOrderInfo> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, enquiryOrderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, enquiryOrderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default int deleteByPrimaryKey(Integer enquiryOrderId_) {
        return delete(c -> 
            c.where(enquiryOrderId, isEqualTo(enquiryOrderId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default int insert(EnquiryOrderInfo row) {
        return MyBatis3Utils.insert(this::insert, row, enquiryOrderInfo, c ->
            c.map(enquiryOrderSn).toProperty("enquiryOrderSn")
            .map(enquiryOrderName).toProperty("enquiryOrderName")
            .map(customerInfo).toProperty("customerInfo")
            .map(customerLink).toProperty("customerLink")
            .map(remark).toProperty("remark")
            .map(gmtCreated).toProperty("gmtCreated")
            .map(gmtModify).toProperty("gmtModify")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default int insertMultiple(Collection<EnquiryOrderInfo> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, enquiryOrderInfo, c ->
            c.map(enquiryOrderSn).toProperty("enquiryOrderSn")
            .map(enquiryOrderName).toProperty("enquiryOrderName")
            .map(customerInfo).toProperty("customerInfo")
            .map(customerLink).toProperty("customerLink")
            .map(remark).toProperty("remark")
            .map(gmtCreated).toProperty("gmtCreated")
            .map(gmtModify).toProperty("gmtModify")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default int insertSelective(EnquiryOrderInfo row) {
        return MyBatis3Utils.insert(this::insert, row, enquiryOrderInfo, c ->
            c.map(enquiryOrderSn).toPropertyWhenPresent("enquiryOrderSn", row::getEnquiryOrderSn)
            .map(enquiryOrderName).toPropertyWhenPresent("enquiryOrderName", row::getEnquiryOrderName)
            .map(customerInfo).toPropertyWhenPresent("customerInfo", row::getCustomerInfo)
            .map(customerLink).toPropertyWhenPresent("customerLink", row::getCustomerLink)
            .map(remark).toPropertyWhenPresent("remark", row::getRemark)
            .map(gmtCreated).toPropertyWhenPresent("gmtCreated", row::getGmtCreated)
            .map(gmtModify).toPropertyWhenPresent("gmtModify", row::getGmtModify)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default Optional<EnquiryOrderInfo> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, enquiryOrderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default List<EnquiryOrderInfo> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, enquiryOrderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default List<EnquiryOrderInfo> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, enquiryOrderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default Optional<EnquiryOrderInfo> selectByPrimaryKey(Integer enquiryOrderId_) {
        return selectOne(c ->
            c.where(enquiryOrderId, isEqualTo(enquiryOrderId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, enquiryOrderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    static UpdateDSL<UpdateModel> updateAllColumns(EnquiryOrderInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(enquiryOrderSn).equalTo(row::getEnquiryOrderSn)
                .set(enquiryOrderName).equalTo(row::getEnquiryOrderName)
                .set(customerInfo).equalTo(row::getCustomerInfo)
                .set(customerLink).equalTo(row::getCustomerLink)
                .set(remark).equalTo(row::getRemark)
                .set(gmtCreated).equalTo(row::getGmtCreated)
                .set(gmtModify).equalTo(row::getGmtModify);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(EnquiryOrderInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(enquiryOrderSn).equalToWhenPresent(row::getEnquiryOrderSn)
                .set(enquiryOrderName).equalToWhenPresent(row::getEnquiryOrderName)
                .set(customerInfo).equalToWhenPresent(row::getCustomerInfo)
                .set(customerLink).equalToWhenPresent(row::getCustomerLink)
                .set(remark).equalToWhenPresent(row::getRemark)
                .set(gmtCreated).equalToWhenPresent(row::getGmtCreated)
                .set(gmtModify).equalToWhenPresent(row::getGmtModify);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default int updateByPrimaryKey(EnquiryOrderInfo row) {
        return update(c ->
            c.set(enquiryOrderSn).equalTo(row::getEnquiryOrderSn)
            .set(enquiryOrderName).equalTo(row::getEnquiryOrderName)
            .set(customerInfo).equalTo(row::getCustomerInfo)
            .set(customerLink).equalTo(row::getCustomerLink)
            .set(remark).equalTo(row::getRemark)
            .set(gmtCreated).equalTo(row::getGmtCreated)
            .set(gmtModify).equalTo(row::getGmtModify)
            .where(enquiryOrderId, isEqualTo(row::getEnquiryOrderId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default int updateByPrimaryKeySelective(EnquiryOrderInfo row) {
        return update(c ->
            c.set(enquiryOrderSn).equalToWhenPresent(row::getEnquiryOrderSn)
            .set(enquiryOrderName).equalToWhenPresent(row::getEnquiryOrderName)
            .set(customerInfo).equalToWhenPresent(row::getCustomerInfo)
            .set(customerLink).equalToWhenPresent(row::getCustomerLink)
            .set(remark).equalToWhenPresent(row::getRemark)
            .set(gmtCreated).equalToWhenPresent(row::getGmtCreated)
            .set(gmtModify).equalToWhenPresent(row::getGmtModify)
            .where(enquiryOrderId, isEqualTo(row::getEnquiryOrderId))
        );
    }
}