package com.reuben.springlearn.Listeners;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class StartPreListeners implements ApplicationListener<ApplicationStartingEvent> {


    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        System.out.println("服务启动中" + applicationStartingEvent.getSource().toString());
    }
}
