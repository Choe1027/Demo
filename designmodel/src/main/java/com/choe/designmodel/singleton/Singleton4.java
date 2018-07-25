package com.choe.designmodel.singleton;

/**
 * @author cyk
 * @date 2018/7/25/025 14:42
 * @email choe0227@163.com
 * @desc 使用静态代码块的方式来实现单例，一种变相的伪饿汉模式，线程安全
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class Singleton4 {

    private static Singleton4 singleton;

    static {
        singleton = new Singleton4();
    }

    public static Singleton4 getInstance(){

        return singleton;
    }
}
