package com.mine;

import com.mine.domain.Student;

import java.lang.reflect.Constructor;

/**
 * @author CaoY
 * @date 2022-11-22 1:09
 * @description 关于反射的测试
 */
public class ClassTest {
    public static void main(String[] args) throws Exception {
        Class<Student> studentClass = Student.class;
        Constructor<Student> constructor = studentClass.getConstructor(null);
        Student student = constructor.newInstance();
        System.out.println(student);
    }
}
