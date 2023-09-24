package com.iflytek.com.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("cat2")
public class Cat {

    @Value("${os.name}")
    private String name;

    @Value("${user.country}")
    private String country;

    @Value("${user.age}")
    private Integer age;

//    public Cat(String name, String country, Integer age) {
//        this.name = name;
//        this.country = country;
//        this.age = age;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
