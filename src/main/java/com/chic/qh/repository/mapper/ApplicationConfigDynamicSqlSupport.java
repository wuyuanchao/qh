package com.chic.qh.repository.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class ApplicationConfigDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    public static final ApplicationConfig applicationConfig = new ApplicationConfig();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_application_config.rec_id")
    public static final SqlColumn<Integer> recId = applicationConfig.recId;

    /**
     * Database Column Remarks:
     *   配置项的标识
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_application_config.config_key")
    public static final SqlColumn<String> configKey = applicationConfig.configKey;

    /**
     * Database Column Remarks:
     *   配置内容：支持基本类型和复杂类型（使用json存储）
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_application_config.config_content")
    public static final SqlColumn<String> configContent = applicationConfig.configContent;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_application_config.updated_at")
    public static final SqlColumn<Integer> updatedAt = applicationConfig.updatedAt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_application_config")
    public static final class ApplicationConfig extends AliasableSqlTable<ApplicationConfig> {
        public final SqlColumn<Integer> recId = column("rec_id", JDBCType.INTEGER);

        public final SqlColumn<String> configKey = column("config_key", JDBCType.VARCHAR);

        public final SqlColumn<String> configContent = column("config_content", JDBCType.VARCHAR);

        public final SqlColumn<Integer> updatedAt = column("updated_at", JDBCType.INTEGER);

        public ApplicationConfig() {
            super("qh_application_config", ApplicationConfig::new);
        }
    }
}