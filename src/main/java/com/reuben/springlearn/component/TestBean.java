package com.reuben.springlearn.component;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class TestBean implements InitializingBean , DisposableBean {
    public TestBean() {
        System.out.println("扫描配置类TestBean被实例化了======================");
    }

    public String className(){
        return this.getClass().getSimpleName();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("TestBean属性注入完毕,计算TestBean总金额为2W===============");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("TestBean被销毁");
    }
}
