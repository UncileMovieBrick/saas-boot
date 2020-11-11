package com.ideal.service.impl;

import com.ideal.entity.Auth;
import com.ideal.mapper.AuthMapper;
import com.ideal.service.IAuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author gongsong
 * @since 2020-11-10
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthMapper, Auth> implements IAuthService {

}
