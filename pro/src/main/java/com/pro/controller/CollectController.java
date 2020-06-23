package com.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.entity.Collect;
import com.pro.entity.Share;
import com.pro.mapper.CollectMapper;
import com.pro.service.CollectSrevice;
@RestController
public class CollectController {
	
	@Autowired
	private CollectSrevice collectSrevice;
	
	/**
	 * 增加收藏的数据
	 * 删除收藏的数据
	 * 按照sid计算 经验信息号为sid 的经验信息的人数为多少
	 */
	
	// 点赞，就将点赞编号sgid 、经验信息编号sid、点赞人uid
	@PostMapping("restCollect")
	public int addCollect(@RequestBody Collect collect) {
		/*在这这里进行对收藏人数进行修改
		//并返回的      收藏人数
		*/
		return collectSrevice.addCollent(collect);
	}
	
	@DeleteMapping("{clid}/restCollect")
	public boolean delCollect(@PathVariable int clid) {
		return collectSrevice.delCollect(clid);
	}
	
	
	/*
	 *		删除
	 *		根据sid  和 uid 进行删除 一条收藏的记录
	 *		并返回该数据的收藏人数
	 *
	 */
	@DeleteMapping("{sid}/{uid}/restCollect")
	public int delCollectBySidAndUid(@PathVariable int sid,@PathVariable int uid) {
		return collectSrevice.delCollectBySidAndUid(sid, uid);
		
	}
	
	/**
	 * 		获取sid 的收藏人数
	 */
	@GetMapping("{sid}/restCollect")
	public int countBySid(@PathVariable int sid){
		System.out.println("controller类中添加收藏数据");
		return collectSrevice.countBySid(sid);
	}
	
	/**
	 * 根据经验信息编号和用户id判断是否已经点赞
	 */
	@GetMapping("{sid}/{uid}/restCollect")
	public Collect isCollect(@PathVariable int sid,@PathVariable int uid) {
		return collectSrevice.isCollect(sid, uid);
	}
	//计算该条经验信息的点赞人数
	
	
	/**
	 * 		根据用户uid 来查询
	 * 		查询用户uid 总共收藏的经验信息条数
	 */
	
	@GetMapping("myCollect/{uid}/restCollect")
	public List<Share> getShareByUidInCollect(@PathVariable int uid){
		return collectSrevice.getShareByUidInCollect(uid);
	}

}
