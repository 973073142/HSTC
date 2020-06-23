package com.pro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.entity.User;
import com.pro.service.UserService;
import com.pro.utils.HttpRequest;

import net.sf.json.JSONObject;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * 增加
	 * @param user
	 * 将前端传进来的数据进行封装成一个实体类，称之为模型驱动
	 * @RequestBody  将穿过来的参数，转成一个json格式的数据
	 */
	@PostMapping("restUser")
	public boolean addUser(@RequestBody User user) {
		
		return userService.addUser(user);
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("{uid}/restUser")
	public boolean removeByUid(@PathVariable int uid) {
		return userService.removeByUid(uid);
	}
	/**
	 * 查
	 * 获取
	 * @param uid
	 * @return
	 */
	//按id查找
	@GetMapping("{uid}/restUser")
	public User getUser(@PathVariable int uid) {
		return userService.getByUid(uid);
	}
	//查询是否有该【账号名】的用户
	@GetMapping("account/{uaccount}/restUser")
	public boolean isExistSameUaccount(@PathVariable String uaccount) {
		return userService.isExistSameUaccount(uaccount); 

	}
	
	/**
	 * 判断是否存在这个用户，用账户名称和用户密码进行判断，
	 * 取值时，都进行去空格
	 * 传入用户名称，与密码，用户名称每一个人都是不一样的
	 */
	@GetMapping("{uaccount}/{upsw}/restUser")
	public User getExistUser(@PathVariable String uaccount,@PathVariable String upsw) {
		return userService.getExistUser(uaccount.trim(), upsw.trim());
	}
	
	//查询所有
	@GetMapping("restUser")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@GetMapping("getUid/{uaccount}/restUser")
	public int getUidByUaccount(@PathVariable String uaccount) {
		return userService.getUidByUaccount(uaccount.trim());
	}
	
	/**
	 * 改
	 * @param user
	 * @return
	 */
	@PutMapping("restUser")
	public boolean editUser(User user) {
		return userService.editUser(user);
	}
	/**
	 *  	尝试获取用户id号
	 */
	
	@GetMapping("wxid/{code}/restUser")
	public String getWxI(@PathVariable String code) {
		Map map=new HashMap();
		if(code==null||code.length() == 0){
			map.put("status", 0);
			 map.put("msg", "code 不能为空");
		}
		//小程序唯一标识   (在微信小程序管理后台获取)
	    String wxspAppid = "wx55b0ac15413cbce7".trim();
	    //小程序的 app secret (在微信小程序管理后台获取)
	    String wxspSecret = "21fb7b68ee31989522a46360b4b0161d".trim();
	    //授权（必填）
	    String grant_type = "authorization_code".trim();
	    String params = "appid=" + wxspAppid + 
	    		"&secret=" + wxspSecret + 
	    		"&js_code=" + code + 
	    		"&grant_type=" + grant_type;
	    String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
	    System.out.println(sr);
//	    System.out.println();
//	    olsQg5dKAldpgQZ8pzL9GvnkWKaY
	    	    JSONObject json = JSONObject.fromObject(sr);
	    String openid = (String) json.get("openid");
	    return openid;
	}
	

	
}
