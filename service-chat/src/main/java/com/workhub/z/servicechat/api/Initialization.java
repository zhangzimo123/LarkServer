package com.workhub.z.servicechat.api;

//import com.github.hollykunge.security.api.vo.user.UserInfo;
import com.github.hollykunge.security.common.msg.ListRestResponse;
import com.workhub.z.servicechat.VO.ContactVO;
import com.workhub.z.servicechat.feign.IUserService;
import com.workhub.z.servicechat.service.ZzUserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
*@Description: 系统用户初始化类
*@Author: 忠
*@date: 2019/3/21
*/
@Controller
@RequestMapping("/api/Initialization")
public class Initialization {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ZzUserGroupService zzUserGroupService;
    /**
    *@Description: 查询user所在群组
    *@Param: userid
    *@return: user群组列表
    *@Author: 忠
    *@date: 2019/3/21
    */

    /**
    *@Description: 查询用户详细信息
    *@Param: userid
    *@return: usermodel
    *@Author: 忠
    *@date: 2019/3/21
    */
    @RequestMapping("/getInfo")
    public void queryUserInfoBySn(String sn){
//        iUserService.queryUserinfoBySn(sn);
        iUserService.validate("11","11");
//        return null;
    }

    /**
    *@Description: 最近联系人
    *@Param:userid
    *@return:Contact
    *@Author: 忠
    *@date: 2019/3/21
    */
    @GetMapping("/getContact")
    @ResponseBody
    public ListRestResponse queryContactById(@RequestParam("id")String id){
        //
        List<ContactVO> list = this.zzUserGroupService.getContactVOList(id);
        return new ListRestResponse("处理完成",list.size(),list);
    }
}
