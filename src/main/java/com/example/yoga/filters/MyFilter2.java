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
 * @date 2023-04-11 10:31:17
 **/
@WebFilter(filterName = "myFilter2",urlPatterns = "/*")
public class MyFilter2 extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter2拦截前....");
        super.doFilter(request, response, chain);
        System.out.println("MyFilter2拦截后....");
    }
}
