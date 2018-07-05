package com.choe.webmvc.ctrl;

import com.choe.webmvc.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cyk
 * @date 2018/7/5/005 15:43
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@RequestMapping()
@Controller
public class LoginController {


    @RequestMapping("/login")
    public void login(HttpServletRequest request){
        request.getSession().setAttribute("user",new User());
        System.out.println("登录请求");
    }

    @RequestMapping("/toHome")
    public void toHome(){
        System.out.println("去主页");
    }
}
