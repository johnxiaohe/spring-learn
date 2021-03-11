package com.reuben.springlearn.autoconfig.javaspi;

public class Dog implements Animal{

    public Dog() {
        System.out.println("小狗类被加载了");
    }

    @Override
    public void speak() {
        System.out.println("小狗汪汪");
    }
}
