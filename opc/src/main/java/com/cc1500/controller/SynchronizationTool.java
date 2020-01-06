package com.cc1500.controller;

import com.cc1500.system.service.OpcTagNameTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SynchronizationTool {
    @Autowired
    private OpcTagNameTargetService opcTagNameTargetService;

    public static SynchronizationTool tools=new SynchronizationTool();
    public SynchronizationTool() {
    }

    /**
     *
     */

    @PostConstruct
    public void init() {
        tools = this;
        tools.opcTagNameTargetService= this.opcTagNameTargetService;

    }

}
