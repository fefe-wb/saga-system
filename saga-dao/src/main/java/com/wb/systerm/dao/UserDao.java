package com.wb.systerm.dao;

import com.wb.systerm.entity.UserInfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by cungubenxiaokang on 2018/8/25.
 */
@Repository
public class UserDao{

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public UserInfo getUser(int id) {
        return sqlSessionTemplate.selectOne(this.getClass().getName() + ".getUser", 1);
    }

    public int insert(UserInfo userInfo) {
        return sqlSessionTemplate.insert(this.getClass().getName() + ".insert");
    }
}
