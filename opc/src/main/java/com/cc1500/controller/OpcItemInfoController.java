package com.cc1500.controller;

import com.cc1500.system.service.OpcItemInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description (OpcItemInfo)表控制层
 * @author makejava
 * @since 2019-11-12 08:52:21
 */
@RestController
public class OpcItemInfoController {
    /** * 服务对象  */
    @Resource
    private OpcItemInfoService opcItemInfoService;
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

}