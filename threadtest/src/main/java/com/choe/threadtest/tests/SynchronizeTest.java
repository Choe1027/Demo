package com.choe.threadtest.tests;

import com.choe.threadtest.domain.MyObj;
import com.choe.threadtest.thread.SynchronizedRunnableA;
import com.choe.threadtest.thread.SynchronizedRunnableB;

/**
 * @author cyk
 * @date 2018/7/23/023 14:22
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class SynchronizeTest {

    public static void main(String[] args) {
        MyObj myObj = new MyObj();
        SynchronizedRunnableA synchronizedRunnableA = new SynchronizedRunnableA(myObj);
        new Thread(synchronizedRunnableA).start();
        new Thread(new SynchronizedRunnableB(myObj)).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                MyObj.multi();
            }
        }).start();
    }
}
