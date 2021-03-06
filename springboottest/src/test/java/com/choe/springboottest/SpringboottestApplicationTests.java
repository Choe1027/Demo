package com.choe.springboottest;

import com.choe.springboottest.config.PropertyConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringboottestApplicationTests {

    @Autowired
    private PropertyConfig choeSettings;


    @Test
    public void contextLoads() {
        System.out.println("name "+choeSettings.getName() + "+===age ="+ choeSettings.getAge() +"==address="+choeSettings.getAddress());
    }

}
