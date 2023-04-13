package com.chic.qh.domain.dal.mapper;

import static com.chic.qh.domain.dal.mapper.EnquiryOrderInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.chic.qh.domain.dal.model.EnquiryOrderInfo;
import java.util.List;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.MyBatis3DeleteModelAdapter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.MyBatis3UpdateModelAdapter;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

@Mapper
public interface EnquiryOrderInfoMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.enquiryOrderId")
    int insert(InsertStatementProvider<EnquiryOrderInfo> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("EnquiryOrderInfoResult")
    EnquiryOrderInfo selectOne(SelectStatementProvider selectStatement);

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
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(enquiryOrderInfo);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, enquiryOrderInfo);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default int deleteByPrimaryKey(Integer enquiryOrderId_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, enquiryOrderInfo)
                .where(enquiryOrderId, isEqualTo(enquiryOrderId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default int insert(EnquiryOrderInfo record) {
        return insert(SqlBuilder.insert(record)
                .into(enquiryOrderInfo)
                .map(enquiryOrderSn).toProperty("enquiryOrderSn")
                .map(enquiryOrderName).toProperty("enquiryOrderName")
                .map(customerInfo).toProperty("customerInfo")
                .map(customerLink).toProperty("customerLink")
                .map(remark).toProperty("remark")
                .map(gmtCreated).toProperty("gmtCreated")
                .map(gmtModify).toProperty("gmtModify")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default int insertSelective(EnquiryOrderInfo record) {
        return insert(SqlBuilder.insert(record)
                .into(enquiryOrderInfo)
                .map(enquiryOrderSn).toPropertyWhenPresent("enquiryOrderSn", record::getEnquiryOrderSn)
                .map(enquiryOrderName).toPropertyWhenPresent("enquiryOrderName", record::getEnquiryOrderName)
                .map(customerInfo).toPropertyWhenPresent("customerInfo", record::getCustomerInfo)
                .map(customerLink).toPropertyWhenPresent("customerLink", record::getCustomerLink)
                .map(remark).toPropertyWhenPresent("remark", record::getRemark)
                .map(gmtCreated).toPropertyWhenPresent("gmtCreated", record::getGmtCreated)
                .map(gmtModify).toPropertyWhenPresent("gmtModify", record::getGmtModify)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<EnquiryOrderInfo>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, enquiryOrderId, enquiryOrderSn, enquiryOrderName, customerInfo, customerLink, remark, gmtCreated, gmtModify)
                .from(enquiryOrderInfo);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<EnquiryOrderInfo>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, enquiryOrderId, enquiryOrderSn, enquiryOrderName, customerInfo, customerLink, remark, gmtCreated, gmtModify)
                .from(enquiryOrderInfo);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default EnquiryOrderInfo selectByPrimaryKey(Integer enquiryOrderId_) {
        return SelectDSL.selectWithMapper(this::selectOne, enquiryOrderId, enquiryOrderSn, enquiryOrderName, customerInfo, customerLink, remark, gmtCreated, gmtModify)
                .from(enquiryOrderInfo)
                .where(enquiryOrderId, isEqualTo(enquiryOrderId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(EnquiryOrderInfo record) {
        return UpdateDSL.updateWithMapper(this::update, enquiryOrderInfo)
                .set(enquiryOrderSn).equalTo(record::getEnquiryOrderSn)
                .set(enquiryOrderName).equalTo(record::getEnquiryOrderName)
                .set(customerInfo).equalTo(record::getCustomerInfo)
                .set(customerLink).equalTo(record::getCustomerLink)
                .set(remark).equalTo(record::getRemark)
                .set(gmtCreated).equalTo(record::getGmtCreated)
                .set(gmtModify).equalTo(record::getGmtModify);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(EnquiryOrderInfo record) {
        return UpdateDSL.updateWithMapper(this::update, enquiryOrderInfo)
                .set(enquiryOrderSn).equalToWhenPresent(record::getEnquiryOrderSn)
                .set(enquiryOrderName).equalToWhenPresent(record::getEnquiryOrderName)
                .set(customerInfo).equalToWhenPresent(record::getCustomerInfo)
                .set(customerLink).equalToWhenPresent(record::getCustomerLink)
                .set(remark).equalToWhenPresent(record::getRemark)
                .set(gmtCreated).equalToWhenPresent(record::getGmtCreated)
                .set(gmtModify).equalToWhenPresent(record::getGmtModify);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default int updateByPrimaryKey(EnquiryOrderInfo record) {
        return UpdateDSL.updateWithMapper(this::update, enquiryOrderInfo)
                .set(enquiryOrderSn).equalTo(record::getEnquiryOrderSn)
                .set(enquiryOrderName).equalTo(record::getEnquiryOrderName)
                .set(customerInfo).equalTo(record::getCustomerInfo)
                .set(customerLink).equalTo(record::getCustomerLink)
                .set(remark).equalTo(record::getRemark)
                .set(gmtCreated).equalTo(record::getGmtCreated)
                .set(gmtModify).equalTo(record::getGmtModify)
                .where(enquiryOrderId, isEqualTo(record::getEnquiryOrderId))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_info")
    default int updateByPrimaryKeySelective(EnquiryOrderInfo record) {
        return UpdateDSL.updateWithMapper(this::update, enquiryOrderInfo)
                .set(enquiryOrderSn).equalToWhenPresent(record::getEnquiryOrderSn)
                .set(enquiryOrderName).equalToWhenPresent(record::getEnquiryOrderName)
                .set(customerInfo).equalToWhenPresent(record::getCustomerInfo)
                .set(customerLink).equalToWhenPresent(record::getCustomerLink)
                .set(remark).equalToWhenPresent(record::getRemark)
                .set(gmtCreated).equalToWhenPresent(record::getGmtCreated)
                .set(gmtModify).equalToWhenPresent(record::getGmtModify)
                .where(enquiryOrderId, isEqualTo(record::getEnquiryOrderId))
                .build()
                .execute();
    }
}