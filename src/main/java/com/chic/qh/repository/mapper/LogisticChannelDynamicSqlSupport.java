package com.chic.qh.repository.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class LogisticChannelDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    public static final LogisticChannel logisticChannel = new LogisticChannel();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.rec_id")
    public static final SqlColumn<Integer> recId = logisticChannel.recId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.name")
    public static final SqlColumn<String> name = logisticChannel.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.code")
    public static final SqlColumn<String> code = logisticChannel.code;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.company")
    public static final SqlColumn<String> company = logisticChannel.company;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.cut_off_time")
    public static final SqlColumn<String> cutOffTime = logisticChannel.cutOffTime;

    /**
     * Database Column Remarks:
     *   耗时说明
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_logistic_channel.cost_time")
    public static final SqlColumn<String> costTime = logisticChannel.costTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_logistic_channel")
    public static final class LogisticChannel extends AliasableSqlTable<LogisticChannel> {
        public final SqlColumn<Integer> recId = column("rec_id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> code = column("code", JDBCType.VARCHAR);

        public final SqlColumn<String> company = column("company", JDBCType.VARCHAR);

        public final SqlColumn<String> cutOffTime = column("cut_off_time", JDBCType.VARCHAR);

        public final SqlColumn<String> costTime = column("cost_time", JDBCType.VARCHAR);

        public LogisticChannel() {
            super("qh_logistic_channel", LogisticChannel::new);
        }
    }
}