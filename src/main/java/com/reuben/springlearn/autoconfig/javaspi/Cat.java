package com.reuben.springlearn.autoconfig.javaspi;

public class Cat implements Animal{

    public Cat() {
        System.out.println("小猫类被加载了");
    }

    @Override
    public void speak() {
        System.out.println("小猫喵喵");
    }
}
