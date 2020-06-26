package com.h07.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h07.dao.UserMapper;
import com.h07.po.User;
import com.h07.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User checkLoginAndPwd(String name, String pwd) {
		return userMapper.checkLoginAndPwd(name, pwd);
	}

	@Override
	public Integer addUser(User user) {
		return userMapper.addUser(user);
	}

}
