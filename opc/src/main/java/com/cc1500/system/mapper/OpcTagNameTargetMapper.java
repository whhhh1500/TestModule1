package com.cc1500.system.mapper;


import com.cc1500.system.entity.OpcTagNameTarget;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (OpcTagNameTarget)表数据库访问层
 *
 * @author makejava
 * @since 2019-11-14 11:04:15
 */
public interface OpcTagNameTargetMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param targetId 主键
     * @return 实例对象
     */
    OpcTagNameTarget queryById(Integer targetId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OpcTagNameTarget> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param opcTagNameTarget 实例对象
     * @return 对象列表
     */
    List<OpcTagNameTarget> queryAll(OpcTagNameTarget opcTagNameTarget);
    List<OpcTagNameTarget> queryAlltarget();

    /**
     * 新增数据
     *
     * @param opcTagNameTarget 实例对象
     * @return 影响行数
     */
    int insert(OpcTagNameTarget opcTagNameTarget);

    /**
     * 修改数据
     *
     * @param opcTagNameTarget 实例对象
     * @return 影响行数
     */
    int update(OpcTagNameTarget opcTagNameTarget);

    /**
     * 通过主键删除数据
     *
     * @param targetId 主键
     * @return 影响行数
     */
    int deleteById(Integer targetId);

}