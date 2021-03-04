package com.reuben.springlearn.Listeners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author Reuben
 * 启动过程事件监听器
 */
public class RunProcessEventListener implements SpringApplicationRunListener {

    private final SpringApplication application;

    private final String[] args;

    public RunProcessEventListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }

    @Override
    public void starting() {
        System.out.println("Application应用即将启动");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("Application应用环境配置加载完毕");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("Application应用上下文初始化完毕");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("Application应用上下文加载完毕");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("Application应用启动完毕");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("Application应用运行中");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("Application应用启动失败");
    }
}
