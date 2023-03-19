package com.mine.collection;

import com.mine.domain.Student;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author CaoY
 * @date 2023-03-20 0:10
 * @description 列表类测试
 */
public class ArrayListTest {

    /**
     * 对于 ArrayList clone() 的测试，虽然拷贝出来的集合对象是两个完全不同的对象，但是
     * 集合中存储的 对象元素 却是同一个，即还是浅拷贝，这点在对于list3 和 list4 的测试情况可以看出来
     */
    @Test
    public void testClone() {
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(i + 1);
        }
        ArrayList<Integer> list2 = (ArrayList<Integer>) list1.clone();
        System.out.println(list1 == list2);

        // 放的是 类对象
        ArrayList<Student> list3 = new ArrayList<>();
        list3.add(new Student(1, "aa", 12, "男", "地球", "aa@123.com"));
        list3.add(new Student(2, "bb", 23, "女", "月球", "bb@456.com"));

        System.out.println("探究元素是否是深拷贝的情况：");

        ArrayList<Student> list4 = (ArrayList<Student>) list3.clone();
        for (int i = 0; i < list3.size(); i++) {
            Student student1 = list3.get(i);
            Student student2 = list4.get(i);
            System.out.println(student1 == student2);
        }
    }
}
