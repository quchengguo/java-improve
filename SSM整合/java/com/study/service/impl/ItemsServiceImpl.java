package com.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dao.ItemsMapper;
import com.study.pojo.Items;
import com.study.pojo.ItemsExample;
import com.study.service.ItemsService;

/*
* @author quchengguo
* @version 2018年4月24日 下午7:24:06
*/
@Service
public class ItemsServiceImpl implements ItemsService{
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<Items> getItemList() {
		return itemsMapper.selectByExampleWithBLOBs(new ItemsExample());
	}

	@Override
	public Items selectByPrimayKey(Integer id) {
		return itemsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Items items) {
		return itemsMapper.updateByPrimaryKeySelective(items);
	}
}
