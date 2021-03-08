package com.reuben.springlearn.start.Listeners;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Reuben
 * 应用启动前事件监听器
 * 发生于listeners.starting(bootstrapContext, this.mainApplicationClass);之后
 */
public class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {


    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        System.out.println("一、Application应用服务即将启动");
    }
}
