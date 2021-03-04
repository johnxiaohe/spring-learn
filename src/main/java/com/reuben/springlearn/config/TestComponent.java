package com.reuben.springlearn.config;

import org.springframework.stereotype.Component;

@Component
public class TestComponent {

    public TestComponent() {
        System.out.println("扫描配置类TestComponent被实例化了======================");
    }

}
