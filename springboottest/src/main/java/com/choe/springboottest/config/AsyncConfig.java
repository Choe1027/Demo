package com.choe.springboottest.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 说明
 * 注解异步任务，可以通过TaskExecutor来实现
 * 在方法，或者类上添加@Async注解来标明该方法或者该类的所有方法都是异步的。
 * 但是需要通过@EnableAsync 注解来开启允许异步任务
 * 同时需要手动创建一个Executor，给Spring容器进行管理，让所有的异步任务都依赖于TaskExecutor来执行
 */
@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean
    public Executor asyncExecutor(){ // 注入TaskExecutor
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(10);
        executor.initialize();
        return executor;
    }
}
