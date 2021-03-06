package com.choe.designmodel.singleton;

/**
 * @author cyk
 * @date 2018/7/25/025 14:35
 * @email choe0227@163.com
 * @desc 懒汉式单例, 但是这种是线程不安全的，可能存在获取到的不是同一个实例对象
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class Singleton2 {

    private static Singleton2 singleton ;


    public static Singleton2 getInstance(){

        if (singleton == null){
            try {
                Thread.sleep(3000);
                singleton = new Singleton2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return singleton;
    }

}
