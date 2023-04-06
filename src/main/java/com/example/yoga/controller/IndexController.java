package com.example.yoga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
