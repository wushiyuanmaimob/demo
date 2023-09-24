package com.iflytek.com.postConstruct;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestPostConstruct {
    @PostConstruct
    public void init() {
        System.out.println("[TestPostConstruct] init");
    }
}
