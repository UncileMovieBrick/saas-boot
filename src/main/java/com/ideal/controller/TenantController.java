package com.ideal.controller;


import com.alibaba.fastjson.JSON;
import com.ideal.entity.bo.TenantBO;
import com.ideal.service.TenantService;
import com.ideal.utils.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 租户表 前端控制器
 * </p>
 *
 * @author gongsong
 * @since 2020-11-10
 */
@Slf4j
@RestController
@RequestMapping("/tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @PostMapping("/save")
    public Wrapper save(@RequestBody TenantBO tenantBO) {
        log.info("新增租户信息：{}", JSON.toJSONString(tenantBO));
        return tenantService.saveTenant(tenantBO);
    }

}

