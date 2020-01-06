package com.cc1500.system.service;


import com.cc1500.system.entity.OpcItemInfo;

import java.util.List;

/**
 * (OpcItemInfo)表服务接口
 *
 * @author makejava
 * @since 2019-11-12 08:52:21
 */
public interface OpcItemInfoService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OpcItemInfo queryById(Integer id);
   /**
     * 通过实体作为筛选条件查询
     *
     * @param opcItemInfo 实例对象
     * @return 对象列表
     */
      List<OpcItemInfo> queryAll(OpcItemInfo opcItemInfo);
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OpcItemInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param opcItemInfo 实例对象
     * @return 实例对象
     */
    OpcItemInfo insert(OpcItemInfo opcItemInfo);
    int insertOr(OpcItemInfo opcItemInfo);

    /**
     * 修改数据
     *
     * @param opcItemInfo 实例对象
     * @return 实例对象
     */
    OpcItemInfo update(OpcItemInfo opcItemInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}