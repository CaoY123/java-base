package com.mine;

import org.junit.Test;

import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author CaoY
 * @date 2022-11-24 22:25
 * @description Lambda测试
 * 只有一个抽象方法的接口 称为 函数式接口
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[] {
                "Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"
        };
        System.out.println("排序前：");
        System.out.println(Arrays.toString(planets));
        System.out.println("***************************");
        System.out.println("按照字符长度排序：");
        // 用Lambda表达式写排序规则
        Arrays.sort(planets, (String first, String second) -> {return first.length() - second.length(); });
//        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));
        System.out.println("***************************");

        // 另一个例子
        ActionListener listener = event -> System.out.println("Time is + " + Instant.ofEpochMilli(event.getWhen()));
    }

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();

        String[] arr = {
                "Hello", "World", "GoGoGo", null,
                "Science", "Java", "Interface",
                null, "GitHub"
        };

        // 主要是要将内容放在ArrayList中
        list.addAll(Arrays.asList(arr));

        System.out.println(list);
        System.out.println("**********************");
        // Predicate（谓词）函数式接口，按住ctrl + 箭头可以跳到相应的接口
        list.removeIf(e -> e == null);
        System.out.println(list);
    }
}
