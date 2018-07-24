package com.choe.threadtest.thread;

import com.choe.threadtest.domain.MyObj;

/**
 * @author cyk
 * @date 2018/7/23/023 14:25
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class SynchronizedRunnableB implements Runnable{
    private MyObj myObj ;

    public SynchronizedRunnableB(MyObj myObj) {
        this.myObj = myObj;
    }

    @Override
    public void run() {
        myObj.minus();
    }
}
