package com.mine.test;

import com.mine.domain.Student;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
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

        // 另一个例子 - timer表达式的lambda写法
        ActionListener listener = event -> {
            System.out.println("the Time is + " + Instant.ofEpochMilli(event.getWhen()));
            // 让时钟响起来
            Toolkit.getDefaultToolkit().beep();
        };
        Timer timer = new Timer(1000, listener);
        timer.start();
        JOptionPane.showMessageDialog(null, "停止运行这个程序吗？");
        timer.stop();
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

    private static Student[] students;

    static {
        Student student1 = new Student(1, "张三", 20, "男", "上海", "zs@126.com");
        Student student2 = new Student(2, "李四", 21, "女", "北京", "ls@qq.com");
        Student student3 = new Student(3, "王五", 19, "女", "天津", "ww@163.com");
        Student student4 = new Student(4, "赵六", 16, "男", "深圳", "zl@126.com");
        Student student5 = new Student(5, "候七", 17, "男", "广东", "hq@qq.com");
        students = new Student[]{student1, student2, student3, student4, student5};
    }

    @Test
    public void test2() {

        System.out.println("排序前：");
        System.out.println(Arrays.toString(students));
        Arrays.sort(students, Comparator.comparing(Student::getAge));
        System.out.println("********************************");
        System.out.println("排序后：");
        System.out.println(Arrays.toString(students));
    }
}
