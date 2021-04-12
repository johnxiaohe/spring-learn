package com.reuben.springlearn.start.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @author Reuben
 * 项目上下文中BeanFactory准备完毕执行,可对BeanFactory进行自定义化改动
 * 在AbstractApplicationContext.refresh()方法中563行invokeBeanFactoryPostProcessors方法中执行
 */
@Configuration
public class CustomBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    /**
     *  读取完项目BeanDefinition后执行该方法.可自行添加未在路径中的BeanDefinition或删除不需要的/重复功能的BeanDefinition/修改BeanDefinition
     * @param beanDefinitionRegistry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("[BeanDefinitionRegistryPostProcessor]注册项目所有BeanDefinition之后执行的注册后拓展方法");
//        beanDefinitionRegistry.getBeanDefinition();
//        beanDefinitionRegistry.registerBeanDefinition();
//        beanDefinitionRegistry.removeBeanDefinition();
    }

    /**
     * BeanFactoryPostProcessor拓展接口方法,可对BeanFactory进行自定义拓展和改动
     * @param configurableListableBeanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("[BeanFactoryPostProcessor]BeanFactory");
    }
}
