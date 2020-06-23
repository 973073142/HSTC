package com.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.entity.Comment;
import com.pro.entity.CommentWithUserUname;
import com.pro.service.CommentService;

@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;
	/**
	 * 评论 ：
	 * 		增加	
	 * 			
	 * 		删除
	 * 			利用cid  传入一个cid  直接删除 
	 * 		查找
	 * 			在显示到界面的时候  要的数据由 cid  sid ， uid1 uname1 uid2 uname2 ccontent 
	 *  		要利用多表查询  获取 uid1 uid2 分别对应对用户名称，
	 */
	
	/**
	 * 		增加评论
	 * 		最好返回 新插入的评论的 评论值  还有携带的用户名
	 * 		
	 * 		
	 */
	
	@PostMapping("restComment")
	public CommentWithUserUname addComment(@RequestBody Comment comment) {
		/* 返回的是包含uid 、uid2用户名的评论数据    	*/
		return commentService.addComment(comment);
	}
	

	
	@DeleteMapping("{cid}/restComment")
	public boolean delCommentById(@PathVariable int cid) {
		return commentService.delCommentById(cid);
	}
	/**
	 * 		按sid  直接查找其相关所有的评论信息
	 */
	@GetMapping("{sid}/restComment")
	public List<CommentWithUserUname> getCommentBySid(@PathVariable int sid) {
		return commentService.getCommentBySid(sid);
	}
}
