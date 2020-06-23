package com.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.entity.Share;
import com.pro.service.ShareService;

@RestController
public class ShareController {
	
	@Autowired
	private ShareService shareService;
	
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
	@PostMapping("restShare")
	public boolean addShare(@RequestBody Share share) {
		return shareService.addShare(share);
	}

	
	/**
	 * 删除：	按照id进行删除。
	 * 		后期可以考虑 删除一条 sid  的经验信息，把附带的评论，图片，还有点赞、收藏的信息都删除了、、、、
	 */
	@DeleteMapping("{sid}/restShare")
	public boolean removeShareById(@PathVariable int sid) {
		return shareService.removeShareById(sid);
	}
	
	/**
	 * 查：	按照id进行查找
	 */
	@GetMapping("withUser/{sid}/restShare")
	public Share selectShareWithUserBySid(@PathVariable int sid) {
		return shareService.selectShareWithUserBySid(sid);
	}
	@GetMapping("withUser/restShare")
	public List<Share> selectShareWithUserAll(){
		
		List<Share> shareList =shareService.selectShareWithUserAll();
		for (Share share : shareList) {
			System.out.println(share);
			
		}
		return shareService.selectShareWithUserAll();
	}
	
	
	
	
	
	/**
	 * 查：	查找全部经验信息
	 */
	@GetMapping("restShare")
	public List<Share> findAll(){
		return shareService.findAll();
	}
}

