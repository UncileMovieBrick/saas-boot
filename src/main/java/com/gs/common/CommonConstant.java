package com.gs.common;

/**
 * @author gongsong
 * @description 系统常量类，定义系统级别常量
 * @date 2020-11-17 21:52
 */
public class CommonConstant {

    /**
     * Token 的 Key
     */
    public static String X_ACCESS_TOKEN = "X-Access-Token";

    /**
     * Token 缓存到 Redis 的常量
     */
    public static final String PREFIX_USER_TOKEN = "PREFIX_USER_TOKEN_";

    /**
     * 用户权限、角色缓存到 Redis 的常量
     */
    public static final String PREFIX_USER_ROLE_AUTH = "PREFIX_USER_ROLE_AUTH_";

    /**
     * 用户权限、角色信息过期时间，30分钟
     */
    public static final long USER_ROLE_EXPIRE_TIME = 30 * 60 * 1000;

}
