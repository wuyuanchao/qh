package com.chic.qh.domain.dal.mapper;

import static com.chic.qh.domain.dal.mapper.EnquiryOrderGoodsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.chic.qh.domain.dal.model.EnquiryOrderGoods;
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
public interface EnquiryOrderGoodsMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    BasicColumn[] selectList = BasicColumn.columnList(recId, enquiryOrderId, goodsName, goodsSn, link, relationType, remark, gmtCreated, gmtModify);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.recId")
    int insert(InsertStatementProvider<EnquiryOrderGoods> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.recId")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<EnquiryOrderGoods> records);

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
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("EnquiryOrderGoodsResult")
    Optional<EnquiryOrderGoods> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, enquiryOrderGoods, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, enquiryOrderGoods, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default int deleteByPrimaryKey(Integer recId_) {
        return delete(c -> 
            c.where(recId, isEqualTo(recId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default int insert(EnquiryOrderGoods row) {
        return MyBatis3Utils.insert(this::insert, row, enquiryOrderGoods, c ->
            c.map(enquiryOrderId).toProperty("enquiryOrderId")
            .map(goodsName).toProperty("goodsName")
            .map(goodsSn).toProperty("goodsSn")
            .map(link).toProperty("link")
            .map(relationType).toProperty("relationType")
            .map(remark).toProperty("remark")
            .map(gmtCreated).toProperty("gmtCreated")
            .map(gmtModify).toProperty("gmtModify")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default int insertMultiple(Collection<EnquiryOrderGoods> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, enquiryOrderGoods, c ->
            c.map(enquiryOrderId).toProperty("enquiryOrderId")
            .map(goodsName).toProperty("goodsName")
            .map(goodsSn).toProperty("goodsSn")
            .map(link).toProperty("link")
            .map(relationType).toProperty("relationType")
            .map(remark).toProperty("remark")
            .map(gmtCreated).toProperty("gmtCreated")
            .map(gmtModify).toProperty("gmtModify")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default int insertSelective(EnquiryOrderGoods row) {
        return MyBatis3Utils.insert(this::insert, row, enquiryOrderGoods, c ->
            c.map(enquiryOrderId).toPropertyWhenPresent("enquiryOrderId", row::getEnquiryOrderId)
            .map(goodsName).toPropertyWhenPresent("goodsName", row::getGoodsName)
            .map(goodsSn).toPropertyWhenPresent("goodsSn", row::getGoodsSn)
            .map(link).toPropertyWhenPresent("link", row::getLink)
            .map(relationType).toPropertyWhenPresent("relationType", row::getRelationType)
            .map(remark).toPropertyWhenPresent("remark", row::getRemark)
            .map(gmtCreated).toPropertyWhenPresent("gmtCreated", row::getGmtCreated)
            .map(gmtModify).toPropertyWhenPresent("gmtModify", row::getGmtModify)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default Optional<EnquiryOrderGoods> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, enquiryOrderGoods, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default List<EnquiryOrderGoods> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, enquiryOrderGoods, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default List<EnquiryOrderGoods> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, enquiryOrderGoods, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default Optional<EnquiryOrderGoods> selectByPrimaryKey(Integer recId_) {
        return selectOne(c ->
            c.where(recId, isEqualTo(recId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, enquiryOrderGoods, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    static UpdateDSL<UpdateModel> updateAllColumns(EnquiryOrderGoods row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(enquiryOrderId).equalTo(row::getEnquiryOrderId)
                .set(goodsName).equalTo(row::getGoodsName)
                .set(goodsSn).equalTo(row::getGoodsSn)
                .set(link).equalTo(row::getLink)
                .set(relationType).equalTo(row::getRelationType)
                .set(remark).equalTo(row::getRemark)
                .set(gmtCreated).equalTo(row::getGmtCreated)
                .set(gmtModify).equalTo(row::getGmtModify);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(EnquiryOrderGoods row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(enquiryOrderId).equalToWhenPresent(row::getEnquiryOrderId)
                .set(goodsName).equalToWhenPresent(row::getGoodsName)
                .set(goodsSn).equalToWhenPresent(row::getGoodsSn)
                .set(link).equalToWhenPresent(row::getLink)
                .set(relationType).equalToWhenPresent(row::getRelationType)
                .set(remark).equalToWhenPresent(row::getRemark)
                .set(gmtCreated).equalToWhenPresent(row::getGmtCreated)
                .set(gmtModify).equalToWhenPresent(row::getGmtModify);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default int updateByPrimaryKey(EnquiryOrderGoods row) {
        return update(c ->
            c.set(enquiryOrderId).equalTo(row::getEnquiryOrderId)
            .set(goodsName).equalTo(row::getGoodsName)
            .set(goodsSn).equalTo(row::getGoodsSn)
            .set(link).equalTo(row::getLink)
            .set(relationType).equalTo(row::getRelationType)
            .set(remark).equalTo(row::getRemark)
            .set(gmtCreated).equalTo(row::getGmtCreated)
            .set(gmtModify).equalTo(row::getGmtModify)
            .where(recId, isEqualTo(row::getRecId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_enquiry_order_goods")
    default int updateByPrimaryKeySelective(EnquiryOrderGoods row) {
        return update(c ->
            c.set(enquiryOrderId).equalToWhenPresent(row::getEnquiryOrderId)
            .set(goodsName).equalToWhenPresent(row::getGoodsName)
            .set(goodsSn).equalToWhenPresent(row::getGoodsSn)
            .set(link).equalToWhenPresent(row::getLink)
            .set(relationType).equalToWhenPresent(row::getRelationType)
            .set(remark).equalToWhenPresent(row::getRemark)
            .set(gmtCreated).equalToWhenPresent(row::getGmtCreated)
            .set(gmtModify).equalToWhenPresent(row::getGmtModify)
            .where(recId, isEqualTo(row::getRecId))
        );
    }
}