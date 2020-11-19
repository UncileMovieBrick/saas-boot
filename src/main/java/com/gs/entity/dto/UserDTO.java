package com.gs.entity.dto;

import java.util.List;

/**
 * @author gongsong
 * @description: 用户DTO
 * @date 2020/11/19 15:16
 */
public class UserDTO {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户所拥有角色集合
     */
    private List<RoleDTO> roleList;

    /**
     * 用户所拥有权限集合
     */
    private List<AuthDTO> authList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<RoleDTO> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleDTO> roleList) {
        this.roleList = roleList;
    }

    public List<AuthDTO> getAuthList() {
        return authList;
    }

    public void setAuthList(List<AuthDTO> authList) {
        this.authList = authList;
    }
}
