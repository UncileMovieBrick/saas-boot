package com.gs.service;

import com.gs.entity.dto.UserDTO;

/**
 * 自定义用户服务
 * @author gongsong
 * @since 2020-11-19
 */
public interface UserService {

    /**
     * 通过用户名查询该用户所拥有的权限
     * @param userName 用户名
     * @param tenantId 租户ID
     * @return
     */
    UserDTO queryUserRoleAndAuthByUserName(String userName,String tenantId);

}
