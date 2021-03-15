package com.reuben.springlearn.start.config;

import com.reuben.springlearn.component.TestComponent;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @author Reuben
 * 对指定类型Bean实例化流程定制化.可为指定类做上一层封装处理.
 */
@Configuration
public class CustomFactoryBean implements FactoryBean<TestComponent> {

    @Override
    public TestComponent getObject() throws Exception {
        // 对该Bean进行动态代理.
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TestComponent.class);
        enhancer.setClassLoader(TestComponent.class.getClassLoader());
        enhancer.setCallback(new ComponentInterceptor());
        Object obj = enhancer.create();
        return (TestComponent) obj;
    }

    @Override
    public Class<?> getObjectType() {
        return TestComponent.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    class ComponentInterceptor implements MethodInterceptor{
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("自定义BeanFactory创建自定义Bean实例 ------老大他想说话");
            Object obj = methodProxy.invokeSuper(o, objects);
            System.out.println("自定义BeanFactory创建自定义Bean实例 ------这是骂人呢还是祝福呢");
            return obj;
        }
    }
}
