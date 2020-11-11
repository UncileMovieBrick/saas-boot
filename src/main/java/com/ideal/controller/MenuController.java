package com.ideal.controller;


import com.ideal.entity.Menu;
import com.ideal.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author gongsong
 * @since 2020-11-10
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @GetMapping("/menuList")
    public List<Menu> menuList() {
        return menuService.list();
    }


}

