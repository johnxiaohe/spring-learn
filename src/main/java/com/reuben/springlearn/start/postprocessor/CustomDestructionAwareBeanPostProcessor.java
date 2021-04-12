package com.reuben.springlearn.start.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;


public class CustomDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {

    }

    @Override
    public boolean requiresDestruction(Object bean) {
        return false;
    }
}
