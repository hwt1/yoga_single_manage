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

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "test/register";
    }

    @RequestMapping("/toParamListener")
    public String toParamListener(){
        return "test/paramListener";
    }

    @RequestMapping("/toTagTest")
    public String toTagTest(HttpServletRequest request,HttpServletResponse response){
        request.setAttribute("name","hello");
        /*
            getAttribute()一向是和setAttribute()一起使用的，只有先用setAttribute()设置之后，才能够通过getAttribute()来获得值，它们传递的是Object类型的数据。而且必须在同一个request对象中使用才有效。,而getParameter()是接收表单的get或者  post提交过来的参数，可用于jsp页面之间的跳转取值，但是不能用于这种情况：
            jsp表单（uname）——》controller（getParameter 能取到uname值）——》jsp （getParameter 无法取到uname值）
         */
        return "test/tagTest";
    }

    @RequestMapping("/toTagShow")
    public String tagShow(HttpServletRequest request,HttpServletResponse response){
        //request.getRequestDispatcher("test/tagShow").forward(request,response);
        request.setAttribute("uname",request.getParameter("uname"));
        String[] hobbies = {"篮球","羽毛球","piano"};
        request.setAttribute("hobbies",hobbies);
        return "test/tagShow";
    }

}
