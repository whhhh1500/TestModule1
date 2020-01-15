package com.cc1500.system.service.impl;

import com.cc1500.system.entity.GunsNewFile;
import com.cc1500.system.mapper.GunsNewFileMapper;
import com.cc1500.system.service.GunsNewFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (GunsNewFile)表服务实现类
 *
 * @author makejava
 * @since 2020-01-14 15:22:28
 */
@Service("gunsNewFileService")
public class GunsNewFileServiceImpl implements GunsNewFileService {
    @Resource
    private GunsNewFileMapper gunsNewFilemapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override   
    public GunsNewFile queryById(Integer id) {
        return this.gunsNewFilemapper.queryById(id);
    }
    /**
     * 通过实体作为筛选条件查询
     *
     * @param gunsNewFile 实例对象
     * @return 对象列表
     */
    @Override
    public List<GunsNewFile> queryAll(GunsNewFile gunsNewFile) {
        return this.gunsNewFilemapper.queryAll(gunsNewFile);
    }
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<GunsNewFile> queryAllByLimit(int offset, int limit) {
        return this.gunsNewFilemapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param gunsNewFile 实例对象
     * @return 实例对象
     */
    @Override
    public GunsNewFile insert(GunsNewFile gunsNewFile) {
        this.gunsNewFilemapper.insert(gunsNewFile);
        return gunsNewFile;
    }

    /**
     * 修改数据
     *
     * @param gunsNewFile 实例对象
     * @return 实例对象
     */
    @Override
    public GunsNewFile update(GunsNewFile gunsNewFile) {
        this.gunsNewFilemapper.update(gunsNewFile);
        return this.queryById(gunsNewFile.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.gunsNewFilemapper.deleteById(id) > 0;
    }
}