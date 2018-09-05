package com.wb.system.model.dao;

import java.util.Date;

/**
 * Created by cungubenxiaokang on 2018/8/25.
 */
public class UserInfo {
    private int id;
    private String userId;
    private String mobileNo;
    private String userName;
    private int sex;
    private String address;
    private Date gmtCreate;
    private Date gmtModified;

    public UserInfo() {
    }

    public UserInfo(String userId, String mobileNo, String userName,
                    int sex, String address, Date gmtCreate, Date gmtModified) {
        this.userId = userId;
        this.mobileNo = mobileNo;
        this.userName = userName;
        this.sex = sex;
        this.address = address;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
