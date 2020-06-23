package com.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.entity.Collect;
import com.pro.entity.CollectExample;
import com.pro.entity.Share;
import com.pro.entity.ShareExample;
import com.pro.mapper.CollectMapper;
import com.pro.mapper.ShareMapper;

@Service
public class CollectSrevice {
	@Autowired
	private CollectMapper collectMapper;
	
	
	@Autowired
	private ShareMapper shareMapper;
	
	/**
	 * 对收藏的人数进行更改的作用而已
	 * 主要是增加
	 * 	还有删除
	 * 通过计算人数，来对share表中scollect进行修改
	 */
	
	/**
	 *  	增加
	 * 		增加一条收藏数据之后   	更新该sid的经验信息的收藏人数
	 * 		并返回收藏人数
	 */
	public int addCollent(Collect collect) {
		int scollect=0;
		if(collectMapper.insert(collect)>0) {
			scollect=countBySid(collect.getSid());
			ShareExample shareExample=new ShareExample();
			shareExample.createCriteria().andSidEqualTo(collect.getSid());
			Share share=new Share();
			share.setScollect(scollect);
			/* 计算收藏的人数,然后跟新到数据库中 	*/
			if(shareMapper.updateByExampleSelective(share, shareExample)>0) {
				return scollect;
			}
			
		}
		return scollect;
		
	}
	/**
	 * 删除  
	 */
	public boolean delCollect(int clid) {
		return collectMapper.deleteByPrimaryKey(clid)>0;
	}
	
	
	/**
	 * 		根据sid  和 uid 来进行删除一条收藏记录，
	 * 		并返回收藏的人数
	 * */
	
	public int delCollectBySidAndUid(int sid,int uid ) {
		int scollect=countBySid(sid);/*/删除的时候可以直接计算收藏人数		//增加的就不行，因为增加的前时候都该是 0*/
		CollectExample collectExample=new CollectExample();
		collectExample.createCriteria().andSidEqualTo(sid).andUidEqualTo(uid);
		if(collectMapper.deleteByExample(collectExample)>0) {
			scollect=countBySid(sid);
			ShareExample shareExample=new ShareExample();
			shareExample.createCriteria().andSidEqualTo(sid);
			Share share=new Share();
			share.setScollect(scollect);
			/* 计算收藏的人数,然后跟新到数据库中 	*/
			if(shareMapper.updateByExampleSelective(share, shareExample)>0) {
				return scollect;
			}
		}
		return countBySid(sid);
		
//		int scollect=0;
//		if(collectMapper.insert(collect)>0) {
//			scollect=countBySid(collect.getSid());
//			ShareExample shareExample=new ShareExample();
//			shareExample.createCriteria().andSidEqualTo(collect.getSid());
//			Share share=new Share();
//			share.setScollect(scollect);
//			/* 计算收藏的人数,然后跟新到数据库中 	*/
//			if(shareMapper.updateByExampleSelective(share, shareExample)>0) {
//				return scollect;
//			}
//			
//		}
//		return scollect;
	}
	
	
	
	/**
	 * 		查
	 * 根据经验id进行计算人数，有点浪费的感觉。    有引用，不用删除
	 */
	public int countBySid(int sid) {
		System.out.println("service类中添加收藏数据");
		CollectExample collectExample=new CollectExample();
		collectExample.createCriteria().andSidEqualTo(sid);
		
		List<Collect> collectList=collectMapper.selectByExample(collectExample);
		return collectList.size();
	}
	
	/*
	 * 		判断是否已经收藏了 
	 * 		根据sid  和   uid  来坚持是否存在该用于已经收藏了此条信息记录
	 * 	 	
	 */
	public Collect isCollect(int sid,int uid) {
		CollectExample collectExample=new CollectExample();
		collectExample.createCriteria().andSidEqualTo(sid).andUidEqualTo(uid);
		
		List<Collect> collectList= collectMapper.selectByExample(collectExample);
		System.out.println("sid和uid 查找出来收藏的人数为："+collectList.size());
		return collectList.size()>0?collectList.get(0):null;
	}
	

	
	/**
	 * 		根据 uid  来进来查找用户收藏的 sid 经验信息
	 * 		返回列表 
	 */
	
	

	/**
	 * 		根据用户uid 来查询
	 * 		查询用户uid 总共收藏的经验信息条数
	 */
	public List<Share> getShareByUidInCollect(int uid) {
		
		//这样子就编程了按id搜索了
		
		
		return shareMapper.selectShareByUidInCollect(uid);
	}
	
	
}
