package com.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.entity.SayGood;
import com.pro.entity.ShareExample;
import com.pro.service.SayGoodService;
@RestController
public class SayGoodController {
	
	@Autowired
	private SayGoodService sayGoodService;
	/**
	 * 增加点赞收藏的数据
	 * 删除点赞的数据
	 * 按照sid计算 经验信息号为sid 的经验信息的点赞人数为多少
	 */
	
	// 点赞，就将点赞编号sgid 、经验信息编号sid、点赞人uid
	@PostMapping("restSayGood")
	public int addSayGood(@RequestBody SayGood sayGood) {
		/*添加一条点赞消息的同时，更新经验信息表上的数据*/
		
		return sayGoodService.addSayGood(sayGood);
	}
	
	//按照点赞编号sgid进行删除
	@DeleteMapping("{sgid}/restSayGood")
	public boolean delSayGoodBySgid(@PathVariable int sgid) {
		return sayGoodService.delSayGoodBySgid(sgid);
	}
	@DeleteMapping("{sid}/{uid}/restSayGood")
	public int delSayGoodBySidAndUid(@PathVariable int sid,@PathVariable int uid) {
		return sayGoodService.delSayGoodBySidAndUid(sid, uid);

	}
	
	//计算该条经验信息的点赞人数
	@GetMapping("{sid}/restSayGood")
	public int countBySid(@PathVariable int sid) {
		return sayGoodService.countBySid(sid);
	}
	
	/**
	 * 	根据经验信息编号sid 和用户 uid判断是否已经点赞
	 */
	@GetMapping("{sid}/{uid}/restSayGood")
	public SayGood isSayGood(@PathVariable int sid,@PathVariable int uid) {
		return sayGoodService.isSayGood(sid,uid);
	}
}
