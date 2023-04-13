package com.example.yoga.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author 黄雯婷
 * @version 1.0
 * @description: 监听 request、session、application的创建和销毁
 * 分别对应的监听接口：ServletRequestListener、HttpSessionListener、ServletContextListener
 * 第一次在浏览器输入：http://localhost:8090/index/toLogin 回车会触发：
 * 监听request的初始化....
 *      MyFilter拦截前....
 *      MyFilter2拦截前....
 * 监听session的初始化....
 *      MyFilter2拦截后....
 *      MyFilter拦截后....
 * 监听request的销毁....
 *
 * 再次回车：不会再触发session的初始化
 * 监听request的初始化....
 *      MyFilter拦截前....
 *      MyFilter2拦截前....
 *      MyFilter2拦截后....
 *      MyFilter拦截后....
 * 监听request的销毁....
 * @date 2023-04-11 11:24:39
 **/
@WebListener("myListener")
public class RequestSessionApplicationListener implements ServletRequestListener, HttpSessionListener, ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /**
         * tomcat启动的时候执行
         */
        System.out.println("监听application的初始化....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听application的销毁....");
    }
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        /**
         * 在浏览器发起请求时执行
         */
        System.out.println("监听request的初始化....");
    }
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        /**
         * 在浏览器发起请求得到响应结果后执行
         */
        System.out.println("监听request的销毁....");
    }



    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("监听session的初始化....");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("监听session的销毁....");
    }
}
