package com.cc1500.controller;

import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description (OpcItemInfo)表控制层
 * @author makejava
 * @since 2019-11-12 08:52:21
 */
@Controller
@RequestMapping("/filemg/file")
@ApiModel(description="用户的实体对象")
public class InfoController {

    private String PREFIX = "modular/filemq/";
    /** * 服务对象  */
    /**
     * @Description 通过主键查询单条数据
     * @return 单条数据
     */
    @ResponseBody
    @RequestMapping("/1")
    public String show() {
        System.out.println("hello");
        return "index";
    }

    @RequestMapping("/hello")
    public String index1() {
        System.out.println(PREFIX + "newfile.html");
        return PREFIX + "_newfile.html";
    }

}