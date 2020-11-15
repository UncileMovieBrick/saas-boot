package com.gs.service.impl;

import com.gs.entity.AuthMenu;
import com.gs.mapper.AuthMenuMapper;
import com.gs.service.IAuthMenuService;
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
