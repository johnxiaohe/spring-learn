package com.reuben.springlearn.Listeners;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Reuben
 * 应用准备完毕事件(此时上下文已经初始化完毕,加载了部分启动过程中的特殊单例bean.可以往应用上下文中放置数据)
 */
public class ApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
        System.out.println("Application应用服务上下文准备完毕");
    }
}
