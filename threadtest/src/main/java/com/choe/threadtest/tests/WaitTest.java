package com.choe.threadtest.tests;

/**
 * @author cyk
 * @date 2018/7/23/023 16:45
 * @email choe0227@163.com
 * @desc 测试线程等待
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class WaitTest {
    private static Object object = new Object();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    try {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                               synchronized (object){
                                   try {
                                       object.wait(300);
                                       object.notify();
                                   } catch (InterruptedException e) {
                                       e.printStackTrace();
                                   }
                               }
                            }
                        }).start();
                        object.wait(5000);
                        System.out.println("xxxxxx");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
