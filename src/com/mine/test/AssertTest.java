package com.mine.test;

/**
 * @author CaoY
 * @date 2022-11-27 16:45
 * @description 断言学习与测试
 */
public class AssertTest {
    public static void main(String[] args) {
        int x = -1;
//        assert x >= 0 : "x >= 0";
        if (x < 0) throw new AssertionError(x);
    }
}
