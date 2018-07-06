package com.choe.webservice;

import com.choe.webservice.domain.Weather;
import com.choe.webservice.service.WaterService;
import com.choe.webservice.service.WeatherService;
import com.choe.webservice.service.impl.WaterServiceImpl;
import com.choe.webservice.service.impl.WeatherServiceImpl;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

import javax.xml.ws.Endpoint;

@SpringBootApplication
public class WebserviceApplication {

    @Bean
    public ServletRegistrationBean servletRegistrationBean() { // 使用这样的方式不会拦截Controller请求
        ServletRegistrationBean bean = new ServletRegistrationBean(new CXFServlet(), "/test/*");
        bean.setLoadOnStartup(0);
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }



    @Bean
    public Weather dd(){
        Weather weather = new Weather();
        weather.setCityName("ddddd");
        return weather;
    }

    @Bean
    public Weather aa(){
        Weather weather = new Weather();
        weather.setCityName("aaa");
        return weather;
    }
    @Bean
    public WeatherService weatherService() {
        return new WeatherServiceImpl();
    }

    @Bean
    public WaterService waterService() {
        return new WaterServiceImpl();
    }


    @Bean
    public Endpoint weatherEndpoint() {
        // 注意这里导包别导错
        EndpointImpl endpoint = new EndpointImpl(springBus(),weatherService());
        endpoint.publish("/wetaher");
        return endpoint;
    }

    @Bean
    public Endpoint waterEndpoint() {
        // 注意这里导包别导错
        EndpointImpl endpoint = new EndpointImpl(springBus(),waterService());
        endpoint.publish("/water");
        return endpoint;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebserviceApplication.class, args);
    }
}
