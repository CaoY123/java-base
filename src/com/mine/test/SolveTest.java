package com.mine.test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author CaoY
 * @date 2022-12-22 19:23
 * @description 找一个字符串里面最长的无重复字母的子串 - 面试题目
 */
public class SolveTest {
    public static void main(String[] args) {

//        String str = "abcde";
//        String str = "abacd";
//        String str = "dasdasasdf";
        String str = "eqwtretfsdabnkhjjiy";
        System.out.println(findMin(str));
    }

    public static String findMin(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        Set<Character> set = new HashSet<>();
        set.add(str.charAt(0));
        int begin = 0;
        int end = 1;
        int maxLength = end - begin;
        int resultBegin = begin;
        int resultEnd = end;
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (set.contains(ch)) {
                int lastBegin = begin;
                set.remove(str.charAt(begin++));
                while (set.contains(ch)) {
                    set.remove(str.charAt(begin++));
                }
                if (maxLength < end - lastBegin) {
                    maxLength = end - lastBegin;
                    resultBegin = lastBegin;
                    resultEnd = end;
                }
            }
            end++;
            set.add(ch);
        }
        if (end - begin > maxLength) {
            resultBegin = begin;
            resultEnd = end;
        }
        return str.substring(resultBegin, resultEnd);
    }

}
