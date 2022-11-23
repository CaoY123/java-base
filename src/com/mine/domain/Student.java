package com.mine.domain;

import java.util.Objects;

/**
 * @author CaoY
 * @date 2022-11-22 1:15
 * @description 学生类，用于测试和练习
 */
public class Student extends Person implements Comparable<Student>{
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String address;
    private String email;

    public Student() {

    }

    public Student(Integer id, String name, Integer age, String sex, String address, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id) && name.equals(student.name) && age.equals(student.age) && sex.equals(student.sex) && address.equals(student.address) && email.equals(student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, sex, address, email);
    }

    /**
     * 继承自抽象类Person的出现方法
     */
    @Override
    public void sayHi() {
        System.out.println("Hello, 大家好，我是一名学生。");
    }

    private void study() {
        System.out.println("偷偷学习ing...");
    }

    @Override
    public int compareTo(Student o) {
        // 通过年龄由大到小进行排序
        return Integer.compare(this.age, o.age);
    }
}
