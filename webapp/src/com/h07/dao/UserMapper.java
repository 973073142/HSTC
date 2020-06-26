package com.h07.dao;

import org.apache.ibatis.annotations.Param;

import com.h07.po.User;



public interface UserMapper {
	//检测登录是否正确
    public User checkLoginAndPwd(@Param("username") String name, @Param("password") String pwd);

    // 添加用户
    public Integer addUser(User user);
}
