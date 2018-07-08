package com.choe.springboottest.config;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableScheduling
/***
 *   定时任务，这种定时任务，spring容器启动时就会进行扫描，然后并且自动执行，不需要手动开启
 *   但是这也像异步任务一样，需要开启对任务调度的支持，才能够使用定时任务
 * @EnableScheduling 开启任务调度
 * 在调度的方法上，使用Scheduled 注解来表名方法是调度方法，并在方法中可以配置参数
 */
public class ScheduleConfig {

}
