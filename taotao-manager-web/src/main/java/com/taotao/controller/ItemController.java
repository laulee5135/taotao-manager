package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

/**
 * 商品管理控制层
 * @author LauLee
 *
 * 2017年7月9日
 */
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	/**
	 * 根据id查询单个商品
	 * @param itemId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/item/{itemId}")
	public TbItem getItemById(@PathVariable Long itemId){
		
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	
	/**
	 * 显示商品列表
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows){
		
		EasyUIDataGridResult dataGridResult = itemService.getItemList(page, rows);
		return dataGridResult;
	}

}
