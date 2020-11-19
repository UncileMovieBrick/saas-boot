package com.gs.entity.dto;

/**
 * @author gongsong
 * @description: 权限DTO
 * @date 2020/11/19 15:23
 */
public class AuthDTO {

    /**
     * 权限ID
     */
    private String authId;

    /**
     * 权限Code
     */
    private String authCode;

    /**
     * 权限名称
     */
    private String authName;

    /**
     * 权限类型（0：静态资源，1：菜单，2：按钮/接口绑定权限）
     */
    private Integer authType;

    /**
     * 菜单ID
     */
    private String menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单路径
     */
    private String menuUrl;

    /**
     * 菜单级别
     */
    private Integer menuLevel;

    /**
     * 菜单路由
     */
    private String menuRouter;

    /**
     * 父菜单ID
     */
    private String parentMenuId;

    /**
     * 页面元素ID
     */
    private String pageElementId;

    /**
     * 页面元素名称
     */
    private String pageElementName;

    /**
     * 静态资源ID
     */
    private String staticResourceId;

    /**
     * 静态资源名称
     */
    private String staticResourceName;

    /**
     * 静态资源URL
     */
    private String staticResourceUrl;

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuRouter() {
        return menuRouter;
    }

    public void setMenuRouter(String menuRouter) {
        this.menuRouter = menuRouter;
    }

    public String getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public String getPageElementId() {
        return pageElementId;
    }

    public void setPageElementId(String pageElementId) {
        this.pageElementId = pageElementId;
    }

    public String getPageElementName() {
        return pageElementName;
    }

    public void setPageElementName(String pageElementName) {
        this.pageElementName = pageElementName;
    }

    public String getStaticResourceId() {
        return staticResourceId;
    }

    public void setStaticResourceId(String staticResourceId) {
        this.staticResourceId = staticResourceId;
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
}
