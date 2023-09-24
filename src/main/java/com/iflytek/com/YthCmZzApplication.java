package com.iflytek.com;

import com.iflytek.com.circle.A;
import com.iflytek.com.component.Cat;
import com.iflytek.com.component.Monkey;
import com.iflytek.com.component.MyComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
@EnableAspectJAutoProxy
//@ComponentScan(basePackages = {"com.iflytek.com.circle", "com.iflytek.com.aop"})
public class YthCmZzApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(YthCmZzApplication.class);

        ConfigurableApplicationContext context = SpringApplication.run(YthCmZzApplication.class, args);
        Cat cat = context.getBean(Cat.class);
        String name = cat.getName();
        String country = cat.getCountry();

        Object cat2 = context.getBean("cat2");

        logger.info(name);
        logger.info(country);

        PropertySourcesPlaceholderConfigurer configurer = context.getBean(PropertySourcesPlaceholderConfigurer.class);
        System.out.println(configurer);

        MyComponent component = context.getBean(MyComponent.class);
        component.run();

        Monkey ms = (Monkey) context.getBean("ms");
        System.out.println(ms.getName());

        Object factoryBean = context.getBean("testFactoryBean");
        System.out.println(factoryBean);

        A a = (A) context.getBean("a");
        System.out.println(a);


    }

}
