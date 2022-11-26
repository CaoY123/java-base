package com.mine.utils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * @author CaoY
 * @date 2022-11-26 12:14
 * @description 自定义的计时器打印工具
 */
public class MyTimePrinter implements ActionListener {
    // 执行行为的方法
    @Override
    public void actionPerformed(ActionEvent event) {
        // 每隔1秒钟打印一条消息
        System.out.println("At the tone, the time is " +
                Instant.ofEpochMilli(event.getWhen()));
        // 让时钟响起来
        Toolkit.getDefaultToolkit().beep();
    }
}
