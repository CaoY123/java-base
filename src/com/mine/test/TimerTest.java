package com.mine.test;

import com.mine.utils.MyTimePrinter;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author CaoY
 * @date 2022-11-26 12:12
 * @description 接口与回调 —— 定时器测试
 */
public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new MyTimePrinter();
        Timer timer = new Timer(1000, listener);
        timer.start();
        // 保持这个程序运行知道用户输入"OK"，这只是一个对话提示框，点击确定有一个放行作用，
        // 以执行后面的程序而本身并没有停止计时器的作用
        JOptionPane.showMessageDialog(null, "停止运行这个程序吗？");
        // 停止计时器
        timer.stop();
    }
}
