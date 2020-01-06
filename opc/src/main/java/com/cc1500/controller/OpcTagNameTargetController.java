package com.cc1500.controller;


import com.cc1500.system.entity.OpcTagNameTarget;
import com.cc1500.system.service.OpcTagNameTargetService;
import com.cc1500.web.Result.ResultVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description (OpcTagNameTarget)表控制层
 * @author makejava
 * @since 2019-11-14 11:04:15
 */
@RestController
@RequestMapping("/eCAgetway/OpcTagNameTarget")
public class OpcTagNameTargetController {
    /** * 服务对象  */
    @Resource
    private OpcTagNameTargetService opcTagNameTargetService;
    /**
     * @Description 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public String selectOne(Integer id) {
        OpcTagNameTarget obj= this.opcTagNameTargetService.queryById(id);
        if(obj!=null){
            return ResultVo.success("查询成功", 0,  obj);
        }
        return ResultVo.error("查询失败", 500, null);
    }
    
    /**
     * @Description 通过实体作为筛选条件查询
     * @param opcTagNameTarget 实例对象
     * @return 对象列表
     */
    @GetMapping("/queryAll")
    public String queryAll(OpcTagNameTarget opcTagNameTarget) {
        List<OpcTagNameTarget> list=this.opcTagNameTargetService.queryAll(opcTagNameTarget);
        if(list!=null){
            return ResultVo.success("查询list成功", 0,  list);
        }
        return ResultVo.error("查询list失败", 500, null);
     }
     /**
     * @Description insert
     * @param opcTagNameTarget 
     * @return 单条数据
     */
    @PostMapping("/insert")
    public String insert(OpcTagNameTarget opcTagNameTarget) {
        OpcTagNameTarget obj= this.opcTagNameTargetService.insert(opcTagNameTarget);
        if(obj!=null){
            return ResultVo.success("添加成功", 0,  obj);
        }
        return ResultVo.error("添加失败", 500, null);
  }
     /**
     * @Description  update
     * @param opcTagNameTarget
     * @return 单条数据
     */
    @PutMapping("/update")
    public String update(OpcTagNameTarget opcTagNameTarget) {
        OpcTagNameTarget obj= this.opcTagNameTargetService.update(opcTagNameTarget);
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
        boolean obj=this.opcTagNameTargetService.deleteById(id);
        if(obj){
            return ResultVo.success("删除成功", 0,obj);
        }
        return ResultVo.error("删除失败", 500, null);
   }  
}