package com.reuben.springlearn.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Reuben
 * 执行时是从context中获取,加载于刷新上下文时期, 由Spring容器管理
 * 该类执行时上下文已初始化完毕,可执行一些项目启动后的预处理工作
 */
@Component
@Order(10)
public class CustomCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("自定义CommandLineRunner执行");
    }
}
