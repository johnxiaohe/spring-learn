package com.reuben.springlearn.component;


//@Component
public class TestComponent {

    public TestComponent() {
        System.out.println("扫描配置类TestComponent被实例化了======================");
    }

    public void say(){
        System.out.println("TestComponentBean有话说,大哥大嫂过年好!");
    }
}
