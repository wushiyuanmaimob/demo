package com.iflytek.com.initializingBean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class TestInitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() {
        System.out.println("[TestInitializingBean] afterPropertiesSet");
    }
}
