package com.cc1500.system.mapper;

import com.cc1500.system.entity.OpcItemInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (OpcItemInfo)表数据库访问层
 *
 * @author makejava
 * @since 2019-11-12 08:52:21
 */
public interface OpcItemInfoMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OpcItemInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OpcItemInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param opcItemInfo 实例对象
     * @return 对象列表
     */
    List<OpcItemInfo> queryAll(OpcItemInfo opcItemInfo);

    /**
     * 新增数据
     *
     * @param opcItemInfo 实例对象
     * @return 影响行数
     */
    int insert(OpcItemInfo opcItemInfo);
    int insertOr(OpcItemInfo opcItemInfo);

    /**
     * 修改数据
     *
     * @param opcItemInfo 实例对象
     * @return 影响行数
     */
    int update(OpcItemInfo opcItemInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}