package com.reuben.springlearn.aop.proxy;

/**
 * 迎宾员工,这个员工比较懒,又没师傅,所以很多工作没学会,就为自己找了代理将自己不会的工作让代理做
 */
public class WelcomeStaff{

    public void sayHello(){
        System.out.println("迎宾员工: 欢迎光临！");
    }
}
