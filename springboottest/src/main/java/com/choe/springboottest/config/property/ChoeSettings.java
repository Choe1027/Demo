package com.choe.springboottest.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author cyk
 * @date 2018/7/5/005 16:59
 * @email choe0227@163.com
 * @desc 通用的properties 配置属性值， 这种方式的好处，避免在多处重复需要获取该值时，都通过@Value注解来获取
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Component
@ConfigurationProperties(prefix = "choe") //获取properties 文件中,以choe为前缀的配置,只读取application.properties文件中
public class ChoeSettings {

    // 与properties文件中的名称对应
    private String name;
    private Integer age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
