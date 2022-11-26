package com.mine.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author CaoY
 * @date 2022-11-26 14:45
 * @description 用于跟踪的代理类
 */
public class TraceHandler implements InvocationHandler {

    private Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 打印隐式参数：
        System.out.print(target);
        // 答应调用的方法的名称：
        System.out.print("." + method.getName() + "(");
        // 答应显式的参数
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println(")");
        return method.invoke(target, args);
    }
}
