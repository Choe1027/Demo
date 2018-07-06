package com.choe.webservice.ctrl;

import com.choe.webservice.domain.Weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cyk
 * @date 2018/7/6/006 13:49
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
*/
@Controller
@RestController
public class IndexController {

    @Autowired
    @Qualifier("aa")
    private Weather weather;

    @RequestMapping("/index")
    public String index(){
        System.out.println(weather.getCityName());
        return "index";
    }
}
