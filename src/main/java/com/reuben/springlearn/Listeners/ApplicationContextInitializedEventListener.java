package com.reuben.springlearn.Listeners;

import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Reuben
 * 应用上下文初始化完毕事件
 */
public class ApplicationContextInitializedEventListener implements ApplicationListener<ApplicationContextInitializedEvent> {
    @Override
    public void onApplicationEvent(ApplicationContextInitializedEvent applicationContextInitializedEvent) {
        System.out.println("Application应用服务上下文初始化完毕");
    }
}
