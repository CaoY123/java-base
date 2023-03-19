package com.mine.collection;

import java.util.*;

/**
 * @author CaoYang
 * @create 2023-03-13-12:43 PM
 * @description 集合学习
 */
public class CollectionTest1 {

    public static void main(String[] args) {
        Collection collection = null;
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        System.out.println("删除前：");
        System.out.println(list);

        // 下面不可行
//        System.out.println("删除后：");
//        Iterator<Integer> it = list.iterator();
//        it.next();
//        it.next();
//        it.remove();
//        System.out.println(list);

        list = new LinkedList<>();
        if (list instanceof RandomAccess) {
            System.out.println("支持高效的随机访问");
        } else {
            System.out.println("不支持高效的随机访问");
        }

    }
}
