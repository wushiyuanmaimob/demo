package com.iflytek.com.beanNameAware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class TestBeanNameAware implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("TestBeanNameAware ... " + name);
    }
}
