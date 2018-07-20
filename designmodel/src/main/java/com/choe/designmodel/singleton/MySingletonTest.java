package com.choe.designmodel.singleton;

/**
 * @author cyk
 * @date 2018/7/20/020 15:06
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class MySingletonTest {

    public static void main(String[] args) throws InterruptedException {
//        testCase1();
        testCase2();
//        testCase3();
    }

    public static void testCase3(){
        System.out.println(MySingleton.getInstance()==MySingleton.getInstance());
        MySingleton instance = MySingleton.getInstance();
        MySingleton instance2 = MySingleton.getInstance();
        System.out.println(instance == instance2);
        System.out.println(MySingleton.getInstance().hashCode());
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
    public static void testCase1(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    MySingleton mySingleton = MySingleton.getInstance();
                    mySingleton.setSingletonName("子线程");
                    Thread.sleep(3000);
                    System.out.println("================");
                    System.out.println(mySingleton.getSingletonName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        MySingleton.getInstance().setSingletonName("主线程");
        System.out.println(MySingleton.getInstance().getSingletonName());
    }



    public static void testCase2() throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    MySingleton instance = MySingleton.getInstance();
                    instance.setSingletonName("子线程");;
//                    System.out.println(instance.getSingletonName().hashCode());
//                    Thread.sleep(3000);
                    System.out.println("================");
                    System.out.println("sub  "+instance.hashCode());
                    System.out.println(instance.getSingletonName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(3000);
        MySingleton mySingleton = MySingleton.getInstance();
        mySingleton.setSingletonName("主线程");
        System.out.println("main  "+mySingleton.hashCode());
        System.out.println(mySingleton.getSingletonName());
    }

}
