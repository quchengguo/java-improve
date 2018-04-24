package com.study.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.pojo.Items;
import com.study.service.ItemsService;

/*
* @author quchengguo
* @version 2018年4月24日 下午4:12:08
*/
@Controller
public class ItemsController {
	
	private final Logger log = LoggerFactory.getLogger(ItemsController.class);
	
	@Autowired
	private ItemsService itemsService;
	
	/**
	 * 设置viewname返回ModelAndView
	 */
//	@RequestMapping("/itemList.action")
//	public ModelAndView getItemList() {
//		System.out.println("hello world");
//		List<Items> itemsList = itemsService.getItemList();
//		
//		ModelAndView view = new ModelAndView();
//		view.setViewName("itemList");
//		view.addObject("itemList", itemsList);
//		return view;
//	}
	
	/**
	 * 设置viewname返回String
	 */
	@RequestMapping("/itemList.action")
	public String getItemList(Model model) {
		log.info("hello tomorrow");
		List<Items> itemsList = itemsService.getItemList();
		model.addAttribute("itemList", itemsList);
		// itemList为jsp文件名
		return "itemList";
	}
	
	/**
	 * 修改操作
	 * @param request
	 * @return
	 */
	@RequestMapping("/itemEdit.action")
	public String skipToEdit(Integer id, Model model) {
		log.info("hello tomorrow");
		Items items = itemsService.selectByPrimayKey(id);
		model.addAttribute("item", items);
		return "editItem";
	}
	
	/**
	 * 修改操作绑定pojo对象
	 */
	@RequestMapping("/updateitem.action")
	public String updateItem(@RequestBody Items items) {
//		log.info("request-name: " + request.getParameter("name"));
//		log.info("items.toString: " + items.toString());
		itemsService.updateByPrimaryKeySelective(items);
		return "success";
	}
}
