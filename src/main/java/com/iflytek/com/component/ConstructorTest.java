package com.iflytek.com.component;

import org.springframework.stereotype.Component;

@Component
public class ConstructorTest {
    private final Cat cat;

    public ConstructorTest(Cat cat) {
        this.cat = cat;
    }
}
