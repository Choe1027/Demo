package com.choe.threadtest.tests;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cyk
 * @date 2018/7/24/024 15:14
 * @email choe0227@163.com
 * @desc 生产者消费者 一对一模式
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class ConsumerAndProducerLockTests {

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static boolean isAExec = false;


    public static void main(String[] args) {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        lock.lock();
                        while (!isAExec){
                            condition.await();
                        }
                        System.out.println("A执行");
                        Thread.sleep(1000);
                        isAExec = false;
                        condition.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        });


        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        lock.lock();
                        while (isAExec){
                            condition.await();
                        }
                        System.out.println("B执行");
                        Thread.sleep(1000);
                        isAExec = true;
                        condition.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        });

        threadA.setName("线程A");
        threadB.setName("线程B");

        threadA.start();
        threadB.start();
    }
}
