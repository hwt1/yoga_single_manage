package com.example.yoga.controller.demotest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 黄雯婷
 * @version 1.0
 * @description: 首页controller
 * @date 2023-04-06 14:13:26
 **/
@RequestMapping("/index")
@Controller
public class IndexController {

    @RequestMapping("/jsp")
    public String hello(){
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "sessiontest/login";
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = new Cookie("hwt", "hello");
        response.addCookie(cookie);
        // 会自动生成一个session对象，并把 JsessionId放入cookie中
        HttpSession session = request.getSession();
        session.setAttribute("myUseId","123456");
        return "sessiontest/show";
    }
}
