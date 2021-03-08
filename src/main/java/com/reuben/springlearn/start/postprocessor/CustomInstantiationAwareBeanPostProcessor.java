package com.reuben.springlearn.start.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyDescriptor;

/**
 * @author Reuben
 * 自定义Bean初始化后处理器.可在Bean初始化前后进行拓展
 * 可以针对性的对Bean进行收集监控/统一的属性设置等
 */
@Configuration
public class CustomInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    /**
     * Bean实例化之前执行
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("[InstantiationAwareBeanPostProcessor]实例化Bean-"+beanName+"之前执行拓展方法postProcessBeforeInstantiation");
        return null;
    }

    /**
     * Bean实例化后执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("[InstantiationAwareBeanPostProcessor]实例化Bean-"+beanName+"之后执行拓展方法postProcessAfterInstantiation");
        return true;
    }

    /**
     * Bean属性设置后执行
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return null;
    }

    /**
     * Bean属性值注入后执行 @Autowired、@Resource注解实现方式
     * @param pvs
     * @param pds
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {

        System.out.println("[InstantiationAwareBeanPostProcessor]实例"+beanName+"设置属性完毕");
        return pvs;
    }

    /**
     * Bean初始化之前执行(注入Spring上下文之前)
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[BeanPostProcessor]初始化Bean-"+beanName+"之前执行拓展方法postProcessBeforeInitialization");
        return null;
    }

    /**
     * Bean初始化之后执行(注入Spring上下文之后)
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[BeanPostProcessor]初始化Bean-"+beanName+"之后执行拓展方法postProcessAfterInitialization");
        return null;
    }
}
