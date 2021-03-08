package com.reuben.springlearn.start.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Reuben
 * 执行时是从context中获取,加载于刷新上下文时期,可以交给Spring容器管理
 */
@Component
@Order(10)
public class CustomApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("自定义applicationRunner自定义方法执行");
    }
}
