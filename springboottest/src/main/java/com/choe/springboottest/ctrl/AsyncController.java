package com.choe.springboottest.ctrl;


import com.choe.springboottest.syncthread.AsyncTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AsyncController {

    @Autowired
    private AsyncTest asyncTest;

    @RequestMapping("/async")
    @ResponseBody
    public String testAsync(){
        System.out.println("主程序开启异步打印");
        asyncTest.printDelay("我是否在主程序后执行？");
        System.out.println("主程序继续执行");
        return "aysnc";
    }
}
