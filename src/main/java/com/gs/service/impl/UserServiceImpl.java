package com.gs.service.impl;

import com.gs.entity.User;
import com.gs.entity.dto.UserDTO;
import com.gs.mapper.UserMapper;
import com.gs.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gs.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author gongsong
 * @since 2020-11-10
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService, UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO queryUserRoleAndAuthByUserName(String userName, String tenantId) {
        log.info("通过用户名称：{}，租户ID：{}，查询该用户所拥有的角色和权限",userName,tenantId);
        return userMapper.queryUserRoleAndAuthByUserName(userName,tenantId);
    }
}
