package com.choe.threadtest.tests;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cyk
 * @date 2018/7/25/025 10:18
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class TryLockTimeOutTests {

    private  static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+"执行开始时间："+System.currentTimeMillis());
                    if (lock.tryLock(3,TimeUnit.SECONDS)){
                        System.out.println(Thread.currentThread().getName()+"获取锁时间："+System.currentTimeMillis());
                        Thread.sleep(10000); // 这个时间决定另外一个线程能否获取到锁
                    }
                    else {
                        System.out.println(Thread.currentThread().getName()+"没有获取到锁时间："+System.currentTimeMillis());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    if (lock.isHeldByCurrentThread()){
                        lock.unlock();
                    }
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.setName("threadA");
        Thread threadB = new Thread(runnable);
        threadB.setName("threadB");
        thread.start();
        threadB.start();
    }
}
