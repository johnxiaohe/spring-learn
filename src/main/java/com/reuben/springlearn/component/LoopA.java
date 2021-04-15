package com.reuben.springlearn.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class LoopA {

    @Autowired
    private LoopB loopB;

    public LoopA() {
        System.out.println("加载A");
    }

}
