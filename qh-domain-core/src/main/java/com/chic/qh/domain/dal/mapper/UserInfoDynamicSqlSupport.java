package com.chic.qh.domain.dal.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class UserInfoDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    public static final UserInfo userInfo = new UserInfo();

    /**
     * Database Column Remarks:
     *   用户ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_user_info.user_id")
    public static final SqlColumn<Integer> userId = userInfo.userId;

    /**
     * Database Column Remarks:
     *   用户名
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_user_info.username")
    public static final SqlColumn<String> username = userInfo.username;

    /**
     * Database Column Remarks:
     *   密码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_user_info.password")
    public static final SqlColumn<String> password = userInfo.password;

    /**
     * Database Column Remarks:
     *   头像
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_user_info.avatar")
    public static final SqlColumn<String> avatar = userInfo.avatar;

    /**
     * Database Column Remarks:
     *   角色名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_user_info.role_name")
    public static final SqlColumn<String> roleName = userInfo.roleName;

    /**
     * Database Column Remarks:
     *   状态(1-启用;2-禁用;)
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_user_info.status")
    public static final SqlColumn<Byte> status = userInfo.status;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_user_info.gmt_created")
    public static final SqlColumn<Integer> gmtCreated = userInfo.gmtCreated;

    /**
     * Database Column Remarks:
     *   修改时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: qh_user_info.gmt_modify")
    public static final SqlColumn<Integer> gmtModify = userInfo.gmtModify;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: qh_user_info")
    public static final class UserInfo extends AliasableSqlTable<UserInfo> {
        public final SqlColumn<Integer> userId = column("user_id", JDBCType.INTEGER);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<String> avatar = column("avatar", JDBCType.VARCHAR);

        public final SqlColumn<String> roleName = column("role_name", JDBCType.VARCHAR);

        public final SqlColumn<Byte> status = column("status", JDBCType.TINYINT);

        public final SqlColumn<Integer> gmtCreated = column("gmt_created", JDBCType.INTEGER);

        public final SqlColumn<Integer> gmtModify = column("gmt_modify", JDBCType.INTEGER);

        public UserInfo() {
            super("qh_user_info", UserInfo::new);
        }
    }
}