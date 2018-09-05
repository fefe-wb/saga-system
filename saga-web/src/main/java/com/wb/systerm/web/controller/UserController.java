package com.wb.systerm.web.controller;


import com.wb.system.model.dao.UserInfo;
import com.wb.systerm.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by cungubenxiaokang on 2018/8/24.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(@RequestParam String userId, @RequestParam String userName,
                         @RequestParam String mobileNo, @RequestParam String address, @RequestParam int sex) {
        int res = userDao.insertUser(new UserInfo(userId, mobileNo, userName, sex, address, new Date(), new Date()));
        return "成功插入" + res + "条数据！！！";
    }
}
