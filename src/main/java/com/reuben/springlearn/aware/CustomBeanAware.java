package com.reuben.springlearn.aware;

import com.reuben.springlearn.constant.ApplicationInfoUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Bean声明周期可执行Aware. 按照顺序往下依次执行
 */
@Component
public class CustomBeanAware implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {
    private String beanName;

    /**
     * BeanNameAware
     * @param s
     */
    @Override
    public void setBeanName(String s) {
        this.beanName = beanName;
    }

    /**
     * BeanFactoryAware
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
