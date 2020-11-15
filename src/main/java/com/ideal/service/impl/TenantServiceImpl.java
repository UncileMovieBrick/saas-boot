package com.ideal.service.impl;

import com.ideal.datasource.DynamicDataSource;
import com.ideal.entity.Tenant;
import com.ideal.entity.bo.TenantBO;
import com.ideal.entity.enums.StatusCdEnum;
import com.ideal.mapper.TenantMapper;
import com.ideal.service.ITenantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ideal.service.TenantService;
import com.ideal.utils.SpringContextUtils;
import com.ideal.utils.UUIDUtils;
import com.ideal.utils.Wrapper;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 租户表 服务实现类
 * </p>
 *
 * @author gongsong
 * @since 2020-11-10
 */
@Slf4j
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements ITenantService, TenantService {

    @Override
    public Wrapper saveTenant(TenantBO tenantBO) {
        Tenant tenant = new Tenant();

        BeanUtils.copyProperties(tenantBO, tenant);
        tenant.setTenantId(UUIDUtils.getUUID());
        tenant.setStatusCd(StatusCdEnum.STATUS_CD_0.getType());

        boolean b = save(tenant);
        if (b) {
            initDataSource();
        }
        return Wrapper.ok();
    }

    /**
     * 新增一个租户的同时也需要将数据源更新
     */
    public void initDataSource() {
        log.info("======初始化动态数据源=====");
        DynamicDataSource dynamicDataSource = (DynamicDataSource) SpringContextUtils.getBean("dynamicDataSource");
        HikariDataSource master = (HikariDataSource) SpringContextUtils.getBean("master");
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("master", master);

        List<Tenant> tenantList = list();
        for (Tenant t : tenantList) {
            log.info(t.getTenantId() + "========" + t.getTenantName());
            HikariDataSource dataSource = new HikariDataSource();
            dataSource.setDriverClassName(t.getDbDriver());
            dataSource.setJdbcUrl(t.getDbUrl());
            dataSource.setUsername(t.getDbUsername());
            dataSource.setPassword(t.getDbPassword());
            dataSource.setDataSourceProperties(master.getDataSourceProperties());
            dataSourceMap.put(t.getTenantId(), dataSource);
        }
        // 设置数据源
        dynamicDataSource.setDataSources(dataSourceMap);
        /**
         * 必须执行此操作，才会重新初始化AbstractRoutingDataSource 中的 resolvedDataSources，也只有这样，动态切换才会起效
         */
        dynamicDataSource.afterPropertiesSet();
    }
}

