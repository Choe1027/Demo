package com.choe.threadtest.thread;

import com.choe.threadtest.utils.ProducerByLock;

/**
 * @author cyk
 * @date 2018/7/24/024 10:35
 * @email choe0227@163.com
 * @desc 生产者线程
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class ProducerByLockThread extends Thread {
    private ProducerByLock producer;


    public ProducerByLockThread(ProducerByLock producer) {
        super();
        this.producer = producer;
    }

    @Override
    public void run() {
        producer.produce();
    }
}
