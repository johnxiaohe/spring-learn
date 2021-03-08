package com.reuben.springlearn.start.Listeners;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Reuben
 * 应用启动完毕事件,在refreshContext步已经将应用的Bean加载入容器中可以使用
 * 发生于listeners.started(context);之后
 */
public class ApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("五、Application应用服务启动完毕,应用上下文已经准备好");
    }

}
