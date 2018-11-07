package com.wb.system.dao;
import com.wb.system.model.dao.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class TestUserDao {

    private static SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 使用接口映射mapper.xml文件SQL语句的方式实现
     * mapper.xml文件namespace的值要等于接口类的路径+类名
     * 需要在mybatis-config.xml文件中指定<mapper resource="mappers/UserInfo.xml" />
     */
    @Test
    public void testMybatis1() {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            userDao.insertUser(new UserInfo("2", "118", "马化腾", 10,1, "深圳", new Date(), new Date()));
            sqlSession.commit();
            System.out.println(userDao.selectUser("1"));
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }

    /**
     * 使用sqlSession映射mapper.xml文件SQL语句的方式实现
     * mapper.xml文件namespace的值随便写，只要等于sqlSession指定的值即可
     * 需要在mybatis-config.xml文件中指定<mapper resource="mappers/UserInfo.xml" />
     */
    @Test
    public void testMybatis2() {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            int res = sqlSession.insert("UserDao.insertUser", new UserInfo("5", "118", "扎克伯格", 10, 1, "美国", new Date(), new Date()));
            sqlSession.commit();
            System.out.println(res);
            System.out.println(sqlSession.selectOne("UserDao.selectUser", "5"));
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 使用注解的方式实现
     * 不需要配置mapper.xml文件
     */
    @Test
    public void testMybatis3() {
        SqlSession sqlSession = null;
        try {
            sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
            sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int res = userMapper.insertUser(new UserInfo("6", "116", "董明珠", 10,0, "珠海", new Date(), new Date()));
            sqlSession.commit();
            System.out.println(res);
            UserInfo userInfo = userMapper.selectUser("6");
            System.out.println(userInfo);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
