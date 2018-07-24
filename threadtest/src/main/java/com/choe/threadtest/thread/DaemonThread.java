package com.choe.threadtest.thread;

/**
 * @author cyk
 * @date 2018/7/23/023 11:04
 * @email choe0227@163.com
 * @desc 守护线程
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class DaemonThread extends Thread{

    private int i = 0 ;

    @Override
    public void run() {
        super.run();

        while (true ){
            try {
                System.out.println("守护线程running"+ i);
                Thread.sleep(1000);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
