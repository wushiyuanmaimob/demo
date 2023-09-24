package com.iflytek.com.disposableBean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class TestDisposableBean implements DisposableBean {
    @Override
    public void destroy() {
        System.out.println("[TestDisposableBean ... destroy ...]");
    }
}
