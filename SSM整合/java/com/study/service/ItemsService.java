package com.study.service;

import java.util.List;

import com.study.pojo.Items;

/*
* @author quchengguo
* @version 2018年4月24日 下午7:24:51
*/
public interface ItemsService {
	/**
	 * 获取Item列表
	 * @return
	 */
	public List<Items> getItemList();
	
	/**
	 * 更新items
	 * @param items
	 * @return
	 */
	public int updateByPrimaryKeySelective(Items items);

	/**
	 * 根据id查找items
	 * @param id
	 * @return
	 */
	public Items selectByPrimayKey(Integer id);
}
