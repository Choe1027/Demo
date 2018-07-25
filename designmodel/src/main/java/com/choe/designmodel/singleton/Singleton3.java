package com.choe.designmodel.singleton;

/**
 * @author cyk
 * @date 2018/7/25/025 14:35
 * @email choe0227@163.com
 * @desc 懒汉式单例, 线程安全，使用双重校验
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class Singleton3 {

    private static Singleton3 singleton ;

    // 这里不实用synchronize 修饰方法的目的在于，虽然能实现线程安全但效率不高
    public static Singleton3 getInstance(){

        if (singleton == null){
            synchronized (Singleton3.class){
                if (singleton == null){
                    try {
                        Thread.sleep(3000);
                        singleton = new Singleton3();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return singleton;
    }

}
