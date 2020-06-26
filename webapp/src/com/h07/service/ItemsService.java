package com.h07.service;

import java.util.List;

import com.h07.po.Items;



public interface ItemsService {
	//1.单条查询-id
	public Items findOne(int id);
		
	//2.查询所有商品
	public List<Items> findAll();
	
	//3.增加
	public int add(Items items);
	
	//4.更新
	public int upd(Items items);
	
	//5.删除
	public int del(int id);
}
