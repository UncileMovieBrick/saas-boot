package com.gs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 租户表
 * </p>
 *
 * @author gongsong
 * @since 2020-11-10
 */
@TableName("t_tenant")
public class Tenant extends Model<Tenant> {

    private static final long serialVersionUID=1L;

    /**
     * 租户ID
     */
    @TableId(value = "tenant_id")
    private String tenantId;

    /**
     * 租户名称
     */
    private String tenantName;

    /**
     * 租户登录名
     */
    private String systemAccount;

    /**
     * 租户密码
     */
    private String systemPassword;

    /**
     * 租户Logo
     */
    private String logUrl;

    /**
     * 应用名
     */
    private String appName;

    /**
     * 数据库URL
     */
    private String dbUrl;

    /**
     * 数据库驱动
     */
    private String dbDriver;

    /**
     * 数据库连接用户名
     */
    private String dbUsername;

    /**
     * 数据库连接密码
     */
    private String dbPassword;

    /**
     * 电话
     */
    private String tenantMobile;

    /**
     * 邮箱
     */
    private String tenantEmail;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createStaff;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 修改人
     */
    private String updateStaff;

    /**
     * 数据状态（0：有效，1：无效）
     */
    private Integer statusCd;


    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getSystemAccount() {
        return systemAccount;
    }

    public void setSystemAccount(String systemAccount) {
        this.systemAccount = systemAccount;
    }

    public String getSystemPassword() {
        return systemPassword;
    }

    public void setSystemPassword(String systemPassword) {
        this.systemPassword = systemPassword;
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getTenantMobile() {
        return tenantMobile;
    }

    public void setTenantMobile(String tenantMobile) {
        this.tenantMobile = tenantMobile;
    }

    public String getTenantEmail() {
        return tenantEmail;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateStaff() {
        return createStaff;
    }

    public void setCreateStaff(String createStaff) {
        this.createStaff = createStaff;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateStaff() {
        return updateStaff;
    }

    public void setUpdateStaff(String updateStaff) {
        this.updateStaff = updateStaff;
    }

    public Integer getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(Integer statusCd) {
        this.statusCd = statusCd;
    }

    @Override
    protected Serializable pkVal() {
        return this.tenantId;
    }

    @Override
    public String toString() {
        return "Tenant{" +
        "tenantId=" + tenantId +
        ", tenantName=" + tenantName +
        ", systemAccount=" + systemAccount +
        ", systemPassword=" + systemPassword +
        ", logUrl=" + logUrl +
        ", appName=" + appName +
        ", dbUrl=" + dbUrl +
        ", dbDriver=" + dbDriver +
        ", dbUsername=" + dbUsername +
        ", dbPassword=" + dbPassword +
        ", tenantMobile=" + tenantMobile +
        ", tenantEmail=" + tenantEmail +
        ", description=" + description +
        ", createTime=" + createTime +
        ", createStaff=" + createStaff +
        ", updateTime=" + updateTime +
        ", updateStaff=" + updateStaff +
        ", statusCd=" + statusCd +
        "}";
    }
}
