package com.choe.mysql;

import com.example.shyFly.easySql.EasySqlExecution;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = "com")
@Configuration
@MapperScan(basePackages = {"com.choe.mysql.dao"})
public class MysqlApplication {
    @Autowired
    private EasySqlExecution easySqlExecution;


    public static void main(String[] args) {
        SpringApplication.run(MysqlApplication.class, args);
    }

//    @PostConstruct
//    private void testImport(){
//        Student2 s = new Student2();
//        List<Student2> select = easySqlExecution.select(s);
//        System.out.println(select.size());
//
//    }
}
