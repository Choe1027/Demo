package com.choe.basis.ctrl;

import com.choe.basis.threadtest.CountDownLatchTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cyk
 * @date 2018/6/25/025 16:38
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Controller
@RequestMapping
public class CountDownLatchCtrl {

    @Autowired
    private CountDownLatchTest downLatchTest;

    @RequestMapping("/testCountDownLatch")
    public void testCountDownLatch(HttpServletRequest request, HttpServletResponse response, Integer call,String key){

        switch (call){

            case 0:{
                downLatchTest.addCheck(key);
                break;
            }
            case 1:{
                downLatchTest.countDown(key);
                break;
            }

            case 2:{
                CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(10000);
                            System.out.println("======第一个线程正在执行====");
                            cyclicBarrier.await();
                            System.out.println("======第1个线程跟大家一起执行===="+System.currentTimeMillis());
                            downLatchTest.countDown(key);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                            System.out.println("======第2个线程正在执行====");
                            cyclicBarrier.await();
                            System.out.println("======第2个线程跟大家一起执行===="+System.currentTimeMillis());
                            downLatchTest.countDown(key);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            }
        }

    }


}
