package com.pro.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.entity.Comment;
import com.pro.entity.CommentExample;
import com.pro.entity.CommentWithUserUname;
import com.pro.mapper.CommentMapper;

@Service
public class CommentService {
	
	@Autowired
	private CommentMapper commentMapper;
	/**
	 * 评论 ：
	 * 		增加
	 * 		删除
	 * 没有修改
	 * 也没有查找
	 */
	/**
	 * 增加
	 */
	public CommentWithUserUname addComment(Comment comment) {
		if(commentMapper.insert(comment)>0) {
			CommentExample commentExample =new CommentExample();
			commentExample.createCriteria().andSidEqualTo(comment.getSid()).andUidEqualTo(comment.getUid()).andUid2EqualTo(comment.getUid2());
			List<Comment> commentList=commentMapper.selectByExample(commentExample);
			/**
			 *	 因为评论是按cid编号排的，，故添加之后，
			 *	必定排在最后面，直接选区取最后的一个就行了
			 *	然后再 利用
			 */
			Comment newComment=commentList.get(commentList.size()-1);
			
			System.out.println(newComment);
			return commentMapper.getConmentCommentByCid(newComment.getCid());
			
			
			
		}
		return null;
	}
	/**
	 *删除   因为参数传递过程中，有cid 的传值，就 直接用cid  编号 直接删除
	 */
	
	public boolean delCommentById(int cid) {
		return commentMapper.deleteByPrimaryKey(cid)>0;
	}
	
	/**
	 * 	查找 所有关于  sid 的全部评论/回复信息
	 */
	public List<CommentWithUserUname> getCommentBySid(int sid){
		/**
		 * 		是否应该再一次判断为空的情况下？？？？
		 */
		List<CommentWithUserUname> cu =commentMapper.getCommentBySid(sid);
		for(CommentWithUserUname cwuname : cu) {
			System.out.println(cwuname);
		}
		return cu.size()>0?cu:null;
	}
	
	
	
}
