package com.mine;

import com.mine.domain.Person;
import com.mine.domain.Student;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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

    /**
     * 关于Modifier的测试
     * @throws Exception 抛出一个大异常，省得抛得多麻烦
     */
    @Test
    public void testModifier() throws Exception {
        Class<Student> clazz = Student.class;
        Field nameField = clazz.getDeclaredField("name");
        // 获取关于name字段的修饰符的一个数字
        int modifiers = nameField.getModifiers();
        // 打印标志修饰符的数字
        System.out.println(modifiers);
        // 分析修饰符
        System.out.println("是否private：" + Modifier.isPrivate(modifiers));
        System.out.println("是否static：" + Modifier.isStatic(modifiers));
        System.out.println("***********************");

        // 获取分析方法的那个数字
        Method getEmailMethod = clazz.getDeclaredMethod("getEmail");
        // 获取关于getEmail()方法的修饰符信息数字码
        int getEmailModifier = getEmailMethod.getModifiers();
        System.out.println(getEmailModifier);
        System.out.println("是否public：" + Modifier.isPublic(getEmailModifier));
        System.out.println("是否final：" + Modifier.isFinal(getEmailModifier));
        System.out.println("***********************");

        // 获取抽象类Person的其中的一个方法的 修饰信息
        Class<Person> personClazz = Person.class;
        Method sayHiMethod = personClazz.getDeclaredMethod("sayHi");
        int sayHiModifiers = sayHiMethod.getModifiers();
        System.out.println(sayHiModifiers);
        System.out.println("是否抽象：" + Modifier.isAbstract(sayHiModifiers));
        System.out.println("***********************");

        // 类的修饰符信息
        int personModifiers = personClazz.getModifiers();
        System.out.println(personModifiers);
        System.out.println("是否为抽象类：" + Modifier.isAbstract(personModifiers));
        System.out.println("是否为公共类：" + Modifier.isPublic(personModifiers));
        System.out.println("***********************");
    }
}
