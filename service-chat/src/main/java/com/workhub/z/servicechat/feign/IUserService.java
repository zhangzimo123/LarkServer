package com.workhub.z.servicechat.feign;

import com.github.hollykunge.security.api.vo.user.UserInfo;
import com.github.hollykunge.security.auth.configuration.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@FeignClient(value = "ace-admin")
@Repository
public interface IUserService {
    /**
    *@Description: 根据user身份证查询用户信息
    *@Param: sn
    *@return: UserInfo
    *@Author: 忠
    *@date: 2019/3/22
    */

    @RequestMapping(value = "/api/user/validate", method = RequestMethod.POST)
    public UserInfo validate(@RequestParam("username") String username, @RequestParam("password") String password);
//    @RequestMapping(value = "/api/user/test", method = RequestMethod.POST)
//    public void test();

    @RequestMapping(value = "/user/userlist", method = RequestMethod.POST)
    public List<UserInfo> userList(@RequestParam("userIdSet") Set<String> userIdSet);

    @RequestMapping(value = "/user/all", method = RequestMethod.POST)
    public List<UserInfo> all();

    @RequestMapping(value = "/user/info", method = RequestMethod.POST)
    public UserInfo info(Integer userId);
}
