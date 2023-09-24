package com.iflytek.com.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {
    @Autowired
    private A a;

//    public B(A a) {
//        this.a = a;
//    }

    public int div(int a, int b) {
        final int i = a / b;

        return i;
    }
}
