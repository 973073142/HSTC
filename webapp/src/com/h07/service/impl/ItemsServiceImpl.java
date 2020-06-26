package com.h07.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h07.dao.ItemsMapper;
import com.h07.po.Items;
import com.h07.service.ItemsService;


@Service
public class ItemsServiceImpl implements ItemsService {
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<Items> findAll() {
		// TODO Auto-generated method stub
		return itemsMapper.findAll();
	}

	@Override
	public Items findOne(int id) {
		// TODO Auto-generated method stub
		return itemsMapper.findOne(id);
	}

	@Override
	public int add(Items items) {
		// TODO Auto-generated method stub
		return itemsMapper.add(items);
	}

	@Override
	public int upd(Items items) {
		// TODO Auto-generated method stub
		return itemsMapper.upd(items);
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return itemsMapper.del(id);
	}
}
