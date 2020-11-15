package com.gs.datasource;

import com.gs.service.TenantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
