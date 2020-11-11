package com.ideal.service.impl;

import com.ideal.entity.Role;
import com.ideal.mapper.RoleMapper;
import com.ideal.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author gongsong
 * @since 2020-11-10
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
