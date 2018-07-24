package com.choe.threadtest.utils;

/**
 * @author cyk
 * @date 2018/7/24/024 10:11
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class Consumer {

    private Object lock;

    private Store store;

    public Consumer(Object lock, Store store) {
        this.lock = lock;
        this.store = store;
    }

    public void consume(){

        synchronized (lock){

            try {
                while (store.size() <= 0){ // 这里需要使用while，因为如果用if在线程唤醒之后，
                        // 会直接执行wait后的方法，不会进行判断，但是如果使用while，会再次进入循环

                    System.out.println(Thread.currentThread().getName()+"waiting....");
                    lock.wait();
                }
                System.out.println(store.remove(0)+"被"+Thread.currentThread().getName()+"消费了");
                Thread.sleep(1000);
                lock.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
