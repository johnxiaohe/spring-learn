package com.reuben.springlearn.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyDemo {

    public static CashierStaff getCashierStaff(){
        return CashierStaffProxy.staffProxy;
    }

    static class CashierStaffProxy implements InvocationHandler{
        private CashierStaff xiaomei;
        private static CashierStaff staffProxy = getStaffProxy();

        public CashierStaffProxy(CashierStaff staff) {
            this.xiaomei = staff;
        }

        // 这个proxy是代理类,如果用它执行method.invoke会陷入月读瞳术之中
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(" 代理收银员: 小妹手机交上来该收钱了");
            method.invoke(xiaomei, args);
            System.out.println(" 代理收银员: 给你给你给你给你!");
            return null;
        }

        private static CashierStaff getStaffProxy(){
            return (CashierStaff) Proxy.newProxyInstance(CashierStaff.class.getClassLoader(), new Class[]{CashierStaff.class}, new CashierStaffProxy(new CashierStaffImpl()));
        }
    }

}
