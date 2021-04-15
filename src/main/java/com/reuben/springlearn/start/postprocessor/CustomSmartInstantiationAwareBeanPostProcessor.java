package com.reuben.springlearn.start.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Constructor;

/**
 * @author Reuben
 * 该接口实现比InstantiationAwareBeanPostProcessor多了Smart.
 * 拓展了InstantiationAwareBeanPostProcessor.
 * 增加了predictBeanType、determineCandidateConstructors、getEarlyBeanReference方法
 */
@Configuration
public class CustomSmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {
    /**
     * 该方法发生在实例化Bean实例化之前,并且在InstantiationAwareBeanPostProcessor.postProcessorBeforInstantiation()方法之前
     * 该方法主要用来确认Bean类型,拓展用处不高
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    /**
     * 该方法用于确认Bean实例化选用的构造方法,可自定义选择对应的Bean构造器.
     * 发生于postProcessorBeforInstantiation之后.postProcessorAfterInstantiation之前
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    /**
     * 获取早期Bean引用.用于当对Bean有循环依赖时对Bean的自定义操作提前执行
     * 发生于postProcessAfterInstantiation实例化方法之后后
     * 防止循环依赖,对Bean做一些AOP/其他自定义操作
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
