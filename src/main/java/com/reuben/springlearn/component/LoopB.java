package com.reuben.springlearn.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class LoopB {

    @Autowired
    private LoopA loopA;

    public LoopB() {
        System.out.println("加载B");
    }

}
