package com.wb.system.service;

import com.wb.system.model.dao.UserInfo;

public interface IUserService {

    UserInfo getUserInfo(String userId);

    int saveUserInfo(UserInfo userInfo);
}
