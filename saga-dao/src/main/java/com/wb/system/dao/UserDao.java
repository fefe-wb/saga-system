package com.wb.system.dao;


import com.wb.system.model.dao.UserInfo;

/**
 * Created by cungubenxiaokang on 2018/8/25.
 */
public interface UserDao {

    UserInfo selectUser(String userId);

    int insertUser(UserInfo userInfo);
}