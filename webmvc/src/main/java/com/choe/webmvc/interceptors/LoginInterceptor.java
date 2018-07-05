package com.choe.webmvc.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cyk
 * @date 2018/7/5/005 15:32
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    // 请求前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("=========preHandle==========");
        if (!request.getRequestURL().toString().contains("login")){
            Object user = request.getSession().getAttribute("user");
            if (user == null){
                System.out.println("未登录,拦截请求");
                return false;
            }
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    // 处理请求
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("=========postHandle==========");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    // 处理请求后后
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("=========afterCompletion==========");
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
