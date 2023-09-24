package com.iflytek.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DogConfig {

    @Bean
    public Dog yellowDog() {
        return new Dog();
    }
}
