package com.cc1500.web.controller.my;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @ResponseBody
    @RequestMapping("/")
    public String show() {
        System.out.println("hello");
        return "index";
    }
}
