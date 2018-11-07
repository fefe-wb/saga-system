package com.wb.system.service;

import com.wb.system.model.dao.UserInfo;

import java.util.List;

public interface IUserService {

    UserInfo getUserInfo(String userId);

    List<UserInfo> getAllUserInfo();

    int saveUserInfo(UserInfo userInfo);
}
