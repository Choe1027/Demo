package com.choe.scheduler.tasks;

import com.choe.common.utils.DateUtil;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author cyk
 * @date 2018/7/5/005 14:51
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Component
public class AllTasks {

    /***
     *
     * @Scheduled(fixedRate=2000)：上一次开始执行时间点后2秒再次执行；
     *
     * @Scheduled(fixedDelay=2000)：上一次执行完毕时间点后2秒再次执行；
     *
     * @Scheduled(initialDelay=1000, fixedDelay=2000)：第一次延迟1秒执行，然后在上一次执行完毕时间点后2秒再次执行；
     *
     * @Scheduled(cron="* * * * * ?")：按cron规则执行。
     *
     *
     * 注意 必须在启动类上添加 @EnableScheduling 注解
     */

    @Scheduled(fixedRate = 5000)
    public void excutePer5Seconds(){
        System.out.println(DateUtil.getDateTime(DateUtil.DATE_FORMAT_4,System.currentTimeMillis())+"---excutePer5Seconds执行");
    }

    @Scheduled(cron = "0/20 * * * * ? ")
    public void excutCron(){
        System.out.println(DateUtil.getDateTime(DateUtil.DATE_FORMAT_4,System.currentTimeMillis())+"---excutCron执行");

    }

}
