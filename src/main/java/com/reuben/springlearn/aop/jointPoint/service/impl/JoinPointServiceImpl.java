package com.reuben.springlearn.aop.jointPoint.service.impl;

import com.reuben.springlearn.aop.jointPoint.service.JoinPointService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class JoinPointServiceImpl implements JoinPointService {
    public static ConcurrentHashMap<String, String> consumerMap = new ConcurrentHashMap<>(10);

    @Override
    public Boolean addConsumer(String name) {
        if(consumerMap.containsKey(name)){
            return false;
        }
        consumerMap.put(name,name);
        return true;
    }

    @Override
    public Boolean removeConsumer(String name) {
        if(consumerMap.containsKey(name)){
            return consumerMap.remove(name,name);
        }
        return false;
    }

    @Override
    public Boolean throwException(String name) throws RuntimeException{
        if(name != null){
            throw new RuntimeException(name + "把服务搞崩拉");
        }
        return false;
    }
}
