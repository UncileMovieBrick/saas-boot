package com.ideal.service.impl;

import com.ideal.entity.Menu;
import com.ideal.mapper.MenuMapper;
import com.ideal.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author gongsong
 * @since 2020-11-10
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
