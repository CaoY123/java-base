package com.mine.utils;

import com.mine.domain.Pair;

/**
 * @author CaoY
 * @date 2022-11-30 1:42
 * @description 泛型类工具类
 */
public class PairUtil {

    /**
     * 限定要想调用该方法只能是实现了Comparable接口的类型
     * @param a
     * @param <T>
     * @return
     */
    public static <T extends Comparable> Pair<T, T> minmax(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<T, T>(min, max);
    }

}
