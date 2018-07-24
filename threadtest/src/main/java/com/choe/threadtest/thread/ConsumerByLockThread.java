package com.choe.threadtest.thread;

import com.choe.threadtest.utils.ConsumerByLock;

/**
 * @author cyk
 * @date 2018/7/24/024 10:35
 * @email choe0227@163.com
 * @desc 消费者线程
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class ConsumerByLockThread extends Thread {
    private ConsumerByLock consumer;


    public ConsumerByLockThread(ConsumerByLock consumer) {
        super();
        this.consumer = consumer;
    }

    @Override
    public void run() {
        consumer.consume();
    }
}
