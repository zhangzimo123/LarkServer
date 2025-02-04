package com.workhub.z.servicechat.service;

import com.workhub.z.servicechat.entity.ZzPrivateMsg;
import java.util.List;

/**
 * 私人消息(ZzPrivateMsg)表服务接口
 *
 * @author 忠
 * @since 2019-05-13 10:57:46
 */
public interface ZzPrivateMsgService {

    /**
     * 通过ID查询单条数据
     *
     * @param msgId 主键
     * @return 实例对象
     */
    ZzPrivateMsg queryById(String msgId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ZzPrivateMsg> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param zzPrivateMsg 实例对象
     * @return 实例对象
     */
    void insert(ZzPrivateMsg zzPrivateMsg);

    /**
     * 修改数据
     *
     * @param zzPrivateMsg 实例对象
     * @return 实例对象
     */
    Integer update(ZzPrivateMsg zzPrivateMsg);

    /**
     * 通过主键删除数据
     *
     * @param msgId 主键
     * @return 是否成功
     */
    boolean deleteById(String msgId);

    // TODO: 2019/5/15 msgSender msgReceiver查询消息列表

    // TODO: 2019/5/15 根据 msgSender msgReceiver更新未读消息isRead

    // TODO: 2019/5/15  

}