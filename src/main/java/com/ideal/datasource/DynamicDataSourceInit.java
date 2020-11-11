package com.ideal.datasource;

import com.alibaba.fastjson.JSONObject;
import com.ideal.entity.Tenant;
import com.ideal.service.ITenantService;
import com.ideal.service.TenantService;
import com.ideal.utils.SpringContextUtils;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gongsong
 * @description: 初始化动态数据源
 * @date 2020/11/10 10:42
 */
@Slf4j
@Configuration
public class DynamicDataSourceInit {

    @Autowired
    private TenantService tenantService;

    @Bean
    public void initDataSource() {
        tenantService.initDataSource();
    }

}
