package com.iflytek.com.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization ... " + beanName);
        if ("cat".equals(beanName)) {
            Cat cat = (Cat) bean;
            cat.setAge(1000);
            cat.setName("黄黄_" + cat.getName());
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization ... " + beanName);
        if ("cat".equals(beanName)) {
            Cat cat = (Cat) bean;
            cat.setAge(2000);
            cat.setName("黄黄_2" + cat.getName());
        }
        return bean;
    }
}
