package com.sys.monitoring_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pageControl")
@Controller
public class pageController {

    @RequestMapping("index")
    public String getIndexPage(){
        return "index";
    }

    @RequestMapping("toRegister")
    public String getRegister(){
        return "register";
    }

}
