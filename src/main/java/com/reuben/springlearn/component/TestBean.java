package com.reuben.springlearn.component;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class TestBean implements InitializingBean , DisposableBean, BeanNameAware {
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

    @Override
    public void setBeanName(String s) {
        System.out.println("TestBean的单例名称为"+s+"==========================");
    }
}
