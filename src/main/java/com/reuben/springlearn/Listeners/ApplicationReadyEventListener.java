package com.reuben.springlearn.Listeners;

import com.reuben.springlearn.component.TestBean;
import com.reuben.springlearn.constant.ApplicationInfoUtils;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Reuben
 * 应用准备启动完毕事件
 * 发生于listeners.running(context);之后
 */
@Configurable
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("六、Application应用服务正在运行中");
        //应用上下文关闭时会销毁所有的Bean
//        ApplicationInfoUtils.configurableApplicationContext.close();
    }

}
