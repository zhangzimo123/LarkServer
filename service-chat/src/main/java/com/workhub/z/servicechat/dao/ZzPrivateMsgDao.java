package com.workhub.z.servicechat.dao;

import com.workhub.z.servicechat.entity.ZzPrivateMsg;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 私人消息(ZzPrivateMsg)表数据库访问层
 *
 * @author 忠
 * @since 2019-05-13 10:57:46
 */
public interface ZzPrivateMsgDao extends Mapper<ZzPrivateMsg> {

    /**
     * 通过ID查询单条数据
     *
     * @param msgId 主键
     * @return 实例对象
     */
    ZzPrivateMsg queryById(String msgId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ZzPrivateMsg> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param zzPrivateMsg 实例对象
     * @return 对象列表
     */
    List<ZzPrivateMsg> queryAll(ZzPrivateMsg zzPrivateMsg);

    /**
     * 新增数据
     *
     * @param zzPrivateMsg 实例对象
     * @return 影响行数
     */
    int insert(ZzPrivateMsg zzPrivateMsg);

    /**
     * 修改数据
     *
     * @param zzPrivateMsg 实例对象
     * @return 影响行数
     */
    int update(ZzPrivateMsg zzPrivateMsg);

    /**
     * 通过主键删除数据
     *
     * @param msgId 主键
     * @return 影响行数
     */
    int deleteById(String msgId);

}