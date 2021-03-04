package com.reuben.springlearn.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Reuben
 * 执行时是从context中获取,加载于刷新上下文时期,可以交给Spring容器管理
 */
@Component
@Order(10)
public class CustomCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("自定义CommandLineRunner执行");
    }
}
