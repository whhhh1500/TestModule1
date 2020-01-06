package com.cc1500.system.service.impl;

import com.cc1500.system.entity.OpcItemInfo;
import com.cc1500.system.mapper.OpcItemInfoMapper;
import com.cc1500.system.service.OpcItemInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OpcItemInfo)表服务实现类
 *
 * @author makejava
 * @since 2019-11-12 08:52:21
 */
@Service("opcItemInfoService")
public class OpcItemInfoServiceImpl implements OpcItemInfoService {
    @Resource
    private OpcItemInfoMapper opcItemInfomapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override   
    public OpcItemInfo queryById(Integer id) {
        return this.opcItemInfomapper.queryById(id);
    }
    /**
     * 通过实体作为筛选条件查询
     *
     * @param opcItemInfo 实例对象
     * @return 对象列表
     */
    @Override
    public List<OpcItemInfo> queryAll(OpcItemInfo opcItemInfo) {
        return this.opcItemInfomapper.queryAll(opcItemInfo);
    }
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<OpcItemInfo> queryAllByLimit(int offset, int limit) {
        return this.opcItemInfomapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param opcItemInfo 实例对象
     * @return 实例对象
     */
    @Override
    public OpcItemInfo insert(OpcItemInfo opcItemInfo) {
        this.opcItemInfomapper.insert(opcItemInfo);
        return opcItemInfo;
    }
    @Override
    public int insertOr(OpcItemInfo opcItemInfo) {
        return  this.opcItemInfomapper.insert(opcItemInfo);
    }

    /**
     * 修改数据
     *
     * @param opcItemInfo 实例对象
     * @return 实例对象
     */
    @Override
    public OpcItemInfo update(OpcItemInfo opcItemInfo) {
        this.opcItemInfomapper.update(opcItemInfo);
        return this.queryById(opcItemInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.opcItemInfomapper.deleteById(id) > 0;
    }
}