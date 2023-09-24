package com.iflytek.com;

import com.iflytek.com.circle.A;
import com.iflytek.com.circle.B;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class YthCmZzApplicationTests {

    private ApplicationContext context;

    public YthCmZzApplicationTests(ApplicationContext context) {
        this.context = context;
    }

    @Test
    void contextLoads() {
        System.out.println("contextLoaded");
    }

    @Test
    void testGetSpringFactoriesInstances() {
        var aClass = ApplicationContextInitializer.class;
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        Set<String> names = new LinkedHashSet<>(SpringFactoriesLoader.loadFactoryNames(aClass, classLoader));

        var instances = createSpringFactoriesInstances(aClass, new Class<?>[] {}, classLoader, new Object[] {}, names);
        System.out.println(instances);
    }


    @SuppressWarnings("unchecked")
    private <T> List<T> createSpringFactoriesInstances(Class<T> type, Class<?>[] parameterTypes,
                                                       ClassLoader classLoader, Object[] args, Set<String> names) {
        List<T> instances = new ArrayList<>(names.size());
        for (String name : names) {
            try {
                Class<?> instanceClass = ClassUtils.forName(name, classLoader);
                Assert.isAssignable(type, instanceClass);
                Constructor<?> constructor = instanceClass.getDeclaredConstructor(parameterTypes);
                T instance = (T) BeanUtils.instantiateClass(constructor, args);
                instances.add(instance);
            }
            catch (Throwable ex) {
                throw new IllegalArgumentException("Cannot instantiate " + type + " : " + name, ex);
            }
        }
        return instances;
    }

    /**
     * 测试循环依赖
     */
    @Test
    void testAB() {
        A a = (A) context.getBean("a");
        B b = (B) context.getBean("b");
        System.out.println(a);
        System.out.println(b);
        a.div(1, 1);
        b.div(1, 1);
    }
}
