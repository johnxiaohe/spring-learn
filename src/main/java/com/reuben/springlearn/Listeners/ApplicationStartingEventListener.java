package com.reuben.springlearn.Listeners;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Reuben
 * 应用启动前事件监听器
 */
public class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {


    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        System.out.println("Application应用服务即将启动");
    }
}
