package com.choe.designmodel.singleton;

/**
 * @author cyk
 * @date 2018/7/25/025 14:35
 * @email choe0227@163.com
 * @desc 懒汉式单例, 线程安全，使用双重校验 带有属性
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class Singleton5 {

    private static Singleton5 singleton ;

    private String testField;

    public static Singleton5 getInstance(){
        if (singleton == null){
            System.out.println(Thread.currentThread().getName()+"获取到锁");
            synchronized (Singleton5.class){
                if (singleton == null){
                    singleton = new Singleton5();
                }
            }
            System.out.println(Thread.currentThread().getName()+"释放锁");
        }
        return singleton;
    }

    public String getTestField() {
        return testField;
    }

    public void setTestField(String testField) {
        this.testField = testField;
    }
}
