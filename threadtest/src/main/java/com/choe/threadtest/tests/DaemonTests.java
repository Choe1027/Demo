package com.choe.threadtest.tests;

import com.choe.threadtest.thread.DaemonThread;

/**
 * @author cyk
 * @date 2018/7/23/023 11:06
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class DaemonTests {

    public static void main(String[] args) throws InterruptedException {
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true); // 设置为守护线程之后，运行完成 虚拟机关闭，则守护线程也关闭
        daemonThread.start();
        Thread.sleep(5000);
        System.out.println("=================");
    }
}
