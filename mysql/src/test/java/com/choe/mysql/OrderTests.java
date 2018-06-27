package com.choe.mysql;

import com.choe.mysql.service.OrderService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTests {


    @Autowired
    private OrderService orderService;


    @Test
    public void transOrder(){
        orderService.transOrder();
    }
}
