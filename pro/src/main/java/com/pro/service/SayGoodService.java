package com.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.entity.SayGood;
import com.pro.entity.SayGoodExample;
import com.pro.entity.Share;
import com.pro.entity.ShareExample;
import com.pro.mapper.SayGoodMapper;
import com.pro.mapper.ShareMapper;

@Service
public class SayGoodService {
	
	@Autowired
	private SayGoodMapper sayGoodMapper;
	
	@Autowired
	private ShareMapper shareMapper;
	/**
	 * 增加点赞收藏的数据
	 * 删除点赞的数据
	 * 按照sid计算 经验信息号为sid 的经验信息的点赞人数为多少
	 */
	
	/**
	 * 添加
	 * 	增加一条点赞的同时，对经验信息表上的slike的个数进行修改
	 * 		不知是否可行，先这么写着，到时候再看看
	 */
	public int addSayGood(SayGood sayGood) {
		/*刚添加上去 slike 是为0的 */
		int slike=0;
		System.out.println("可以执行到这一句111");
		
		if(sayGoodMapper.insert(sayGood)>0) {
			slike=countBySid(sayGood.getSid());
			ShareExample shareExample=new ShareExample();
			shareExample.createCriteria().andSidEqualTo(sayGood.getSid());
			Share share=new Share();
//			share.setSid(sayGood.getSid());
			share.setSlike(slike);
			System.out.println("可以执行到这一句222");
			if(shareMapper.updateByExampleSelective(share, shareExample)>0) {
				System.out.println("可以执行到这一句333");
				return slike;
			}
			
			
		}
			return slike;
	}
	/**
	 *删除
	 *		删除一条点赞消息的同时，更新到经验信息表上的slike的个数
	 */
	public boolean delSayGoodBySgid(int sgid) {
		//根据sgid先查找出一整条  sgid sid uid 要去sid 作为接下来的参数
//		SayGoodExample sayGoodExample=new SayGoodExample();
//		sayGoodExample.createCriteria().andSgidEqualTo(sgid);
		SayGood sayGood= sayGoodMapper.selectByPrimaryKey(sgid);
		if(sayGoodMapper.deleteByPrimaryKey(sgid)>0) {
			int slike=countBySid(sayGood.getSid());
			ShareExample shareExample=new ShareExample();
			shareExample.createCriteria().andSidEqualTo(sayGood.getSid());
			Share share=new Share();
//			share.setSid(sayGood.getSid());
			share.setSlike(slike);
			if(shareMapper.updateByExampleSelective(share, shareExample)>0) {
				return true;
			}
		}
		return false;
	}
	
	public int delSayGoodBySidAndUid(int sid,int uid) {
		int slike=countBySid(sid);
		SayGoodExample sayGoodExample=new SayGoodExample();
		sayGoodExample.createCriteria().andSidEqualTo(sid).andUidEqualTo(uid);
		if(sayGoodMapper.deleteByExample(sayGoodExample)>0) {
			System.out.println("成功删除一条点赞数据成功删除一条点赞数据成功删除一条点赞数据成功删除一条点赞数据");
			slike=countBySid(sid);
			ShareExample shareExample=new ShareExample();
			shareExample.createCriteria().andSidEqualTo(sid);
			Share share=new Share();
//			share.setSid(sid);
			share.setSlike(slike);
			if(shareMapper.updateByExampleSelective(share, shareExample)>0) {
				return slike;
			}
		}
		return slike;
	}
	
	/**
	 *  按照sid计算 经验信息号为sid 的经验信息的点赞人数为多少
	 */
	public int countBySid(int sid) {
		SayGoodExample sayGoodExample=new SayGoodExample();
		sayGoodExample.createCriteria().andSidEqualTo(sid);
		return sayGoodMapper.selectByExample(sayGoodExample).size();
		/*sayGoodMapper.selectByExample(sayGoodExample) 得出来的结果是List<SayGood>列表。size()函数得出长度*/
		
	}
	
	/**
	 * 根据经验信息编号和用户id判断是否已经点赞
	 */
	public SayGood isSayGood(int sid ,int uid) {
		SayGoodExample sayGoodExample=new SayGoodExample();
		sayGoodExample.createCriteria().andSidEqualTo(sid).andUidEqualTo(uid);
		int sgcount= sayGoodMapper.selectByExample(sayGoodExample).size();
		System.out.println("按照sid 和uid 找到的个数为："+sgcount);
		List<SayGood> sayGoodList=sayGoodMapper.selectByExample(sayGoodExample);
		return sayGoodList.size()>0?sayGoodList.get(0):null;
	}
	
	
	
	
	

}
