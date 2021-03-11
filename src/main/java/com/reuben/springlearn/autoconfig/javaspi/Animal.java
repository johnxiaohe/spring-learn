package com.reuben.springlearn.autoconfig.javaspi;

/**
 * SPI 的本质是将接口实现类的全限定名配置在文件中，并由服务加载器读取配置文件，加载实现类。这样可以在运行时，动态为接口替换实现类
 * Java SPI接口类,通过在META-INF/services文件夹下创建该接口全限定类名并将实现类全限定类名放到其中即可实现Java SPI
 */
public interface Animal {

    void speak();
}
