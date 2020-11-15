package com.ideal.aspect;

import com.ideal.datasource.DynamicDataSourceContextHolder;
import com.ideal.utils.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author gongsong
 * @Description 动态数据源切面拦截
 * @date 2020/5/19 00:29
 */
@Slf4j
@Aspect
@Component
@Order(1) // 请注意：这里order一定要小于tx:annotation-driven的order，即先执行DynamicDataSourceAspectAdvice切面，再执行事务切面，才能获取到最终的数据源
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DynamicDataSourceAspect {

    @Around("execution(* com.ideal.controller.*.*(..)) || execution(* com.ideal.*.*(..))")
    public Wrapper doAround(ProceedingJoinPoint jp) throws Throwable {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Wrapper result = null;
        try {
            HttpServletRequest request = sra.getRequest();
            HttpSession session = sra.getRequest().getSession(true);
            String tenantId = (String)session.getAttribute("tenantId");
            if (StringUtils.isEmpty(tenantId)) {
                tenantId = request.getParameter("tenantId");
            }
            log.info("当前租户Id:{}", tenantId);
            if (!StringUtils.isEmpty(tenantId)) {
                DynamicDataSourceContextHolder.setDataSourceKey(tenantId);
                long startTime = System.currentTimeMillis();
                result = (Wrapper)jp.proceed();
                long endTime = System.currentTimeMillis();
                long resultTime = endTime - startTime;
                if (resultTime <= 1000) {
                    log.info("服务：{}执行时间正常，执行时间为{}",jp.proceed().toString(),resultTime);
                } else if (resultTime <= 2000) {
                    log.warn("服务：{}执行时间过长警告，执行时间为{}",jp.proceed().toString(),resultTime);
                } else {
                    log.error("服务：{}执行时间严重超时，执行时间为{}",jp.proceed().toString(),resultTime);
                }
            } else {
                result = Wrapper.error("查询失败，当前租户信息未取到，请联系技术专家！");
            }
        } catch (Exception e) {
            log.error("系统异常，请联系技术专家！错误信息：{}",e.getMessage());
            result =  Wrapper.error("系统异常，请联系技术专家！");
        } finally {
            DynamicDataSourceContextHolder.clearDataSourceKey();
        }
        return result;
    }
}
