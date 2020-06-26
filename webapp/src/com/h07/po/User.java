package com.h07.po;

import java.util.Date;

public class User {
    private int id; // id
    private String username; // 用户名称
    private String password; // 密码
    private int sex; // 性别
    private String address; // 居住住址ַ
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*public Date getBirthday() {
		return birthday;
	}*/
	/*public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}*/
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
	/*@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", birthday=" + birthday + ", sex=" + sex
				+ ", address=" + address + "]";
	}*/
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", sex=" + sex + ", address=" + address + "]";
	}
	
	
   
}
