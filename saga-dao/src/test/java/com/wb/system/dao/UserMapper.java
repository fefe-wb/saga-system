package com.wb.system.dao;
import com.wb.system.model.dao.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Insert("insert into user_base_info" +
            "(user_id,mobile_no,user_name,sex,address,gmt_create,gmt_modified)" +
            "values" +
            "(#{userId},#{mobileNo},#{userName},#{sex},#{address},#{gmtCreate},#{gmtModified})")
    int insertUser(UserInfo userInfo);

    /**
     * 一定要记得把查出的数据库的字段取实体类的别名，否则查到的结果字段为null
     * @param userId
     * @return
     */
    @Select("select user_id as userId,mobile_no as mobileNo,user_name userName,sex, address,gmt_create as gmtCreate,gmt_modified gmtModified from user_base_info where user_id = #{userId}")
    UserInfo selectUser(String userId);
}
