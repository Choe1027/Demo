package com.choe.webservice.ws;

import com.choe.webservice.domain.Weather;
import com.choe.webservice.service.WeatherService;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * @author cyk
 * @date 2018/7/6/006 11:09
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class WSClient {


    public static void main(String [] args){
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setAddress("http://localhost:8080/test/wetaher?wsdl");
        jaxWsProxyFactoryBean.setServiceClass(WeatherService.class);
        WeatherService weatherService=(WeatherService)jaxWsProxyFactoryBean.create();
        Weather weather = weatherService.getWeatherByName("北京");
        System.out.println(weather);
    }
}
