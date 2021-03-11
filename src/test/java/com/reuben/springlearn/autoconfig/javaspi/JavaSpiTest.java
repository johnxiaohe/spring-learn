package com.reuben.springlearn.autoconfig.javaspi;

import org.junit.jupiter.api.Test;

import java.util.ServiceLoader;

public class JavaSpiTest {

    /**
     * 测试JavaSPI机制
     */
    @Test
    public void speak(){
        ServiceLoader<Animal> serviceLoader = ServiceLoader.load(Animal.class);
        System.out.println("Java SPI Running");
        serviceLoader.forEach(Animal::speak);
    }
}
