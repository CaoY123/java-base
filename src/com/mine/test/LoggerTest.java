package com.mine.test;

import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author CaoY
 * @date 2022-11-29 1:24
 * @description 日志测试
 */
public class LoggerTest {

    private static final Logger myLogger = Logger.getLogger("com.company.myapp");

    public static void main(String[] args) {
        Logger globalLogger = Logger.getGlobal();
        // 关闭日志
//        globalLogger.setLevel(Level.OFF);
        globalLogger.info("全局日志信息");
    }

    @Test
    public void test1() {
        myLogger.setLevel(Level.INFO);
        String message = "自定义的日志记录器";
        myLogger.info(message);
//        myLogger.log(Level.FINE, message);
    }

    @Test
    public void test2() {
        String msg = "方法日志信息";
        myLogger.logp(Level.INFO, "com.mine.domain.Student",
                "sayHi", msg);
    }
}
