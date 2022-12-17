package com.mine.test;

/**
 * @author CaoY
 * @date 2022-12-15 18:10
 * @description 关于switch-case的测试
 *
 * 开眼了，以前不知道还能这么写
 */
public class SwitchCaseTest {

    public static void main(String[] args) {
        int type = 2;
        switch (type) {
            case 1:
                String test;
                System.out.println("这是1...");
                break;
            case 2:
                test = "my error";
                System.out.print(test);
                break;
        }

    }

}
