package com.workhub.z.servicechat.service.impl;

import com.github.hollykunge.security.common.biz.BaseBiz;
import com.workhub.z.servicechat.entity.ZzMsgTabInfo;
import com.workhub.z.servicechat.dao.ZzMsgTabInfoDao;
import com.workhub.z.servicechat.service.ZzMsgTabInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 消息标记信息表(ZzMsgTabInfo)表服务实现类
 *
 * @author makejava
 * @since 2019-05-23 16:46:13
 */
@Service("zzMsgTabInfoService")
public class ZzMsgTabInfoServiceImpl extends BaseBiz<ZzMsgTabInfoDao, ZzMsgTabInfo> implements ZzMsgTabInfoService {
    @Resource
    private ZzMsgTabInfoDao zzMsgTabInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ZzMsgTabInfo queryById(String id) {
        return this.zzMsgTabInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ZzMsgTabInfo> queryAllByLimit(int offset, int limit) {
        return this.zzMsgTabInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param zzMsgTabInfo 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(ZzMsgTabInfo zzMsgTabInfo) {
        int insert = this.zzMsgTabInfoDao.insert(zzMsgTabInfo);
//        return insert;
    }

    @Override
    protected String getPageName() {
        return null;
    }

    /**
     * 修改数据
     *
     * @param zzMsgTabInfo 实例对象
     * @return 实例对象
     */
    @Override
    public ZzMsgTabInfo update(ZzMsgTabInfo zzMsgTabInfo) {
        this.zzMsgTabInfoDao.update(zzMsgTabInfo);
        return this.queryById(zzMsgTabInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.zzMsgTabInfoDao.deleteById(id) > 0;
    }
}