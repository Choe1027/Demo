package com.choe.threadtest.tests;

import com.choe.threadtest.thread.ConsumerThread;
import com.choe.threadtest.thread.ProducerThread;
import com.choe.threadtest.utils.Consumer;
import com.choe.threadtest.utils.Producer;
import com.choe.threadtest.utils.Store;

/**
 * @author cyk
 * @date 2018/7/23/023 17:28
 * @email choe0227@163.com
 * @desc 多生产者 多消费者的生产消费模式
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class ConsumerAndProducerTests {


   public static void main(String[] args) {

      Store store = new Store();
      Object object = new Object();
      Consumer consumer = new Consumer(object,store);
      Producer producer = new Producer(object,store);



      for (int i = 0; i < 50; i++) {
         Thread producerThread = new ProducerThread(producer);
         producerThread.setName("生产者"+i);
         producerThread.start();
      }

      for (int i = 0; i <50 ; i++) {
         Thread consumerThreada = new ConsumerThread(consumer);
         consumerThreada.setName("消费者A"+i);
         consumerThreada.setPriority(Thread.MAX_PRIORITY);
         consumerThreada.start();
      }

   }

}
