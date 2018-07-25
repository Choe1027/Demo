package com.choe.designmodel.singleton;

/**
 * @author cyk
 * @date 2018/7/25/025 14:44
 * @email choe0227@163.com
 * @desc 用来测试多线程环境下的单例模式
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class SingletonTests {

    public static void main(String[] args) {

//        testCase1();
//        testCase2(); //不安全的单例模式
//        testCase3(); //线程安全
//        testCase4();
        testCase5();
    }

    /**
     * 测试线程安全的条件下，修改属性是否安全
     * 关于Singleton5 中的testField 属性，也是安全的，本案例打印出的结果每次都可能不同，因为获取到锁的顺序是不可控
     */
    public static void testCase5(){

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Singleton5 instance = Singleton5.getInstance();
                    instance.setTestField("threadA");
                    System.out.println("准备休眠....");
                    Thread.sleep(3000);
                    System.out.println("ThreadA instance.getTestField()="+instance.getTestField());
                    System.out.println("ThreadA Singleton5.getInstance().getTestField()="+Singleton5.getInstance().getTestField());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.setName("ThreadA");
        threadA.start();
        System.out.println("main开始执行....");
        Singleton5 instance = Singleton5.getInstance();
        instance.setTestField("main");
        System.out.println("Main instance.getTestField()="+instance.getTestField());
        System.out.println("Main Singleton5.getInstance().getTestField()="+Singleton5.getInstance().getTestField());
    }
    /**
     * 测试饿汉式单例模式
     */
    public static void testCase1(){

        for (int i = 0; i < 100 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Singleton1.getInstance().hashCode());
                }
            }).start();
        }
    }

    /**
     * 测试懒式单例模式
     */
    public static void testCase2(){

        for (int i = 0; i < 10 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    System.out.println(Singleton2.getInstance().hashCode());
                }
            }).start();
        }
    }


    /**
     * 测试懒式单例模式 双重校验
     */
    public static void testCase3(){

        for (int i = 0; i < 10 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    System.out.println(Singleton3.getInstance().hashCode());
                }
            }).start();
        }
    }


    /**
     * 测试静态代码块单例模式实现
     */
    public static void testCase4(){

        for (int i = 0; i < 10 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    System.out.println(Singleton4.getInstance().hashCode());
                }
            }).start();
        }
    }
}
