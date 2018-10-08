package com.wb.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.wb.system.dao.UserDao;
import com.wb.system.model.dao.UserInfo;
import com.wb.system.service.IUserService;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    JedisCluster jedisCluster;

    public UserInfo getUserInfo(String userId) {
        UserInfo userInfo;
        String userInfoJson = jedisCluster.get(userId);
        if (StringUtils.isNotBlank(userInfoJson)) {
            return JSON.parseObject(userInfoJson, UserInfo.class);
        }
        userInfo = userDao.selectUser(userId);
        if (userInfo != null) {
            jedisCluster.set(userId, JSON.toJSONString(userInfo));
        }
        return userInfo;
    }

    public int saveUserInfo(UserInfo userInfo) {
        int res = userDao.insertUser(userInfo);
        return res;
    }

    public void sayHello() {
        System.out.println("hello...");
    }
}
