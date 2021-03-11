package com.reuben.springlearn.autoconfig.springspi;

public class TestSpringSpiConfiguration {

    public static void sayHi(){
        System.out.println("我被加载了,还被调用方法了");
    }

    public TestSpringSpiConfiguration() {
        sayHi();
    }
}
