package com.wb.system.web.controller;


import com.wb.system.model.dao.UserInfo;
import com.wb.system.service.IUserService;
import com.wb.system.service.impl.UserServiceImpl;
import com.wb.system.web.proxy.BusinessProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * Created by cungubenxiaokang on 2018/8/24.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(@RequestParam String userId, @RequestParam String userName,
                         @RequestParam String mobileNo, @RequestParam String address, @RequestParam int sex) {
        int res = userService.saveUserInfo(new UserInfo(userId, mobileNo, userName, sex, address, new Date(), new Date()));
        return "成功插入" + res + "条数据！！！";
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String select(@RequestParam String userId) {
        UserInfo userInfo = userService.getUserInfo(userId);
        System.out.println(userInfo.toString());
        return userInfo.toString();
    }

    @RequestMapping(value = "/selectFromProxy", method = RequestMethod.GET)
    public String selectFromProxy(@RequestParam String userId) {
        IUserService proxyInstance = (IUserService) Proxy.newProxyInstance(
                UserServiceImpl.class.getClassLoader(), UserServiceImpl.class.getInterfaces(), new BusinessProxy(userService));
        UserInfo userInfo = proxyInstance.getUserInfo(userId);
        System.out.println(userInfo.toString());
        return userInfo.toString();
    }
}
