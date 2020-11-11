package com.ideal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 权限租户关系表
 * </p>
 *
 * @author gongsong
 * @since 2020-11-10
 */
@TableName("r_auth_tenant")
public class AuthTenant extends Model<AuthTenant> {

    private static final long serialVersionUID=1L;

    /**
     * 关系ID
     */
    @TableId(value = "relation_id", type = IdType.AUTO)
    private String relationId;

    /**
     * 权限ID
     */
    private String authId;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 数据状态（0：有效，1：无效）
     */
    private Integer statusCd;


    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(Integer statusCd) {
        this.statusCd = statusCd;
    }

    @Override
    protected Serializable pkVal() {
        return this.relationId;
    }

    @Override
    public String toString() {
        return "AuthTenant{" +
        "relationId=" + relationId +
        ", authId=" + authId +
        ", tenantId=" + tenantId +
        ", statusCd=" + statusCd +
        "}";
    }
}
