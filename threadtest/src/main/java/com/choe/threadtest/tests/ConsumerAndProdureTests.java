package com.choe.threadtest.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author cyk
 * @date 2018/7/23/023 16:54
 * @email choe0227@163.com
 * @desc 一对一 生产消费者模式, 简单消费生产者模式
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class ConsumerAndProdureTests {

    private static List<String> list = new ArrayList<>();
    private static Object lock = new Object();

    public static void main(String[] args) {

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){

                    synchronized (lock){

                        try {
                            if (list.isEmpty()){
                                System.out.println("等待生产者生产东西....");
                                lock.wait();
                            }
                            System.out.println(list.remove(0)+"被消费了");
                            Thread.sleep(1000);
                            lock.notify();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (lock){
                        try {
                            if (!list.isEmpty()){
                                lock.wait();
                            }
                            System.out.println("准备生产东西...");
                            Random random = new Random();
                            int i = random.nextInt();
                            String name = "生产者"+i;
                            list.add(name);
                            System.out.println(name + "诞生了");
                            Thread.sleep(1000);
                            lock.notify();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        consumerThread.start();
        producerThread.start();
    }


}
