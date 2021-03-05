package com.reuben.springlearn.config;

import com.reuben.springlearn.component.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    public BeanConfig() {
        System.out.println("扫描配置类BeanConfig被实例化了======================");
    }

    @Bean
    public TestBean testBean(){
        return new TestBean();
    }


}
