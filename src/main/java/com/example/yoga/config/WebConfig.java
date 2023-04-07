package com.example.yoga.config;


import com.example.yoga.servlets.MyServlet2;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 黄雯婷
 * @version 1.0
 * @description: web 配置类
 * @date 2023-04-06 17:33:18
 **/
@Configuration
public class WebConfig {
    //注册Servlet组件

    /**
     * 将自定义servlet注册到spring容器的【方式二】：
     * 采用 ServletRegistrationBean 来注册自定义 Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet2(),"/myServlet2");
        return registrationBean;
    }

}
