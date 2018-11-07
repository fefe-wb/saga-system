package com.wb.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.wb.system.dao.UserDao;
import com.wb.system.model.dao.UserInfo;
import com.wb.system.service.IUserService;
import com.wb.system.util.redis.RedisProxy;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisProxy redisProxy;

    public UserInfo getUserInfo(String userId) {
        UserInfo userInfo;
        String userInfoJson = redisProxy.getString(userId);
        if (StringUtils.isNotBlank(userInfoJson)) {
            return JSON.parseObject(userInfoJson, UserInfo.class);
        }
        userInfo = userDao.selectUser(userId);
        if (userInfo != null) {
            redisProxy.setString(userId, JSON.toJSONString(userInfo));
        }
        return userInfo;
    }

    public List<UserInfo> getAllUserInfo() {
        return userDao.selectAllUser();
    }

    @Transactional
    public int saveUserInfo(UserInfo userInfo) {
        int res = userDao.insertUser(userInfo);
        return res;
    }
}
