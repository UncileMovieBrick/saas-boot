package com.ideal.service.impl;

import com.ideal.entity.AuthMenu;
import com.ideal.mapper.AuthMenuMapper;
import com.ideal.service.IAuthMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限菜单关系表 服务实现类
 * </p>
 *
 * @author gongsong
 * @since 2020-11-10
 */
@Service
public class AuthMenuServiceImpl extends ServiceImpl<AuthMenuMapper, AuthMenu> implements IAuthMenuService {

}
