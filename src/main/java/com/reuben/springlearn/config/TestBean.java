package com.reuben.springlearn.config;

public class TestBean {
    public TestBean() {
        System.out.println("扫描配置类TestBean被实例化了======================");
    }

    public String className(){
        return this.getClass().getSimpleName();
    }
}
