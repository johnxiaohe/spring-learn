package com.reuben.springlearn.Listeners;

import com.reuben.springlearn.config.TestBean;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Reuben
 * 应用启动完毕事件,在refreshContext步已经将应用的Bean加载入容器中可以使用
 */
public class ApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("Application应用服务启动完毕,应用上下文已经准备好");
        System.out.println("验证已经被注入TestBean: " + applicationStartedEvent.getApplicationContext().getBean(TestBean.class).className() );
    }

}
