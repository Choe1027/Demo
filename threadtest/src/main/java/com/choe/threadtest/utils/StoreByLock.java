package com.choe.threadtest.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cyk
 * @date 2018/7/24/024 10:12
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class StoreByLock {

    public static int capacity = 20;

    private List<String> list = new ArrayList<>();

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void produce(){
        try {
            lock.lock();
            while (list.size() == capacity){
                System.out.println(Thread.currentThread().getName()+"等待了");
                condition.await();
            }
            list.add("商品"+System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName()+"生产了一个商品"+list.size());
            Thread.sleep(1000);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void consume(){

        try {
            lock.lock();
            while (list.size() <= 0){
                System.out.println(Thread.currentThread().getName()+"等待了");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+"消费了产品"+list.remove(0));
            Thread.sleep(1000);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
