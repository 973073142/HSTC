package com.pro.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.pro.entity.User;
import com.pro.entity.UserExample;
import com.pro.mapper.UserMapper;



@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	//通过用户名查找 可能会是多个人同名  //我觉得不会用到这个函数
	public List<User> findByUname(String uname) {
		UserExample ue=new UserExample();
		ue.createCriteria().andUnameEqualTo(uname);
		List<User> userList=userMapper.selectByExample(ue);
		return userList.size()>1?null:userList;
//		if(userList.size()>1) {
//			return null;
//		}else {
//			return userList;
//		}
	}
	
	public List<User> findAll(){
		return userMapper.selectByExample(null);
	}
	
	//通过id查找
	public User getByUid(int uid) {
		return userMapper.selectByPrimaryKey(uid);		
	}
	/**
	 * 通怪唯一openid == uaccount
	 * 来返回uid
	 */
	public int getUidByUaccount(String uaccount) {
		UserExample userExample=new UserExample();
		userExample.createCriteria().andUaccountEqualTo(uaccount.trim());
		List<User> userList= userMapper.selectByExample(userExample);
		return userList.size()>0?userList.get(0).getUid():-1;
	}
	
	/**
	 * 判断是否存在这个用户，用账户名称和用户密码进行判断，
	 * 取值时，都进行去空格
	 */
	public User getExistUser(String uaccount,String upsw){
		UserExample userExample=new UserExample();
		userExample.createCriteria().andUaccountEqualTo(uaccount.trim()).andUpswEqualTo(upsw.trim());
		List<User> userList= userMapper.selectByExample(userExample);
		return userList.size()>0?userList.get(0):null;
	
	}
	
	/**
	 * 判断是否存在 该 账号名 
	 */
	public boolean isExistSameUaccount(String uaccount) {
		UserExample userExample=new UserExample();
		userExample.createCriteria().andUaccountEqualTo(uaccount);
		List<User> userList=userMapper.selectByExample(userExample);
		return userList.size()>0;
	}
	
	//增加用户
	public boolean addUser(User user) {
		return userMapper.insert(user)>0;
//		if(userMapper.insertSelective(user)>0) {
//			return true;
//		}else {
//			return false;
//		}
		
	}
	
	//修改
	public boolean editUser(User user) {
		return userMapper.updateByPrimaryKeySelective(user)>0;
	}
	//删除
	public boolean removeByUid(int uid) {
		return userMapper.deleteByPrimaryKey(uid)>0;
	}

}
