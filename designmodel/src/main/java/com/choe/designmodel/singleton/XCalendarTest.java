package com.choe.designmodel.singleton;

import java.util.Calendar;

/**
 * @author cyk
 * @date 2018/7/20/020 14:54
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class XCalendarTest {

    public static void main(String[] args) {
//        testCase1();
//        testCase2();

        Calendar instance = Calendar.getInstance();
        Calendar instance1 = Calendar.getInstance();
        System.out.println(instance.hashCode() == instance1.hashCode());
    }

    public static void testCase2(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(1000,2,22);
                    System.out.println("================");
                    Thread.sleep(3000);
                    System.out.println("================");
                    System.out.println("calendar sub"+calendar.hashCode());
                    System.out.println(calendar.get(Calendar.YEAR));
                    System.out.println(calendar.get(Calendar.MONTH));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar main"+calendar.hashCode());
        calendar.set(333,3,3);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
    }
    /**
     * 对象接收后的单例对象，操作的不是愿单例对象中的
     */
    public static void testCase1(){
        XCalendar xCalendar = new XCalendar();
        XCalendar xCalendar1 = new XCalendar();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Calendar calendar = xCalendar.getCalendar();
                    calendar.set(1000,2,22);
                    Thread.sleep(3000);
                    System.out.println("================");
                    System.out.println(calendar.get(Calendar.YEAR));
                    System.out.println(calendar.get(Calendar.MONTH));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Calendar calendar = xCalendar1.getCalendar();
        calendar.set(333,3,3);

        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
    }
}
