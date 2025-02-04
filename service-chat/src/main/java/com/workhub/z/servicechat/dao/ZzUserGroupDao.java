package com.workhub.z.servicechat.dao;

import com.workhub.z.servicechat.VO.GroupListVo;
import com.workhub.z.servicechat.VO.GroupUserListVo;
import com.workhub.z.servicechat.VO.UserNewMsgVo;
import com.workhub.z.servicechat.entity.ZzUserGroup;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 用户群组映射表(ZzUserGroup)表数据库访问层
 *
 * @author 忠
 * @since 2019-05-10 14:22:54
 */
public interface ZzUserGroupDao extends Mapper<ZzUserGroup> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ZzUserGroup queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ZzUserGroup> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param zzUserGroup 实例对象
     * @return 对象列表
     */
    List<ZzUserGroup> queryAll(ZzUserGroup zzUserGroup);

    /**
     * 新增数据
     *
     * @param zzUserGroup 实例对象
     * @return 影响行数
     */
    int insert(ZzUserGroup zzUserGroup);

    /**
     * 修改数据
     *
     * @param zzUserGroup 实例对象
     * @return 影响行数
     */
    int update(ZzUserGroup zzUserGroup);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    List<GroupListVo> groupList(@Param("id")String id, @Param("start")Integer start, @Param("end")Integer end);

    Long groupListTotal(@Param("id")String id);

    Long deleteByGroupIdAndUserId(@Param("groupId") String groupId,@Param("userId") String userId);

    List<UserNewMsgVo> getUserNewMsgList(@Param("id")String id);
}