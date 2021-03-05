package com.reuben.springlearn.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author Reuben
 *
 */
//@Configuration
public class CustomBeanNameAware implements BeanNameAware {
    private String beanName;
    /**
     * Bean初始化前调用(postProcessBeforInitialization之前)
     * 该值为该Bean在容器中的名称.所以可以在初始化前进行Bean名称自定义
     * @param beanName
     */
    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
