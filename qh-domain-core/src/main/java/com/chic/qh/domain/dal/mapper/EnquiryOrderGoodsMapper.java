package com.chic.qh.domain.dal.mapper;

import static com.chic.qh.domain.dal.mapper.EnquiryOrderGoodsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.chic.qh.domain.dal.model.EnquiryOrderGoods;
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
public interface EnquiryOrderGoodsMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.recId")
    int insert(InsertStatementProvider<EnquiryOrderGoods> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("EnquiryOrderGoodsResult")
    EnquiryOrderGoods selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="EnquiryOrderGoodsResult", value = {
        @Result(column="rec_id", property="recId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="enquiry_order_id", property="enquiryOrderId", jdbcType=JdbcType.INTEGER),
        @Result(column="goods_name", property="goodsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_sn", property="goodsSn", jdbcType=JdbcType.VARCHAR),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="relation_type", property="relationType", jdbcType=JdbcType.TINYINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_created", property="gmtCreated", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.INTEGER)
    })
    List<EnquiryOrderGoods> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(enquiryOrderGoods);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, enquiryOrderGoods);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default int deleteByPrimaryKey(Integer recId_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, enquiryOrderGoods)
                .where(recId, isEqualTo(recId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default int insert(EnquiryOrderGoods record) {
        return insert(SqlBuilder.insert(record)
                .into(enquiryOrderGoods)
                .map(enquiryOrderId).toProperty("enquiryOrderId")
                .map(goodsName).toProperty("goodsName")
                .map(goodsSn).toProperty("goodsSn")
                .map(link).toProperty("link")
                .map(relationType).toProperty("relationType")
                .map(remark).toProperty("remark")
                .map(gmtCreated).toProperty("gmtCreated")
                .map(gmtModify).toProperty("gmtModify")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default int insertSelective(EnquiryOrderGoods record) {
        return insert(SqlBuilder.insert(record)
                .into(enquiryOrderGoods)
                .map(enquiryOrderId).toPropertyWhenPresent("enquiryOrderId", record::getEnquiryOrderId)
                .map(goodsName).toPropertyWhenPresent("goodsName", record::getGoodsName)
                .map(goodsSn).toPropertyWhenPresent("goodsSn", record::getGoodsSn)
                .map(link).toPropertyWhenPresent("link", record::getLink)
                .map(relationType).toPropertyWhenPresent("relationType", record::getRelationType)
                .map(remark).toPropertyWhenPresent("remark", record::getRemark)
                .map(gmtCreated).toPropertyWhenPresent("gmtCreated", record::getGmtCreated)
                .map(gmtModify).toPropertyWhenPresent("gmtModify", record::getGmtModify)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<EnquiryOrderGoods>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, recId, enquiryOrderId, goodsName, goodsSn, link, relationType, remark, gmtCreated, gmtModify)
                .from(enquiryOrderGoods);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<EnquiryOrderGoods>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, recId, enquiryOrderId, goodsName, goodsSn, link, relationType, remark, gmtCreated, gmtModify)
                .from(enquiryOrderGoods);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default EnquiryOrderGoods selectByPrimaryKey(Integer recId_) {
        return SelectDSL.selectWithMapper(this::selectOne, recId, enquiryOrderId, goodsName, goodsSn, link, relationType, remark, gmtCreated, gmtModify)
                .from(enquiryOrderGoods)
                .where(recId, isEqualTo(recId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(EnquiryOrderGoods record) {
        return UpdateDSL.updateWithMapper(this::update, enquiryOrderGoods)
                .set(enquiryOrderId).equalTo(record::getEnquiryOrderId)
                .set(goodsName).equalTo(record::getGoodsName)
                .set(goodsSn).equalTo(record::getGoodsSn)
                .set(link).equalTo(record::getLink)
                .set(relationType).equalTo(record::getRelationType)
                .set(remark).equalTo(record::getRemark)
                .set(gmtCreated).equalTo(record::getGmtCreated)
                .set(gmtModify).equalTo(record::getGmtModify);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(EnquiryOrderGoods record) {
        return UpdateDSL.updateWithMapper(this::update, enquiryOrderGoods)
                .set(enquiryOrderId).equalToWhenPresent(record::getEnquiryOrderId)
                .set(goodsName).equalToWhenPresent(record::getGoodsName)
                .set(goodsSn).equalToWhenPresent(record::getGoodsSn)
                .set(link).equalToWhenPresent(record::getLink)
                .set(relationType).equalToWhenPresent(record::getRelationType)
                .set(remark).equalToWhenPresent(record::getRemark)
                .set(gmtCreated).equalToWhenPresent(record::getGmtCreated)
                .set(gmtModify).equalToWhenPresent(record::getGmtModify);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default int updateByPrimaryKey(EnquiryOrderGoods record) {
        return UpdateDSL.updateWithMapper(this::update, enquiryOrderGoods)
                .set(enquiryOrderId).equalTo(record::getEnquiryOrderId)
                .set(goodsName).equalTo(record::getGoodsName)
                .set(goodsSn).equalTo(record::getGoodsSn)
                .set(link).equalTo(record::getLink)
                .set(relationType).equalTo(record::getRelationType)
                .set(remark).equalTo(record::getRemark)
                .set(gmtCreated).equalTo(record::getGmtCreated)
                .set(gmtModify).equalTo(record::getGmtModify)
                .where(recId, isEqualTo(record::getRecId))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default int updateByPrimaryKeySelective(EnquiryOrderGoods record) {
        return UpdateDSL.updateWithMapper(this::update, enquiryOrderGoods)
                .set(enquiryOrderId).equalToWhenPresent(record::getEnquiryOrderId)
                .set(goodsName).equalToWhenPresent(record::getGoodsName)
                .set(goodsSn).equalToWhenPresent(record::getGoodsSn)
                .set(link).equalToWhenPresent(record::getLink)
                .set(relationType).equalToWhenPresent(record::getRelationType)
                .set(remark).equalToWhenPresent(record::getRemark)
                .set(gmtCreated).equalToWhenPresent(record::getGmtCreated)
                .set(gmtModify).equalToWhenPresent(record::getGmtModify)
                .where(recId, isEqualTo(record::getRecId))
                .build()
                .execute();
    }
}