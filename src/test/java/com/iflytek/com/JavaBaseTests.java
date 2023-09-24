package com.iflytek.com;

import com.iflytek.com.component.CloudAccountPaas;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Java 基础测试
 */
public class JavaBaseTests {
    /**
     * 测试 list 转 map 存在值为 null 的情况
     */
    @Test
    void testLambdaOnListToMapWithNull() {
        System.out.println("test array");
        ArrayList<CloudAccountPaas> list = new ArrayList<>();
        CloudAccountPaas p1 = new CloudAccountPaas();
        p1.setId(10);p1.setQuota(null);
        CloudAccountPaas p2 = new CloudAccountPaas();
        p2.setId(20);p2.setQuota("200");

        list.add(p1);list.add(p2);

        HashMap<Integer, String> p = list.stream().collect(HashMap::new,
                (map, item) -> map.put(item.getId(), item.getQuota()), HashMap::putAll);

        System.out.println(p);
    }
}
