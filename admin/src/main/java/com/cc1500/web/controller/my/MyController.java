package com.cc1500.web.controller.my;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @ResponseBody
    @GetMapping ("/ss")
    public String show() {
        System.out.println("hello");
        return "index";
    }
}
