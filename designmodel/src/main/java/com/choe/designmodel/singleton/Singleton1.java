package com.choe.designmodel.singleton;

/**
 * @author cyk
 * @date 2018/7/25/025 14:35
 * @email choe0227@163.com
 * @desc 饿汉式单例，线程安全
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class Singleton1 {

    private static Singleton1 singleton1 = new Singleton1();


    public static Singleton1 getInstance(){

        return singleton1;
    }

}
