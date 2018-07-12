package com.choe.springboottest.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @author cyk
 * @date 2018/7/11/011 10:34
 * @email choe0227@163.com
 * @desc 文件上传配置
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Configuration
public class FileUploadConfig {


    /** 文件上传配置  */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize("20MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("20MB");
//        factory.set
        return factory.createMultipartConfig();
    }
}
