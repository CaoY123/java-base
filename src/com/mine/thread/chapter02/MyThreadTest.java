package com.mine.thread.chapter02;

import org.junit.internal.runners.statements.RunAfters;

import java.util.Objects;

/**
 * @author CaoY
 * @date 2023-02-22 0:13
 * @description 我的线程状态测试案例
 */
public class MyThreadTest {

    public static void main(String[] args) throws InterruptedException {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("我的线程 【 r 】...");
                    System.out.println("线程【" + Thread.currentThread().getName() + "】可运行态：" + Thread.currentThread().getState());
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 300; i++) {
                    System.out.println("我的线程 ====>>> r2");
                }
            }
        };

        Thread myThread = new Thread(r);
        Thread myThread2 = new Thread(r2);
        // 设置线程名
        myThread.setName("线程1号");
        // 设置线程优先级
        System.out.println("修改线程优先级前线程【" + myThread.getName() + "】的优先级：" + myThread.getPriority());
        System.out.println("修改线程优先级前线程【" + myThread.getName() + "】的优先级：" + myThread.getPriority());
        myThread.setPriority(2);
        System.out.println("】新建状态：" + myThread.getState());
        System.out.println("修改线程优先级前线程【" + myThread.getName() + "】的优先级：" + myThread.getPriority());
        System.out.println("修改线程优先级前线程【" + myThread2.getName() + "】的优先级：" + myThread2.getPriority());
        myThread.start();
        myThread2.start();

        System.out.println("**********************************");


    }
}
