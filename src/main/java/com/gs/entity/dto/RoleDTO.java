package com.gs.entity.dto;

/**
 * @author gongsong
 * @description: 角色 DTO
 * @date 2020/11/19 15:17
 */
public class RoleDTO {

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 角色Code
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
