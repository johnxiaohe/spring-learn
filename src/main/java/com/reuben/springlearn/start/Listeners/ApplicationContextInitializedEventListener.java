package com.reuben.springlearn.start.Listeners;

import com.reuben.springlearn.start.constant.ApplicationInfoUtils;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Reuben
 * 应用上下文初始化完毕事件
 * 发生于listeners.contextPrepared(context);之后
 */
public class ApplicationContextInitializedEventListener implements ApplicationListener<ApplicationContextInitializedEvent> {
    @Override
    public void onApplicationEvent(ApplicationContextInitializedEvent applicationContextInitializedEvent) {
        ApplicationInfoUtils.configurableApplicationContext = applicationContextInitializedEvent.getApplicationContext();
        System.out.println("三、Application应用服务上下文初始化完毕,已设置全局上下文Context");
    }
}
