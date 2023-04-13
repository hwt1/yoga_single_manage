package com.example.yoga.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author 黄雯婷
 * @version 1.0
 * @description: 监听 request、session、application 中值的存入存出
 * 包括架构层面，spring包中的设值也会被监听打印出来
 * @date 2023-04-13 09:36:24
 **/
@WebListener("myParamListener")
public class RequestSessionApplicationParamListener implements ServletRequestAttributeListener, HttpSessionAttributeListener, ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        String name = scae.getName(); // 正在操作的属性名
        Object value = scae.getServletContext().getAttribute(name);
        // scae.getServletContext() 得到的是application容器
        System.out.println("ServletContext 【增加】的属性，属性名："+name+"，值："+value);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        String name = scae.getName(); // 正在操作的属性名
        Object value = scae.getServletContext().getAttribute(name);
        // scae.getServletContext() 得到的是application容器
        System.out.println("ServletContext 【删除】的属性，属性名："+name+"，值："+value);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        String name = scae.getName(); // 正在操作的属性名
        Object value = scae.getServletContext().getAttribute(name);
        // scae.getServletContext() 得到的是application容器
        System.out.println("ServletContext 【替换】的属性，属性名："+name+"，值："+value);
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        String name = srae.getName(); // 正在操作的属性名
        Object value = srae.getServletRequest().getAttribute(name);
        // scae.getServletContext() 得到的是application容器
        System.out.println("ServletRequest 【增加】的属性，属性名："+name+"，值："+value);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        String name = srae.getName(); // 正在操作的属性名
        Object value = srae.getServletRequest().getAttribute(name);
        // scae.getServletContext() 得到的是application容器
        System.out.println("ServletRequest 【删除】的属性，属性名："+name+"，值："+value);
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        String name = srae.getName(); // 正在操作的属性名
        Object value = srae.getServletRequest().getAttribute(name);
        // scae.getServletContext() 得到的是application容器
        System.out.println("ServletRequest 【替换】的属性，属性名："+name+"，值："+value);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        String name = se.getName(); // 正在操作的属性名
        Object value = se.getSession().getAttribute(name);
        // scae.getServletContext() 得到的是application容器
        System.out.println("HttpSession 【增加】的属性，属性名："+name+"，值："+value);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        String name = se.getName(); // 正在操作的属性名
        Object value = se.getSession().getAttribute(name);
        // scae.getServletContext() 得到的是application容器
        System.out.println("HttpSession 【删除】的属性，属性名："+name+"，值："+value);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        String name = se.getName(); // 正在操作的属性名
        Object value = se.getSession().getAttribute(name);
        // scae.getServletContext() 得到的是application容器
        System.out.println("HttpSession 【替换】的属性，属性名："+name+"，值："+value);
    }
}
