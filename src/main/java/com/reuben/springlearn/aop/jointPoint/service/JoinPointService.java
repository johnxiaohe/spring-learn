package com.reuben.springlearn.aop.jointPoint.service;


public interface JoinPointService {

    Boolean addConsumer(String name);

    Boolean removeConsumer(String name);

    Boolean throwException(String name) throws RuntimeException;

}
