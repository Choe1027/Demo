package com.choe.springboottest.config;

import com.choe.springboottest.condition.LinuxContion;
import com.choe.springboottest.condition.WindowsCondition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 * 根据自定义的config来加载对象
 *  自定义的Conditon对象必须是实现Condition接口
 *  在使用的时，需要通过@Condional接口来引入
 */
public class ConditionConfig {

    @Conditional(WindowsCondition.class)
    @Bean
    public Object windowsCondition(){

        System.out.println("Windows...condition");
        return  "windows";
    }

    @Conditional(LinuxContion.class)
    @Bean
    public Object linuxCondition(){

        System.out.println("linux...condition");
        return  "linux";
    }
}
