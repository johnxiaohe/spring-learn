package com.reuben.springlearn.config;

import com.reuben.springlearn.component.TestComponent;
import com.reuben.springlearn.constant.ApplicationInfoUtils;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.annotation.Configuration;

/**
 * @author Reuben
 * 清楚初始化单例
 */
@Configuration
public class CustomSmartInitializingSingleton implements SmartInitializingSingleton {
    /**
     *  所有单例对象初始化完毕之后的回调接口(非懒加载对象).
     *  postProcessAfterInitialization之后调用
     */
    @Override
    public void afterSingletonsInstantiated() {
        ApplicationInfoUtils.beanfactory.getBean(TestComponent.class).say();
        System.out.println("测试应用单例bean加载完毕");
    }
}
