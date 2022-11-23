package com.mine.domain;

import java.util.Objects;

/**
 * @author CaoY
 * @date 2022-11-22 22:45
 * @description 大学生类，继承学生类
 */
public class CollegeStudent extends Student{
    private String specialty;

    public CollegeStudent() {
        super();
    }

    public CollegeStudent(String specialty) {
        this.specialty = specialty;
    }

    // 私有构造器，为了测试反射的响应方法用
    private CollegeStudent(Integer id, String name, String age) {

    }

    public CollegeStudent(Integer id, String name, Integer age, String sex, String address, String email, String specialty) {
        super(id, name, age, sex, address, email);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "CollegeStudent{" +
                "specialty='" + specialty + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CollegeStudent that = (CollegeStudent) o;
        return specialty.equals(that.specialty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specialty);
    }

    public static void sayHello() {
        System.out.println("Hello, 大家好，我是一名大学生！");
    }
}
