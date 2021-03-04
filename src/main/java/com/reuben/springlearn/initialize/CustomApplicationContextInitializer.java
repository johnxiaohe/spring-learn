package com.reuben.springlearn.initialize;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Reuben
 * 初始化应用上下文构造器,此时还未注入Bean
 */
public class CustomApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("自定义初始化应用上下文操作,在应用上下文初始化完毕事件发布前执行");
    }
}
