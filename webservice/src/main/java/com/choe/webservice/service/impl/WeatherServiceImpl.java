package com.choe.webservice.service.impl;

import com.choe.webservice.domain.Weather;
import com.choe.webservice.service.WeatherService;

import javax.jws.WebService;

/**
 * @author cyk
 * @date 2018/7/6/006 10:31
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
// targetNamespace 的值是类所在包名的逆序
@WebService(targetNamespace = "http://impl.service.webservice.choe.com/", endpointInterface = "com.choe.webservice.service.WeatherService")
public class WeatherServiceImpl implements WeatherService {

    @Override
    public Weather getWeatherByName(String name) {
        Weather weather = new Weather();
        if (name.equals("杭州")){
            weather.setCityName("杭州");
            weather.setDescrible("下班就给你憋一波大的");
            weather.setTemperature(35);
        }else if (name.equals("北京")){
            weather.setCityName("北京");
            weather.setDescrible("灰蒙蒙的一片");
            weather.setTemperature(33);
        }
        return weather;
    }
}
