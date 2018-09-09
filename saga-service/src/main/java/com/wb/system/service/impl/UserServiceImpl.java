package com.wb.system.service.impl;

import com.wb.system.dao.UserDao;
import com.wb.system.model.dao.UserInfo;
import com.wb.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserInfo getUserInfo(String userId) {
        UserInfo userInfo = null;
        // get from redis
        userInfo = userDao.selectUser(userId);
        // set redis
        return userInfo;
    }

    @Override
    public int saveUserInfo(UserInfo userInfo) {
        int res = userDao.insertUser(userInfo);
        return res;
    }
}
