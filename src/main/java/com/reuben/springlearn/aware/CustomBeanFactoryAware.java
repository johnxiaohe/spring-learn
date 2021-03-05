package com.reuben.springlearn.aware;

import com.reuben.springlearn.constant.ApplicationInfoUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * @author Reuben
 * 该类用于获取BeanFactory
 */
//@Component
public class CustomBeanFactoryAware implements BeanFactoryAware {
    /**
     * 该方法调用发生于Bean实例化之后,Bean属性注入之前.可设置全局BeanFactory或对Bean对象进行定制化处理
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        ApplicationInfoUtils.beanfactory = beanFactory;
        System.out.println("设置全局BeanFactory完毕");
    }
}
