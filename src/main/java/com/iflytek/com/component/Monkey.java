package com.iflytek.com.component;

import org.springframework.beans.factory.annotation.Value;

public class Monkey {
    @Value("${os.name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
