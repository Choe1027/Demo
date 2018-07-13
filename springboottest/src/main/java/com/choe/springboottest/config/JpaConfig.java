package com.choe.springboottest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author cyk
 * @date 2018/7/13/013 11:41
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Configuration
@EnableJpaRepositories("com.choe.springboottest.jpa")
public class JpaConfig {

}
