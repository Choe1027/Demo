package com.choe.aop.aop;

import com.choe.aop.constant.CallEnum;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cyk
 * @date 2018/6/19/019 14:44
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */

@Aspect
@Component
// 需要切面注解为一个类 同时还需要注解 让spring进行管理
public class StudentAop {

    /** 用来保存结果集*/
    public static ThreadLocal<String> resultPool = new ThreadLocal<>();

//    @Around("execution(* com.choe.aop.ctrl..*.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        Integer call = null;

        // 获取参数数组
        Object[] args = proceedingJoinPoint.getArgs();

        // 判断参数
        for (Object obj : args){

            if (obj instanceof HttpServletRequest){
                request = (HttpServletRequest) obj;
            }else if (obj instanceof  HttpServletResponse){
                response = (HttpServletResponse) obj;
            } else if (obj instanceof Integer){
                call = (Integer) obj;
            }
        }

        String callRemark ="";
        if (call != null && !call.equals(0)){
            callRemark = CallEnum.forCode(call);
            if (StringUtils.isEmpty(callRemark)){
                callRemark = "端口号:"+call + "  remark:未知请求";
            }else {
                callRemark ="端口号:"+call + "  remark:" +callRemark;
            }
        }else {
            call = 0;
            callRemark = "端口号:"+call + "  remark:未知请求";
        }
        // 服务不存在的情况直接拦截掉，通过拦截器或者基类
        System.out.println("============="+callRemark +"开始=============");
        Object proceed = null;
        try {
            if (proceedingJoinPoint != null){
                proceed = proceedingJoinPoint.proceed();
            }
            // 获取结果集,结果集需要手动设置进来
            String result = resultPool.get();
            if (result == null ){
                result = "";
            }
            System.out.println("result:" + result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("============="+callRemark +"结束=============");
        System.out.println("");
        return proceed;
    }


    @Before("execution(* com.choe.aop.ctrl..*.*(..))")
    // 前置通知没有ProceedingJoinPoint
    public void before(JoinPoint joinPoint){

        System.out.println("前置通知");
        Object[] args = joinPoint.getArgs();

        Integer call = null;
        // 判断参数
        for (Object obj : args){
            if (obj instanceof Integer){
                obj = 10000;
            }
        }

        String json = "{  \"supplier_id\" : \"741\",  \"amount\" : 2,  \"subOrders\" : [    {      \"category_type_id\" : \"1\",      \"weight\" : \"1.00\",      \"total_price\" : \"2.00\",      \"unit_price\" : \"2.00\"    }  ],  \"discounted_amount\" : \"38.43\"}\n";
    }

}
