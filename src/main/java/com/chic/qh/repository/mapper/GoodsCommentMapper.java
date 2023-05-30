package com.chic.qh.repository.mapper;

import static com.chic.qh.repository.mapper.GoodsCommentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.chic.qh.repository.model.GoodsComment;
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
public interface GoodsCommentMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    BasicColumn[] selectList = BasicColumn.columnList(recId, goodsId, user, createdAt, status, updatedAt, content);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.recId")
    int insert(InsertStatementProvider<GoodsComment> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.recId")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<GoodsComment> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="GoodsCommentResult", value = {
        @Result(column="rec_id", property="recId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="goods_id", property="goodsId", jdbcType=JdbcType.INTEGER),
        @Result(column="user", property="user", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<GoodsComment> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("GoodsCommentResult")
    Optional<GoodsComment> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, goodsComment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, goodsComment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    default int deleteByPrimaryKey(Integer recId_) {
        return delete(c -> 
            c.where(recId, isEqualTo(recId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    default int insert(GoodsComment row) {
        return MyBatis3Utils.insert(this::insert, row, goodsComment, c ->
            c.map(goodsId).toProperty("goodsId")
            .map(user).toProperty("user")
            .map(createdAt).toProperty("createdAt")
            .map(status).toProperty("status")
            .map(updatedAt).toProperty("updatedAt")
            .map(content).toProperty("content")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    default int insertMultiple(Collection<GoodsComment> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, goodsComment, c ->
            c.map(goodsId).toProperty("goodsId")
            .map(user).toProperty("user")
            .map(createdAt).toProperty("createdAt")
            .map(status).toProperty("status")
            .map(updatedAt).toProperty("updatedAt")
            .map(content).toProperty("content")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    default int insertSelective(GoodsComment row) {
        return MyBatis3Utils.insert(this::insert, row, goodsComment, c ->
            c.map(goodsId).toPropertyWhenPresent("goodsId", row::getGoodsId)
            .map(user).toPropertyWhenPresent("user", row::getUser)
            .map(createdAt).toPropertyWhenPresent("createdAt", row::getCreatedAt)
            .map(status).toPropertyWhenPresent("status", row::getStatus)
            .map(updatedAt).toPropertyWhenPresent("updatedAt", row::getUpdatedAt)
            .map(content).toPropertyWhenPresent("content", row::getContent)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    default Optional<GoodsComment> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, goodsComment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    default List<GoodsComment> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, goodsComment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    default List<GoodsComment> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, goodsComment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    default Optional<GoodsComment> selectByPrimaryKey(Integer recId_) {
        return selectOne(c ->
            c.where(recId, isEqualTo(recId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, goodsComment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    static UpdateDSL<UpdateModel> updateAllColumns(GoodsComment row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(goodsId).equalTo(row::getGoodsId)
                .set(user).equalTo(row::getUser)
                .set(createdAt).equalTo(row::getCreatedAt)
                .set(status).equalTo(row::getStatus)
                .set(updatedAt).equalTo(row::getUpdatedAt)
                .set(content).equalTo(row::getContent);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(GoodsComment row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(goodsId).equalToWhenPresent(row::getGoodsId)
                .set(user).equalToWhenPresent(row::getUser)
                .set(createdAt).equalToWhenPresent(row::getCreatedAt)
                .set(status).equalToWhenPresent(row::getStatus)
                .set(updatedAt).equalToWhenPresent(row::getUpdatedAt)
                .set(content).equalToWhenPresent(row::getContent);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    default int updateByPrimaryKey(GoodsComment row) {
        return update(c ->
            c.set(goodsId).equalTo(row::getGoodsId)
            .set(user).equalTo(row::getUser)
            .set(createdAt).equalTo(row::getCreatedAt)
            .set(status).equalTo(row::getStatus)
            .set(updatedAt).equalTo(row::getUpdatedAt)
            .set(content).equalTo(row::getContent)
            .where(recId, isEqualTo(row::getRecId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_goods_comment")
    default int updateByPrimaryKeySelective(GoodsComment row) {
        return update(c ->
            c.set(goodsId).equalToWhenPresent(row::getGoodsId)
            .set(user).equalToWhenPresent(row::getUser)
            .set(createdAt).equalToWhenPresent(row::getCreatedAt)
            .set(status).equalToWhenPresent(row::getStatus)
            .set(updatedAt).equalToWhenPresent(row::getUpdatedAt)
            .set(content).equalToWhenPresent(row::getContent)
            .where(recId, isEqualTo(row::getRecId))
        );
    }
}