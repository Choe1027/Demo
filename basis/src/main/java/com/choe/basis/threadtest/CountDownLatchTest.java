package com.choe.basis.threadtest;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cyk
 * @date 2018/6/25/025 16:15
 * @email choe0227@163.com
 * @desc 闭锁测试
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Component
public class CountDownLatchTest {

    /** 以orderNo 作为key*/
    private static Map<String,CountDownLatch> orderMap = new ConcurrentHashMap<>();
    private ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    public void addCheck(String key){

       cachedThreadPool.execute(new Runnable() {
           @Override
           public void run() {
               // 请求到来，根据数量创建一个CountDownLatch对象
               CountDownLatch countDownLatch = new CountDownLatch(2);
               orderMap.put(key,countDownLatch);
               // 创建线程，推送给对应的质检
               try {
                   System.out.println(key+"等待质检员提交数据");
                   countDownLatch.await();
                   System.out.println(key+"质检完全响应之后，推送给A端用户");

               } catch (InterruptedException e) {
                   e.printStackTrace();
               }


           }
       });
    }

    public void countDown(String key){
        orderMap.get(key).countDown();
        System.out.println(key+"等待质检做出响应，响应一次，调用一次CountDown");
    }
}
