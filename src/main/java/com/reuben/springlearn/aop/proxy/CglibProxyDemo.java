package com.reuben.springlearn.aop.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyDemo {

    private static volatile WelcomeStaff welcomeStaff;

    static class WelcomeStaffInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("代理迎宾员工: 哎呦,什么风把您吹来啦！快里面请！");
            return methodProxy.invokeSuper(o, objects);
        }

    }

    public static WelcomeStaff getProxy(){
        if(null == welcomeStaff){
            synchronized (CglibProxyDemo.class){
                if(null == welcomeStaff){
                    Enhancer enhancer = new Enhancer();
                    // 将啥也不会的迎宾员工他爹妈传进去,让他爹妈看看怎么办
                    enhancer.setClassLoader(WelcomeStaff.class.getClassLoader());
                    // 传入迎宾员工工作时的代理员工
                    enhancer.setCallback(new WelcomeStaffInterceptor());
                    enhancer.setSuperclass(WelcomeStaff.class);
                    welcomeStaff =  (WelcomeStaff)enhancer.create();
                }
            }
        }
        return welcomeStaff;
    }



}
