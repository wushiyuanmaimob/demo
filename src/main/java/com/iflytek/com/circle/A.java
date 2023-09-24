package com.iflytek.com.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
    @Autowired
    private B b;

//    public A(B b) {
//        this.b = b;
//    }

    public int div(int a, int b) {
        final int i = a / b;

        return i;
    }

}
