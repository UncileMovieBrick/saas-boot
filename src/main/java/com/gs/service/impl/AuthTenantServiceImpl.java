package com.gs.service.impl;

import com.gs.entity.AuthTenant;
import com.gs.mapper.AuthTenantMapper;
import com.gs.service.IAuthTenantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限租户关系表 服务实现类
 * </p>
 *
 * @author gongsong
 * @since 2020-11-10
 */
@Service
public class AuthTenantServiceImpl extends ServiceImpl<AuthTenantMapper, AuthTenant> implements IAuthTenantService {

}
