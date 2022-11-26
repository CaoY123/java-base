package com.mine.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * @author CaoY
 * @date 2022-11-26 14:01
 * @description 自定义时钟类
 */
public class TalkingClock {
    // 时间间隔
    private int interval;
    // 是否响铃
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        TimePrinter listener = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
        JOptionPane.showMessageDialog(null, "停止运行这个程序吗？");
        timer.stop();
    }

    // 内部类探究
    public class TimePrinter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            // 每隔1秒钟打印一条消息
            System.out.println("At the tone, the time is " +
                    Instant.ofEpochMilli(event.getWhen()));
            if (beep) {
                // 让时钟响起来
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
