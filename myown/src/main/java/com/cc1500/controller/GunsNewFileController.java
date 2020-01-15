package com.cc1500.controller;

import com.cc1500.system.entity.GunsNewFile;
import com.cc1500.system.service.GunsNewFileService;
import com.cc1500.web.Result.ResultVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description (GunsNewFile)表控制层
 * @author makejava
 * @since 2020-01-14 15:22:28
 */
@RestController
@RequestMapping("/filemg/file")
public class GunsNewFileController {
    /** * 服务对象  */
    @Resource
    private GunsNewFileService gunsNewFileService;

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


    /**
     * @Description 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOnefile")
    public String selectOne(Integer id) {
        GunsNewFile obj= this.gunsNewFileService.queryById(id);
        if(obj!=null){
            return ResultVo.success("查询成功", 0,  obj);
        }
        return ResultVo.error("查询失败", 500, null);
    }
    
    /**
     * @Description 通过实体作为筛选条件查询
     * @param gunsNewFile 实例对象
     * @return 对象列表
     */
    @GetMapping("/queryAllfile")
    public String queryAll(GunsNewFile gunsNewFile) {
        List<GunsNewFile> list=this.gunsNewFileService.queryAll(gunsNewFile);
        if(list!=null){
            return ResultVo.success("查询list成功", 0,  list);
        }
        return ResultVo.error("查询list失败", 500, null);
     }
     /**
     * @Description insert
     * @param gunsNewFile 
     * @return 单条数据
     */
    @PostMapping("/insertfile")
    public String insert(GunsNewFile gunsNewFile) {
        GunsNewFile obj= this.gunsNewFileService.insert(gunsNewFile);
        if(obj!=null){
            return ResultVo.success("添加成功", 0,  obj);
        }
        return ResultVo.error("添加失败", 500, null);
  }
     /**
     * @Description  update
     * @param gunsNewFile
     * @return 单条数据
     */
    @PutMapping("/updatefile")
    public String update(GunsNewFile gunsNewFile) {
        GunsNewFile obj= this.gunsNewFileService.update(gunsNewFile);
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
    @PostMapping("/deleteByIdfile")
    public String DeleteMapping(Integer id) {
        boolean obj=this.gunsNewFileService.deleteById(id);
        if(obj){
            return ResultVo.success("删除成功", 0,obj);
        }
        return ResultVo.error("删除失败", 500, null);
   }  
}