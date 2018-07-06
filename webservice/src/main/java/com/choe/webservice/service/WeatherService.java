package com.choe.webservice.service;

import com.choe.webservice.domain.Weather;

import javax.jws.WebService;

/**
 * @author cyk
 * @date 2018/7/6/006 10:27
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@WebService
public interface WeatherService {

    /**
     * 根据城市名称获取天气
     * @param name
     * @return
     */
    Weather getWeatherByName(String name);
}
