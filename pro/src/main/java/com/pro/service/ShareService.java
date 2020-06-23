package com.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.entity.CollectExample;
import com.pro.entity.CommentExample;
import com.pro.entity.SayGoodExample;
import com.pro.entity.Share;
import com.pro.mapper.CollectMapper;
import com.pro.mapper.CommentMapper;
import com.pro.mapper.SayGoodMapper;
import com.pro.mapper.ShareMapper;

@Service
public class ShareService {
	
	@Autowired
	private ShareMapper shareMapper;
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private CollectMapper collectMapper;
	
	@Autowired 
	private SayGoodMapper sayGoodMapper;
	/**
	 * 增删查//没有改
	 * 增：
	 * 		增加经验信息
	 * 
	 * 删：	按照id进行删除，
	 * 		每一个详情页面下，都应该附带有这一条经验信息的具体信息，
	 * 		最重要的就是id就可以，可以用来查找，也可用来删除时使用
	 * 
	 * 查：
	 * 		查找经验信息
	 * 		按照id查找
	 * 		直接查找全部，或者是分页来查找，上拉加载进来。
	 */
	
	/**
	 * 增：	增加信息
	 */
	public boolean addShare(Share share) {
		return shareMapper.insert(share)>0;
	}
	
	/**
	 * 删除：	按照id进行删除。
	 */
	public boolean removeShareById(int sid) {
		//删除一条经验信息，，顺带将他的 评论，点赞，都删除掉。
		if(shareMapper.deleteByPrimaryKey(sid)>0) {
			//评论的，  点赞的  、、  收藏的   都要删除
			CommentExample commentExample=new CommentExample();
			commentExample.createCriteria().andSidEqualTo(sid);
			commentMapper.deleteByExample(commentExample);
			
			SayGoodExample sayGoodExample=new SayGoodExample();
			sayGoodExample.createCriteria().andSidEqualTo(sid);
			sayGoodMapper.deleteByExample(sayGoodExample);
			
			CollectExample collectExample=new CollectExample();
			collectExample.createCriteria().andSidEqualTo(sid);
			collectMapper.deleteByExample(collectExample);
			
			return true;
		}
		return false;
	}
	
	/**
	 * 查：	按照id进行查找
	 */
	public Share findShareById(int sid) {
		return shareMapper.selectByPrimaryKey(sid);
	}
	
	/**
	 * 	跟user表进行的连接查询
	 * 	
	 */
	
	public Share selectShareWithUserBySid(int sid) {
		return shareMapper.selectShareWithUserBySid(sid);
	}
	
	public List<Share> selectShareWithUserAll(){
		return shareMapper.selectShareWithUserAll();
	}
	/**
	 * 	再设置一个可以根据 
	 * 
	 */
//	public  List<Share> selectShareListBySidInCollect(int[] sids){
//		List<Share> shareList =new List<Share>();
//	}
	
	
	/**
	 * 查：	查找全部经验信息
	 */
	public List<Share> findAll(){
		return shareMapper.selectByExample(null);
	}
}
