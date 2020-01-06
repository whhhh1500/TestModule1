package com.cc1500.controller;

import com.cc1500.system.entity.OpcTagNameTarget;
import com.cc1500.system.service.OpcTagNameTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class SynchronizationTool {
    @Autowired
    private OpcTagNameTargetService opcTagNameTargetService;

    public static SynchronizationTool tools=new SynchronizationTool();  // 关键2
    public SynchronizationTool() {
    }
    // 3
    @PostConstruct
    public void init() {
        tools = this;
        tools.opcTagNameTargetService= this.opcTagNameTargetService;

    }
    public static List<String> queryAlltarget(){
        List<OpcTagNameTarget> targets = tools.opcTagNameTargetService.queryAlltarget();
        List<String> strings = new ArrayList<>();
        for (OpcTagNameTarget s : targets) {
            strings.add( s.getTarget() );
        }
        return strings;
    }
}
