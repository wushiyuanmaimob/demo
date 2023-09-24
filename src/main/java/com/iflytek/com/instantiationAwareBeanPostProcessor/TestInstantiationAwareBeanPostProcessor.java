package com.iflytek.com.instantiationAwareBeanPostProcessor;

import com.iflytek.com.component.Monkey;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Component
public class TestInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("[TestInstantiationAwareBeanPostProcessor] before instantiation " + beanName);
        if (beanName.equals("ms")) {
            try {
                Method setName = beanClass.getMethod("setName", String.class);
                Annotation[] annotations = beanClass.getAnnotations();
                System.out.println(annotations);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("[TestInstantiationAwareBeanPostProcessor] after instantiation " + beanName);
        if (beanName.equals("ms")) {
            Monkey monkey = (Monkey) bean;
            monkey.setName("mashuai");
        }
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException {

        System.out.println("[TestInstantiationAwareBeanPostProcessor] postProcessProperties " + beanName);
        if (beanName.equals("ms")) {
            Monkey monkey = (Monkey) bean;
            if (!pvs.isEmpty()) {
                pvs.stream().iterator().forEachRemaining(pv -> {
                    System.out.println(pv);
                });
            }
        }
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[TestInstantiationAwareBeanPostProcessor] before initialization " + beanName);
        if (beanName.equals("ms")) {
            Monkey monkey = (Monkey) bean;
            monkey.setName(monkey.getName() + "postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[TestInstantiationAwareBeanPostProcessor] after initialization " + beanName);
        if (beanName.equals("ms")) {
            Monkey monkey = (Monkey) bean;
            monkey.setName(monkey.getName() + "postProcessAfterInitialization");
        }
        return bean;
    }
}
