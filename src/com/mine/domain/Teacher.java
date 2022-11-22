package com.mine.domain;

/**
 * @author CaoY
 * @date 2022-11-22 23:59
 * @description 教师类
 */
public class Teacher extends Person{

    private String name;
    private Student[] students;

    public Teacher() {

    }

    public Teacher(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public void sayHi() {
        System.out.println("Hi，大家好，我是一名人民教师！");
    }
}
