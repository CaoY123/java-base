package com.mine;

import org.omg.CORBA.IntHolder;

import java.io.Console;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

/**
 * @author CaoY
 * @date 2022-11-19 3:22
 * @description 测试类
 *
 */
public class Test {

    public static void main(String[] args) {
        IntHolder a = new IntHolder(5);
        System.out.println(a.value);
        func(a);
        System.out.println(a.value);
    }

    public static void func(IntHolder a) {
        a.value = a.value * 3;
    }
}


