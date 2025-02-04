package com.workhub.z.servicechat.controller;

import com.github.hollykunge.security.common.msg.ObjectRestResponse;
import com.github.hollykunge.security.common.rest.BaseController;
import com.workhub.z.servicechat.config.RandomId;
import com.workhub.z.servicechat.entity.ZzMsgReadRelation;
import com.workhub.z.servicechat.entity.ZzMsgTabInfo;
import com.workhub.z.servicechat.entity.ZzMsgTabRelation;
import com.workhub.z.servicechat.service.ZzMsgTabInfoService;
import com.workhub.z.servicechat.service.ZzMsgTabRelationService;
import com.workhub.z.servicechat.service.impl.ZzMsgTabInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 消息标记信息表(ZzMsgTabInfo)表控制层
 *
 * @author makejava
 * @since 2019-05-23 16:46:13
 */
@RestController
@RequestMapping("/zzMsgTabInfo")
public class ZzMsgTabInfoController
        extends BaseController<ZzMsgTabInfoServiceImpl, ZzMsgTabInfo> {
    /**
     * 服务对象
     */
    @Resource
    private ZzMsgTabInfoService zzMsgTabInfoService;

    @Autowired
    private ZzMsgTabRelationService zzMsgTabRelationService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public ZzMsgTabInfo selectOne(String id) {
        return this.zzMsgTabInfoService.queryById(id);
    }

    @PostMapping("/create")
    //TODO 下面方法处理需要开启事务 后续开发请注意改造后注意事务传播 会牵扯到多事务
    public ObjectRestResponse insert(ZzMsgTabInfo zzMsgTabInfo,@RequestParam("fileId")String fileId){
        zzMsgTabInfo.setId(RandomId.getUUID());
//        Integer insert = this.zzMsgTabInfoService.insert(zzMsgTabInfo);
        ObjectRestResponse objectRestResponse = new ObjectRestResponse();
//        if (insert == 0){
//            objectRestResponse.data("失败");
//            return objectRestResponse;
//        }
        if ("BASE".equals(zzMsgTabInfo.getTabType())){//基本消息标记无需执行文件与标记关系
            objectRestResponse.data("成功");
            return objectRestResponse;
        }
        ZzMsgTabRelation zzMsgTabRelation = new ZzMsgTabRelation();
        zzMsgTabRelation.setId(RandomId.getUUID());
        zzMsgTabRelation.setFileId(fileId);
        zzMsgTabRelation.setTabId(zzMsgTabInfo.getId());
//        Integer count = this.zzMsgTabRelationService.insert(zzMsgTabRelation);
//        if (count == 0){
//            objectRestResponse.data("失败");
//            return objectRestResponse;
//        }
        objectRestResponse.data("成功");
        return objectRestResponse;
    }

    @DeleteMapping("/delete")
    //TODO 下面方法处理需要开启事务
    public ObjectRestResponse delete(@RequestParam("id")String id,
                                     @RequestParam("tabType")String tabType){
        boolean flag = this.zzMsgTabInfoService.deleteById(id);
        ObjectRestResponse objectRestResponse = new ObjectRestResponse();
        if (!flag){
            objectRestResponse.data(flag);
            return objectRestResponse;
        }
        if (!"BASE".equals(tabType)){
            boolean b = this.zzMsgTabRelationService.deleteByTabId(id);//非基本消息标记需要删除对应的关系表记录
            objectRestResponse.data(b);
            return objectRestResponse;
        }
        return objectRestResponse;
    }
}