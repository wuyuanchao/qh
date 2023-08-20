package com.chic.qh.repository.mapper;

import static com.chic.qh.repository.mapper.GoodsQuoteDetailDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.chic.qh.repository.model.GoodsQuoteDetail;
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
public interface GoodsQuoteDetailMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    BasicColumn[] selectList = BasicColumn.columnList(recId, quoteId, skuId, qty, country, shippingChannel, shippingTime, amount, productCost, shippingCost, weightType, volWeight, actWeight, createdAt);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.recId")
    int insert(InsertStatementProvider<GoodsQuoteDetail> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.recId")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<GoodsQuoteDetail> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="GoodsQuoteDetailResult", value = {
        @Result(column="rec_id", property="recId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="quote_id", property="quoteId", jdbcType=JdbcType.INTEGER),
        @Result(column="sku_id", property="skuId", jdbcType=JdbcType.INTEGER),
        @Result(column="qty", property="qty", jdbcType=JdbcType.INTEGER),
        @Result(column="country", property="country", jdbcType=JdbcType.CHAR),
        @Result(column="shipping_channel", property="shippingChannel", jdbcType=JdbcType.VARCHAR),
        @Result(column="shipping_time", property="shippingTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_cost", property="productCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="shipping_cost", property="shippingCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="weight_type", property="weightType", jdbcType=JdbcType.VARCHAR),
        @Result(column="vol_weight", property="volWeight", jdbcType=JdbcType.DECIMAL),
        @Result(column="act_weight", property="actWeight", jdbcType=JdbcType.DECIMAL),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.INTEGER)
    })
    List<GoodsQuoteDetail> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("GoodsQuoteDetailResult")
    Optional<GoodsQuoteDetail> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, goodsQuoteDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, goodsQuoteDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    default int deleteByPrimaryKey(Integer recId_) {
        return delete(c -> 
            c.where(recId, isEqualTo(recId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    default int insert(GoodsQuoteDetail row) {
        return MyBatis3Utils.insert(this::insert, row, goodsQuoteDetail, c ->
            c.map(quoteId).toProperty("quoteId")
            .map(skuId).toProperty("skuId")
            .map(qty).toProperty("qty")
            .map(country).toProperty("country")
            .map(shippingChannel).toProperty("shippingChannel")
            .map(shippingTime).toProperty("shippingTime")
            .map(amount).toProperty("amount")
            .map(productCost).toProperty("productCost")
            .map(shippingCost).toProperty("shippingCost")
            .map(weightType).toProperty("weightType")
            .map(volWeight).toProperty("volWeight")
            .map(actWeight).toProperty("actWeight")
            .map(createdAt).toProperty("createdAt")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    default int insertMultiple(Collection<GoodsQuoteDetail> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, goodsQuoteDetail, c ->
            c.map(quoteId).toProperty("quoteId")
            .map(skuId).toProperty("skuId")
            .map(qty).toProperty("qty")
            .map(country).toProperty("country")
            .map(shippingChannel).toProperty("shippingChannel")
            .map(shippingTime).toProperty("shippingTime")
            .map(amount).toProperty("amount")
            .map(productCost).toProperty("productCost")
            .map(shippingCost).toProperty("shippingCost")
            .map(weightType).toProperty("weightType")
            .map(volWeight).toProperty("volWeight")
            .map(actWeight).toProperty("actWeight")
            .map(createdAt).toProperty("createdAt")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    default int insertSelective(GoodsQuoteDetail row) {
        return MyBatis3Utils.insert(this::insert, row, goodsQuoteDetail, c ->
            c.map(quoteId).toPropertyWhenPresent("quoteId", row::getQuoteId)
            .map(skuId).toPropertyWhenPresent("skuId", row::getSkuId)
            .map(qty).toPropertyWhenPresent("qty", row::getQty)
            .map(country).toPropertyWhenPresent("country", row::getCountry)
            .map(shippingChannel).toPropertyWhenPresent("shippingChannel", row::getShippingChannel)
            .map(shippingTime).toPropertyWhenPresent("shippingTime", row::getShippingTime)
            .map(amount).toPropertyWhenPresent("amount", row::getAmount)
            .map(productCost).toPropertyWhenPresent("productCost", row::getProductCost)
            .map(shippingCost).toPropertyWhenPresent("shippingCost", row::getShippingCost)
            .map(weightType).toPropertyWhenPresent("weightType", row::getWeightType)
            .map(volWeight).toPropertyWhenPresent("volWeight", row::getVolWeight)
            .map(actWeight).toPropertyWhenPresent("actWeight", row::getActWeight)
            .map(createdAt).toPropertyWhenPresent("createdAt", row::getCreatedAt)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    default Optional<GoodsQuoteDetail> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, goodsQuoteDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    default List<GoodsQuoteDetail> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, goodsQuoteDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    default List<GoodsQuoteDetail> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, goodsQuoteDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    default Optional<GoodsQuoteDetail> selectByPrimaryKey(Integer recId_) {
        return selectOne(c ->
            c.where(recId, isEqualTo(recId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, goodsQuoteDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    static UpdateDSL<UpdateModel> updateAllColumns(GoodsQuoteDetail row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(quoteId).equalTo(row::getQuoteId)
                .set(skuId).equalTo(row::getSkuId)
                .set(qty).equalTo(row::getQty)
                .set(country).equalTo(row::getCountry)
                .set(shippingChannel).equalTo(row::getShippingChannel)
                .set(shippingTime).equalTo(row::getShippingTime)
                .set(amount).equalTo(row::getAmount)
                .set(productCost).equalTo(row::getProductCost)
                .set(shippingCost).equalTo(row::getShippingCost)
                .set(weightType).equalTo(row::getWeightType)
                .set(volWeight).equalTo(row::getVolWeight)
                .set(actWeight).equalTo(row::getActWeight)
                .set(createdAt).equalTo(row::getCreatedAt);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(GoodsQuoteDetail row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(quoteId).equalToWhenPresent(row::getQuoteId)
                .set(skuId).equalToWhenPresent(row::getSkuId)
                .set(qty).equalToWhenPresent(row::getQty)
                .set(country).equalToWhenPresent(row::getCountry)
                .set(shippingChannel).equalToWhenPresent(row::getShippingChannel)
                .set(shippingTime).equalToWhenPresent(row::getShippingTime)
                .set(amount).equalToWhenPresent(row::getAmount)
                .set(productCost).equalToWhenPresent(row::getProductCost)
                .set(shippingCost).equalToWhenPresent(row::getShippingCost)
                .set(weightType).equalToWhenPresent(row::getWeightType)
                .set(volWeight).equalToWhenPresent(row::getVolWeight)
                .set(actWeight).equalToWhenPresent(row::getActWeight)
                .set(createdAt).equalToWhenPresent(row::getCreatedAt);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    default int updateByPrimaryKey(GoodsQuoteDetail row) {
        return update(c ->
            c.set(quoteId).equalTo(row::getQuoteId)
            .set(skuId).equalTo(row::getSkuId)
            .set(qty).equalTo(row::getQty)
            .set(country).equalTo(row::getCountry)
            .set(shippingChannel).equalTo(row::getShippingChannel)
            .set(shippingTime).equalTo(row::getShippingTime)
            .set(amount).equalTo(row::getAmount)
            .set(productCost).equalTo(row::getProductCost)
            .set(shippingCost).equalTo(row::getShippingCost)
            .set(weightType).equalTo(row::getWeightType)
            .set(volWeight).equalTo(row::getVolWeight)
            .set(actWeight).equalTo(row::getActWeight)
            .set(createdAt).equalTo(row::getCreatedAt)
            .where(recId, isEqualTo(row::getRecId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_quote_detail")
    default int updateByPrimaryKeySelective(GoodsQuoteDetail row) {
        return update(c ->
            c.set(quoteId).equalToWhenPresent(row::getQuoteId)
            .set(skuId).equalToWhenPresent(row::getSkuId)
            .set(qty).equalToWhenPresent(row::getQty)
            .set(country).equalToWhenPresent(row::getCountry)
            .set(shippingChannel).equalToWhenPresent(row::getShippingChannel)
            .set(shippingTime).equalToWhenPresent(row::getShippingTime)
            .set(amount).equalToWhenPresent(row::getAmount)
            .set(productCost).equalToWhenPresent(row::getProductCost)
            .set(shippingCost).equalToWhenPresent(row::getShippingCost)
            .set(weightType).equalToWhenPresent(row::getWeightType)
            .set(volWeight).equalToWhenPresent(row::getVolWeight)
            .set(actWeight).equalToWhenPresent(row::getActWeight)
            .set(createdAt).equalToWhenPresent(row::getCreatedAt)
            .where(recId, isEqualTo(row::getRecId))
        );
    }
}