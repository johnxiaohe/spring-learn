package com.reuben.springlearn.start.aware;

import com.reuben.springlearn.start.constant.ApplicationInfoUtils;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Bean声明周期可执行Aware. 按照顺序往下依次执行
 */
@Component
@Configuration
@Data
public class CustomBeanAware implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    private String beanName;

    public CustomBeanAware() {
    }

    /**
     * BeanNameAware
     * 该值为该Bean在容器中的名称.所以可以在初始化前进行Bean名称自定义
     * @param s
     */
    @Override
    public void setBeanName(String s) {
        this.beanName = beanName;
    }

    /**
     * BeanFactoryAware
     * 该方法调用发生于Bean实例化之后,Bean属性注入之前.可设置全局BeanFactory或对Bean对象进行定制化处理
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        ApplicationInfoUtils.beanfactory = beanFactory;
        System.out.println("设置全局BeanFactory完毕");
    }

    /**
     * ApplicationContextAware
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationInfoUtils.configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
        System.out.println("获取应用上下文");
    }
   // -----------------以上均在postProcessBeforeInitialization之前,postProcessPropertyValues之后执行
    @PostConstruct
    public void annotationInitMethod(){
        System.out.println("CustomBeanAwareBean注解初始化方法");
    }
    /**
     * InitializingBean， postProcessBeforeInitialization之后,postProcessAfterInitialization之前执行
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("CustomBeanAwareBean已经初始化完毕");
    }

    /**
     * DisposableBean
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("CustomBeanAwareBean被销毁");
    }
    @PreDestroy
    public void annotationDestoryMethod(){
        System.out.println("CustomBeanAwareBean注解销毁方法");
    }

}
