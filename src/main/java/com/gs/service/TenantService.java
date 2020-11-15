package com.gs.service;

import com.gs.entity.bo.TenantBO;
import com.gs.utils.Wrapper;

/**
 * @Description: 自定义租户 Service
 * @Author gongsong
 * @Date 2020/11/10 17:30
 */
public interface TenantService {

    /**
     * 新增租户信息
     * @return
     */
    Wrapper saveTenant(TenantBO tenantBO);

    /**
     * 初始化数据源
     */
    void initDataSource();
}
