package com.ideal.service.impl;

import com.ideal.entity.AuthTenant;
import com.ideal.mapper.AuthTenantMapper;
import com.ideal.service.IAuthTenantService;
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
