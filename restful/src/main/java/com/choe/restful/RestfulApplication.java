package com.choe.restful;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(basePackages = {"com.choe.restful.dao"})
public class RestfulApplication {


    public static void main(String[] args) {
        SpringApplication.run(RestfulApplication.class, args);
    }
}
