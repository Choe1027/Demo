package com.choe.threadtest.domain;

/**
 * @author cyk
 * @date 2018/7/23/023 14:20
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class MyObj {

    private static int i = 0 ;


    public synchronized void add() {
        try {
            System.out.println(Thread.currentThread().getName()+"获取到锁");
            Thread.sleep(2000);
            i++;
            System.out.println(Thread.currentThread().getName()+"加了1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized static void minus(){
        try {
            System.out.println(Thread.currentThread().getName()+"获取到静态锁");
            Thread.sleep(3000);
            i++;
            System.out.println(Thread.currentThread().getName()+"减了1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized  static  void multi(){
        System.out.println(Thread.currentThread().getName()+"获取到静态锁");
        i *= 2;
        System.out.println(Thread.currentThread().getName()+"成了2倍");
    }
}
