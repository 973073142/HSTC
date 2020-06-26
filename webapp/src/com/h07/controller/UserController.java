package com.h07.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.h07.po.User;
import com.h07.service.UserService;



@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/checkLogin.action")
	@ResponseBody
	public User checkLogin(@RequestBody User user, HttpSession session){
		//user有登录界面中传入
		User userLogin = userService.checkLoginAndPwd(user.getUsername(), user.getPassword());
		//把userLogin加入到session中，在流中可以是调出使用
		session.setAttribute("userLogin", userLogin);
		return userLogin;
	}

	//注销登录
	//退回到登录界面
	@RequestMapping("/logOut")
	public String LogOut(HttpSession session) {
		session.invalidate();
		return "redirect:/login.jsp";
	}

	// 注册
	//get 和post 方法
	@RequestMapping(value = "/register", method = { RequestMethod.GET, RequestMethod.POST })
	public String register(User user, Model model) {
		System.out.println(user);
		userService.addUser(user);
		//model传入到界面中，可调用出来
		model.addAttribute("msg", "当当当，注册成功啦！！！快去登录吧");
		//转到success.jsp中
		return "success";
	}

}
