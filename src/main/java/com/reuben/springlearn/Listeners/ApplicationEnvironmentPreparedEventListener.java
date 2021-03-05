package com.reuben.springlearn.Listeners;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Reuben
 * 应用环境配置加载完毕事件监听器
 * 发生于listeners.environmentPrepared(bootstrapContext, environment);之后
 */
public class ApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        System.out.println("二、Application应用服务环境配置加载完毕");
    }
}
