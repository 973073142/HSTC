package com.h07.service;

import com.h07.po.User;



public interface UserService {
	//检查登录
	public User checkLoginAndPwd(String name, String pwd);
	//添加用户
	public Integer addUser(User user);
}
