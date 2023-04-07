package com.example.yoga.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 将自定义servlet注册到spring容器的【方式一】：
 * 采用 @WebServlet 注册自定义servlet
 */
@WebServlet(name = "MyServlet2", value = "/MyServlet2")
public class MyServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyServlet2 doGet....");
        request.getRequestDispatcher("/jsp/sessiontest/show.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyServlet2 doPost....");
    }
}
