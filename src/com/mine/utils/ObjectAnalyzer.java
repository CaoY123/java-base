package com.mine.utils;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CaoY
 * @date 2022-11-22 23:33
 * @description 对象分析类
 */
public class ObjectAnalyzer {
    // 记录已经打印过的对象的地址，避免重复打印以陷入死循环
    private List<Object> visited = new ArrayList<>();

    /**
     * 在某个类不提供任何toString()方法的情况下，
     * 打印其相关的所有字段，即提供一个通用的toString()
     * @param obj   要打印的对象
     * @return
     */
    public String toString(Object obj) throws IllegalAccessException {
        if (obj == null) {
            // 字段为null，没有打印的必要
            return null;
        }
        if (visited.contains(obj)) {
            // 当发生重复打印同一个对象时输出的提示信息
            return "...";
        }
        // 将其加入到visited中，避免后面可能出现的重复打印
        visited.add(obj);
        Class<?> clazz = obj.getClass();
        if (clazz == String.class) {
            // 为String类型，直接强转并返回
            return (String) obj;
        }
        if (clazz.isArray()) {
            // 为数组类型
            String res = clazz.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) {
                    res += ", ";
                }
                Object val = Array.get(obj, i);
                // 用来判断数组中存放的值的类型是否是基本数据类型，基本数据类型可以直接答应
                if (clazz.getComponentType().isPrimitive()) {
                    res += val;
                } else {
                    // 如果不是基本数据类型，则走到此处也不可能是String，一定是其他类型，
                    // 继续调用toString(val)递归分析
                    res += this.toString(val);
                }
            }
            return res + "}";
        }

        // 不是数组类型，则是其他数据类型，考虑到其中可以有不同类之间的聚合，
        // 所以要采用递归策略
        String res = clazz.getName();
        do {
            res += "{";
            // 拿到本类的所有字段，不包括父类
            Field[] fields = clazz.getDeclaredFields();
            // 批量设置能访问非public字段
            AccessibleObject.setAccessible(fields, true);
            for (Field field : fields) {
                // 一般我们只打印非静态（实例）字段
                if (!Modifier.isStatic(field.getModifiers())) {
                    if (!res.endsWith("{")) {
                        res += ", ";
                    }
                    res += field.getName() + "=";
                    // 获取该对象该字段的类型
                    Class<?> type = field.getType();
                    // 获取该对象该字段的值
                    Object val = field.get(obj);
                    if (type.isPrimitive()) {
                        // 该字段为基本数据类型
                        res += val;
                    } else {
                        // 该字段为数组或其他数据类型，递归打印
                        res += this.toString(val);
                    }
                }
            }
            // 将Class类对象置为其直接父类，因为我们上面打印的字段不包括父类的字段，
            // 逐级打印
            clazz = clazz.getSuperclass();
            res += "}";
        } while (clazz != null);
        return res;
    }

}
