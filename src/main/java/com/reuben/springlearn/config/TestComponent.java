package com.reuben.springlearn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestComponent {

    @Autowired
    private TestBean testBean;

    public TestComponent() {
        System.out.println("扫描配置类TestComponent被实例化了======================");
    }

}
