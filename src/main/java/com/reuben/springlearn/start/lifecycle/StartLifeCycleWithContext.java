package com.reuben.springlearn.start.lifecycle;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * 声明为一个跟随Spring上下文生命周期的Bean.可以用来做启动后的监听/轮询操作
 */
@Component
public class StartLifeCycleWithContext implements SmartLifecycle {
    @Override
    public void start() {
        System.out.println("AbstractBeanFactory.refresh第十二步执行调用.");
    }

    @Override
    public void stop() {
        System.out.println("SpringApplicationContext正在结束");
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
