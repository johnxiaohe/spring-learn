package com.reuben.springlearn.Listeners;

import com.reuben.springlearn.config.TestBean;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Reuben
 * 应用准备启动完毕事件
 */
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

    private TestBean testBean;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("应用上下文刷新完毕,Application应用服务已准备好,运行中");
    }

    @Autowired
    public void setTestBean(TestBean testBean) {
        this.testBean = testBean;
    }
}
