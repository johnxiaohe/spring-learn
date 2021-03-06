package com.reuben.springlearn.start.Listeners;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Reuben
 * 应用启动失败,异常中断会触发该事件
 * 发生于listeners.failed(context, exception);之后
 */
public class ApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {
    @Override
    public void onApplicationEvent(ApplicationFailedEvent applicationFailedEvent) {
        System.out.println("Application应用启动失败");
    }
}
