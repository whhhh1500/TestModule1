package com.cc1500.system.service;


import com.cc1500.system.entity.OpcTagNameTarget;

import java.util.List;

/**
 * (OpcTagNameTarget)表服务接口
 *
 * @author makejava
 * @since 2019-11-14 11:04:15
 */
public interface OpcTagNameTargetService {
    /**
     * 通过ID查询单条数据
     *
     * @param targetId 主键
     * @return 实例对象
     */
    OpcTagNameTarget queryById(Integer targetId);
   /**
     * 通过实体作为筛选条件查询
     *
     * @param opcTagNameTarget 实例对象
     * @return 对象列表
     */
   List<OpcTagNameTarget> queryAll(OpcTagNameTarget opcTagNameTarget);
    List<OpcTagNameTarget> queryAlltarget();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OpcTagNameTarget> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param opcTagNameTarget 实例对象
     * @return 实例对象
     */
    OpcTagNameTarget insert(OpcTagNameTarget opcTagNameTarget);

    /**
     * 修改数据
     *
     * @param opcTagNameTarget 实例对象
     * @return 实例对象
     */
    OpcTagNameTarget update(OpcTagNameTarget opcTagNameTarget);

    /**
     * 通过主键删除数据
     *
     * @param targetId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer targetId);

}