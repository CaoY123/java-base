package com.mine.test;

import com.mine.utils.TalkingClock;

/**
 * @author CaoY
 * @date 2022-11-26 14:12
 * @description 内部类测试，TalkingClock有一个内部类TimePrinter
 */
public class InnerClassTest {
    public static void main(String[] args) {

        TalkingClock clock = new TalkingClock(1000, false);
        clock.start();
    }
}
