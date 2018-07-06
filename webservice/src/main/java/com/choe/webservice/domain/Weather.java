package com.choe.webservice.domain;

import java.io.Serializable;

/**
 * @author cyk
 * @date 2018/7/6/006 10:28
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class Weather implements Serializable {

    // 城市名称
    private String cityName;
    // 温度
    private int temperature;
    // 描述
    private String describle;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle;
    }
}
