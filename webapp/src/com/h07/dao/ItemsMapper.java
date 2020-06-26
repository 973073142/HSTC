package com.h07.dao;

import java.util.List;

import com.h07.po.Items;



public interface ItemsMapper {
	//1.单条查询-id
	public Items findOne(int id);
		
	//2.查询所有水果
	public List<Items> findAll();
	
	//3.增加水果
	public int add(Items items);
	
	//4.更新
	public int upd(Items items);
	
	//5.删除
	public int del(int id);
}
