package com.workhub.z.servicechat.dao;

import com.workhub.z.servicechat.entity.ZzAt;
import com.workhub.z.servicechat.entity.ZzDictionaryWords;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 字典词汇表(ZzDictionaryWords)表数据库访问层
 *
 * @author makejava
 * @since 2019-05-17 14:56:57
 */
public interface ZzDictionaryWordsDao extends Mapper<ZzDictionaryWords> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ZzDictionaryWords queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ZzDictionaryWords> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param zzDictionaryWords 实例对象
     * @return 对象列表
     */
    List<ZzDictionaryWords> queryAll(ZzDictionaryWords zzDictionaryWords);

    /**
     * 新增数据
     *
     * @param zzDictionaryWords 实例对象
     * @return 影响行数
     */
    int insert(ZzDictionaryWords zzDictionaryWords);

    /**
     * 修改数据
     *
     * @param zzDictionaryWords 实例对象
     * @return 影响行数
     */
    int update(ZzDictionaryWords zzDictionaryWords);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}