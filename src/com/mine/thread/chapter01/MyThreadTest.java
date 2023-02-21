package com.mine.thread.chapter01;

/**
 * @author CaoY
 * @date 2023-02-21 23:47
 * @description 自定义的简单的线程交互实例
 */
public class MyThreadTest {

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("当前线程 ==> 【" + Thread.currentThread() + "】");
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("*******A*******B********C***********");
                    try {
                        Thread.sleep(0L, 1);
                    } catch (InterruptedException e) {
                        System.out.println("发生了睡眠异常...");
                    }
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();


    }

}
