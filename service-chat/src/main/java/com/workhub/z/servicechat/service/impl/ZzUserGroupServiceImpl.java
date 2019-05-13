package com.workhub.z.servicechat.service.impl;

import com.workhub.z.servicechat.entity.ZzUserGroup;
import com.workhub.z.servicechat.dao.ZzUserGroupDao;
import com.workhub.z.servicechat.service.ZzUserGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户群组映射表(ZzUserGroup)表服务实现类
 *
 * @author 忠
 * @since 2019-05-10 14:22:54
 */
@Service("zzUserGroupService")
public class ZzUserGroupServiceImpl implements ZzUserGroupService {
    @Resource
    private ZzUserGroupDao zzUserGroupDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ZzUserGroup queryById(String id) {
        return this.zzUserGroupDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ZzUserGroup> queryAllByLimit(int offset, int limit) {
        return this.zzUserGroupDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param zzUserGroup 实例对象
     * @return 实例对象
     */
    @Override
    public ZzUserGroup insert(ZzUserGroup zzUserGroup) {
        this.zzUserGroupDao.insert(zzUserGroup);
        return zzUserGroup;
    }

    /**
     * 修改数据
     *
     * @param zzUserGroup 实例对象
     * @return 实例对象
     */
    @Override
    public ZzUserGroup update(ZzUserGroup zzUserGroup) {
        this.zzUserGroupDao.update(zzUserGroup);
        return this.queryById(zzUserGroup.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.zzUserGroupDao.deleteById(id) > 0;
    }
}