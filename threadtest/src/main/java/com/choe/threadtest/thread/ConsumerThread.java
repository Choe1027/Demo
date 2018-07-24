package com.choe.threadtest.thread;

import com.choe.threadtest.utils.Consumer;

/**
 * @author cyk
 * @date 2018/7/24/024 10:35
 * @email choe0227@163.com
 * @desc 消费者线程
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class ConsumerThread extends Thread {
    private Consumer consumer;


    public ConsumerThread(Consumer consumer) {
        super();
        this.consumer = consumer;
    }

    @Override
    public void run() {
        consumer.consume();
    }
}
