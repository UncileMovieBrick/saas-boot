package com.ideal.service.impl;

import com.ideal.entity.UserRole;
import com.ideal.mapper.UserRoleMapper;
import com.ideal.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author gongsong
 * @since 2020-11-10
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
