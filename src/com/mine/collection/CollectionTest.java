package com.mine.collection;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

import java.util.*;

/**
 * @author CaoY
 * @date 2023-03-19 20:36
 * @description 集合的学习练习
 */
public class CollectionTest {

    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>();
        collection = new HashSet<>();
        collection = new PriorityQueue<>();
        collection = new ArrayQueue<>(12);
    }

    @Test
    public void testRemoveIf() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }

        // 删除前：
        System.out.println(list);
        // 删除集合中的 奇数
        list.removeIf(t -> t % 2 == 1);
        System.out.println("*************删除后*************");
        System.out.println(list);
    }

    @Test
    public void testRetainAll() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(6);
        set.add(9);

        System.out.println(list);

        System.out.println("**************调用 retainAll后**************");
        list.retainAll(set);

        System.out.println(list);
    }

    @Test
    public void testClear() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        list.clear();
        System.out.println(list.size());
    }

    // 测试集合的 equals() -> 不同的集合，尽管拥有相同的元素，但是也不会算作两个集合相等
    @Test
    public void testEquals() {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
            set.add(i + 1);
        }
        System.out.println("list与set相等吗？ -> " + list.equals(set));
        for (int i = 10; i > 0; i--) {
            list2.add(i);
            set2.add(i);
        }
        // 两个list的比较需要考虑元素的顺序
        System.out.println("list与list2相等吗？ -> " + list.equals(list2));
        // 两个set的比较不考虑元素的顺序
        System.out.println("set与set2相等吗？ -> " + set.equals(set2));
    }
}
