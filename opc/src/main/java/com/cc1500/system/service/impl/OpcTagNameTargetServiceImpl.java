package com.cc1500.system.service.impl;

import com.cc1500.system.entity.OpcTagNameTarget;
import com.cc1500.system.mapper.OpcTagNameTargetMapper;
import com.cc1500.system.service.OpcTagNameTargetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OpcTagNameTarget)表服务实现类
 *
 * @author makejava
 * @since 2019-11-14 11:04:15
 */
@Service("opcTagNameTargetService")
public class OpcTagNameTargetServiceImpl implements OpcTagNameTargetService {
    @Resource
    private OpcTagNameTargetMapper opcTagNameTargetmapper;

    /**
     * 通过ID查询单条数据
     *
     * @param targetId 主键
     * @return 实例对象
     */
    @Override   
    public OpcTagNameTarget queryById(Integer targetId) {
        return this.opcTagNameTargetmapper.queryById(targetId);
    }
    /**
     * 通过实体作为筛选条件查询
     *
     * @param opcTagNameTarget 实例对象
     * @return 对象列表
     */
    @Override
    public List<OpcTagNameTarget> queryAll(OpcTagNameTarget opcTagNameTarget) {
        return this.opcTagNameTargetmapper.queryAll(opcTagNameTarget);
    }
    @Override
    public List<OpcTagNameTarget> queryAlltarget() {
        return this.opcTagNameTargetmapper.queryAlltarget();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<OpcTagNameTarget> queryAllByLimit(int offset, int limit) {
        return this.opcTagNameTargetmapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param opcTagNameTarget 实例对象
     * @return 实例对象
     */
    @Override
    public OpcTagNameTarget insert(OpcTagNameTarget opcTagNameTarget) {
        this.opcTagNameTargetmapper.insert(opcTagNameTarget);
        return opcTagNameTarget;
    }

    /**
     * 修改数据
     *
     * @param opcTagNameTarget 实例对象
     * @return 实例对象
     */
    @Override
    public OpcTagNameTarget update(OpcTagNameTarget opcTagNameTarget) {
        this.opcTagNameTargetmapper.update(opcTagNameTarget);
        return this.queryById(opcTagNameTarget.getTargetId());
    }

    /**
     * 通过主键删除数据
     *
     * @param targetId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer targetId) {
        return this.opcTagNameTargetmapper.deleteById(targetId) > 0;
    }
}