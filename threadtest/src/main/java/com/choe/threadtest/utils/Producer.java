package com.choe.threadtest.utils;

/**
 * @author cyk
 * @date 2018/7/24/024 10:25
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class Producer {

    private Object lock;
    private Store store;

    public Producer(Object lock, Store store) {
        this.lock = lock;
        this.store = store;
    }

    public void produce(){

        synchronized (lock){

            try {
                while (store.size() == Store.capacity){
                    System.out.println(Thread.currentThread().getName()+"waiting....");
                    lock.wait();
                }
                String s = "产品"+System.currentTimeMillis();
                store.add(s);
                System.out.println(Thread.currentThread().getName()+"生产了"+s);
                Thread.sleep(1000);
                lock.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
