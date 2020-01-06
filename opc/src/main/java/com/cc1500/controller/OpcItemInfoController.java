package com.cc1500.controller;

import com.cc1500.system.entity.OpcItemInfo;
import com.cc1500.system.service.OpcItemInfoService;
import com.cc1500.web.Result.ResultVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description (OpcItemInfo)表控制层
 * @author makejava
 * @since 2019-11-12 08:52:21
 */
@RestController
//@RequestMapping("/OpcItemInfo")
public class OpcItemInfoController {
    /** * 服务对象  */
    @Resource
    private OpcItemInfoService opcItemInfoService;
    /**
     * @Description 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @ResponseBody
    @RequestMapping("/1")
    public String show() {
        System.out.println("hello");
        return "index";
    }


    @GetMapping("/selectOne")
    public String selectOne(Integer id) {
        OpcItemInfo obj= this.opcItemInfoService.queryById(id);
        if(obj!=null){
            System.out.println(obj.toString());
            return ResultVo.success("查询成功", 0,  obj);
        }
        return ResultVo.error("查询失败", 500, null);
    }
    
    /**
     * @Description 通过实体作为筛选条件查询
     * @param opcItemInfo 实例对象
     * @return 对象列表
     */
    @GetMapping("/queryAll")
    public String queryAll(OpcItemInfo opcItemInfo) {
        List<OpcItemInfo> list=this.opcItemInfoService.queryAll(opcItemInfo);
        if(list!=null){
            return ResultVo.success("查询list成功", 0,  list);
        }
        return ResultVo.error("查询list失败", 500, null);
     }
     /**
     * @Description insert
     * @param opcItemInfo 
     * @return 单条数据
     */
    @PostMapping("/insert")
    public String insert(OpcItemInfo opcItemInfo) {
        OpcItemInfo obj= this.opcItemInfoService.insert(opcItemInfo);
        if(obj!=null){
            return ResultVo.success("添加成功", 0,  obj);
        }
        return ResultVo.error("添加失败", 500, null);
  }
    @PostMapping("/insertOr")
    public String insertOr(OpcItemInfo opcItemInfo) {
        int  obj=0;
                obj= this.opcItemInfoService.insertOr(opcItemInfo);
        if(obj>0){
            return ResultVo.success("添加成功", 0,  null);
        }
        return ResultVo.error("添加失败", 500, null);
    }
     /**
     * @Description  update
     * @param opcItemInfo
     * @return 单条数据
     */
    @PutMapping("/update")
    public String update(OpcItemInfo opcItemInfo) {
        OpcItemInfo obj= this.opcItemInfoService.update(opcItemInfo);
        if(obj!=null){
            return ResultVo.success("更新成功", 0,  obj);
        }
        return ResultVo.error("更新失败", 500, null);
    }
      /**
     * @Description delete
     * @param id
     * @return 单条数据
     */
    @PostMapping("/deleteById")
    public String DeleteMapping(Integer id) {
        boolean obj=this.opcItemInfoService.deleteById(id);
        if(obj){
            return ResultVo.success("删除成功", 0,obj);
        }
        return ResultVo.error("删除失败", 500, null);
   }  
}