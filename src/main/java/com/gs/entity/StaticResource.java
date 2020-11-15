package com.gs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 静态资源表
 * </p>
 *
 * @author gongsong
 * @since 2020-11-10
 */
@TableName("t_static_resource")
public class StaticResource extends Model<StaticResource> {

    private static final long serialVersionUID=1L;

    /**
     * 静态资源ID
     */
    @TableId(value = "static_resource_id", type = IdType.AUTO)
    private String staticResourceId;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 静态资源名称
     */
    private String staticResourceName;

    /**
     * 静态资源URL
     */
    private String staticResourceUrl;

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


    public String getStaticResourceId() {
        return staticResourceId;
    }

    public void setStaticResourceId(String staticResourceId) {
        this.staticResourceId = staticResourceId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getStaticResourceName() {
        return staticResourceName;
    }

    public void setStaticResourceName(String staticResourceName) {
        this.staticResourceName = staticResourceName;
    }

    public String getStaticResourceUrl() {
        return staticResourceUrl;
    }

    public void setStaticResourceUrl(String staticResourceUrl) {
        this.staticResourceUrl = staticResourceUrl;
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
        return this.staticResourceId;
    }

    @Override
    public String toString() {
        return "StaticResource{" +
        "staticResourceId=" + staticResourceId +
        ", tenantId=" + tenantId +
        ", staticResourceName=" + staticResourceName +
        ", staticResourceUrl=" + staticResourceUrl +
        ", createTime=" + createTime +
        ", createStaff=" + createStaff +
        ", updateTime=" + updateTime +
        ", updateStaff=" + updateStaff +
        ", statusCd=" + statusCd +
        "}";
    }
}
