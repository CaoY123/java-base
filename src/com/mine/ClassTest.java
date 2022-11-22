package com.mine;

import com.mine.domain.CollegeStudent;
import com.mine.domain.Person;
import com.mine.domain.Student;
import com.mine.domain.Teacher;
import com.mine.utils.ObjectAnalyzer;
import org.junit.Test;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

        // 将修饰符的信息码解析成字符串
        System.out.println("Person类的修饰符信息：" + Modifier.toString(personModifiers));
    }

    @Test
    public void testFieldAndMethodAndConstructor() {
        Class<Student> clazz = Student.class;
        // field：
        System.out.println("getFields()方法：");
        Field[] fields1 = clazz.getFields();
        for (Field field : fields1) {
            System.out.println(field.getName());
        }
        System.out.println("*******************************");

        System.out.println("getDeclaredFields()方法：");
        Field[] fields2 = clazz.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println(field.getName());
        }
        System.out.println("*******************************");

        System.out.println("getMethods()方法：");
        Method[] methods1 = clazz.getMethods();
        for (Method method : methods1) {
            System.out.println(method.getName());
        }
        System.out.println("*******************************");

        System.out.println("getDecalredMethods()方法：");
        Method[] methods2 = clazz.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println(method.getName());
        }
        System.out.println("*******************************");

        Class<CollegeStudent> clazz2 = CollegeStudent.class;
        System.out.println("getConstructors()方法：");
        Constructor<?>[] constructors1 = clazz2.getConstructors();
        for (Constructor<?> constructor : constructors1) {
            System.out.println(constructor.getName() + " 参数个数：" + constructor.getParameterCount());
        }
        System.out.println("*******************************");

        System.out.println("getDeclaredConstructors()方法：");
        Constructor<?>[] constructors2 = clazz2.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors2) {
            System.out.println(constructor.getName() + " 参数个数：" + constructor.getParameterCount());
        }
        System.out.println("*******************************");
    }

    /**
     * 使用private权限的字段或方法
     */
    @Test
    public void testUsePrivate() throws Exception {
        Class<Student> clazz = Student.class;
        // 获取一个Student的实例
        Student student = clazz.newInstance();
        Method studyMethod = clazz.getDeclaredMethod("study");
        // 将private字段或方法的执行权限设置为true
        studyMethod.setAccessible(true);
        studyMethod.invoke(student);
    }

    /**
     * 利用反射扩充数组
     * @param a         旧数组
     * @param newLength 新的数组的长度
     * @return
     */
    public static Object goodCopyOf(Object a, int newLength) {
        Class<?> clazz = a.getClass();
        if (!clazz.isArray()) {
            // 不是数组类，直接返回null，不进行拷贝操作
            return null;
        }
        Class<?> type = clazz.getComponentType();
        // 反射获取数组的长度
        int length = Array.getLength(a);
        // 反射创建新数组，传入元素的类型以及新数组的长度（newLength）
        Object newArray = Array.newInstance(type, newLength);
        // 利用System的方法从旧数组深拷贝到新数组
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }



    private static Student[] students;

    static {
        Student student1 = new Student(1, "张三", 20, "男", "上海", "zs@126.com");
        Student student2 = new Student(2, "李四", 20, "女", "北京", "ls@qq.com");
        Student student3 = new Student(3, "王五", 20, "女", "天津", "ww@163.com");
        Student student4 = new Student(4, "赵六", 20, "男", "深圳", "zl@126.com");
        Student student5 = new Student(5, "候七", 20, "男", "广东", "hq@qq.com");
        students = new Student[]{student1, student2, student3, student4, student5};
    }

    /**
     * 使用反射去深拷贝数组，测试上面的goodCopy方法
     */
    @Test
    public void testCopyOfArray() {
        System.out.println("拷贝前：");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("***********************");
        int newLength = 4;
        Student[] newStudents = (Student[]) goodCopyOf(students, newLength);
        System.out.println("深拷贝后：");
        for (Student newStudent : newStudents) {
            System.out.println(newStudent);
        }
        System.out.println("是否为同一个数组：" + (students == newStudents));
        System.out.println("***********************");
    }

    /**
     * 对于通用打印方法的测试
     * 虽然通用，但是这样的打印确实有一定的弊端，在构造对象的时候需要注意的太多，
     * 这里仅作为反射的练习，一般不建议使用，如果有更好的完善欢迎来补充...
     */
    @Test
    public void testToStringInObjectAnalyzer() throws IllegalAccessException {
        Student[] newStudents = (Student[]) goodCopyOf(students, students.length);
        Teacher teacher = new Teacher("王老师", newStudents);
        String str = new ObjectAnalyzer().toString(teacher);
        System.out.println(str);
        System.out.println("********************");

        String str2 = new ObjectAnalyzer().toString(students);
        System.out.println(str2);
        System.out.println("********************");

        List<Student> list = Arrays.asList(ClassTest.students);
        String str3 = new ObjectAnalyzer().toString(list);
        System.out.println(str3);
    }
}
