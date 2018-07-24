package com.choe.threadtest.tests;

import com.choe.threadtest.thread.ConsumerByLockThread;
import com.choe.threadtest.thread.ProducerByLockThread;
import com.choe.threadtest.utils.ConsumerByLock;
import com.choe.threadtest.utils.ProducerByLock;
import com.choe.threadtest.utils.StoreByLock;

/**
 * @author cyk
 * @date 2018/7/24/024 15:24
 * @email choe0227@163.com
 * @desc Lock 实现 消费者生产者模式 多对多
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class ConsumerAndProducerLockTests2 {

    public static void main(String[] args) {
        StoreByLock storeByLock = new StoreByLock();
        ConsumerByLock consumerByLock = new ConsumerByLock(storeByLock);
        ProducerByLock producerByLock = new ProducerByLock(storeByLock);
        for (int i = 0; i < 50; i++) {
            Thread thread = new ConsumerByLockThread(consumerByLock);
            thread.setName("消费者"+i);
            thread.start();
        }
        for (int i = 0; i < 50; i++) {
            Thread thread = new ProducerByLockThread(producerByLock);
            thread.setName("生产者"+i);
            thread.start();
        }
    }
}
