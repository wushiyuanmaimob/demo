package com.iflytek.com.beanDefinitionRegistryPostProcessor;

import com.iflytek.com.component.Cat;
import com.iflytek.com.component.Monkey;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class TestBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("TestBeanDefinitionRegistryPostProcessor ... postProcessBeanDefinitionRegistry ...");
        if (!registry.containsBeanDefinition("ms")) {
            RootBeanDefinition def = new RootBeanDefinition();
            def.setBeanClass(Cat.class);
            def.setPrimary(true);
            registry.registerBeanDefinition("ms", def);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("TestBeanDefinitionRegistryPostProcessor ... postProcessBeanFactory ...");
        RootBeanDefinition msBeanDef = (RootBeanDefinition) beanFactory.getBeanDefinition("ms");
        msBeanDef.setBeanClass(Monkey.class);
    }
}
