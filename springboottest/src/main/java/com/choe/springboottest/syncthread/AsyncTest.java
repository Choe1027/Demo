package com.choe.springboottest.syncthread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTest {


    @Async
    public void printDelay(String msg){

        try {
            Thread.sleep(10000);
            System.out.println("异步延迟打印："+msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
