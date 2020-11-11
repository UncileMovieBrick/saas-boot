package com.ideal.controller;


import com.ideal.entity.bo.TenantBO;
import com.ideal.service.TenantService;
import com.ideal.utils.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;


/**
 * <p>
 * 租户表 前端控制器
 * </p>
 *
 * @author gongsong
 * @since 2020-11-10
 */
@Controller
@RequestMapping("/tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @GetMapping("/save")
    public Wrapper saveInfo(@RequestBody TenantBO tenantBO) {

        return tenantService.saveTenant(tenantBO);
    }

}

