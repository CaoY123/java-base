package com.mine.test;

import com.mine.utils.TraceHandler;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @author CaoY
 * @date 2022-11-26 14:53
 * @description 代理类的测试
 */
public class ProxyTest {
    public static void main(String[] args) {
        int length = 1000;
        Object[] elements = new Object[length];
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            TraceHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(
                    ClassLoader.getSystemClassLoader(),
                    new Class[]{Comparable.class},
                    handler
            );
            elements[i] = proxy;
        }

        // 随机生成一个待查找的整数
        int target = new Random(System.currentTimeMillis()).nextInt(length + 1);

        // 调用二分法查找
        int result = Arrays.binarySearch(elements, target);

        if (result >= 0) {
            System.out.println(elements[result]);
        }
    }
}
