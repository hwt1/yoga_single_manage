package com.example.yoga.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄雯婷
 * @version 1.0
 * @description: 自定义过滤器
 * 关于多个过滤器的执行顺序，由于 @WebFilter 没有指定顺序的属性，目前通过测试发现会根据 类名的字母排序顺序来决定过滤器的执行顺序
 * @date 2023-04-11 10:31:17
 **/
@WebFilter(filterName = "myFilter",urlPatterns = "/*")// 拦截所有请求
public class MyFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter拦截前....");
        super.doFilter(request, response, chain);
        System.out.println("MyFilter拦截后....");
        /**
         * MyFilter拦截前....
         * MyFilter2拦截前....
         * MyFilter2拦截后....
         * MyFilter拦截后....
         */
    }
}
