package com.wb.system.dao;


import com.wb.system.model.dao.UserInfo;

import java.util.List;

/**
 * Created by cungubenxiaokang on 2018/8/25.
 */
public interface UserDao {

    UserInfo selectUser(String userId);

    List<UserInfo> selectAllUser();

    int insertUser(UserInfo userInfo);
}