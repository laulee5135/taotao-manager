package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.service.ItemService;

/**
 * 商品管理service
 * @author LauLee
 *
 * 2017年7月9日
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper itemMapper;

	/**
	 * 根据商品id获取单个商品对象
	 */
	@Override
	public TbItem getItemById(long itemId) {
		//第一种写法：
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		//第二种写法：
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> itemList = itemMapper.selectByExample(example);
		if (null!=itemList && itemList.size()>0) {
			TbItem tbItem = itemList.get(0);
			return tbItem;
		}
		return null;
	}

	/**
	 * 分页查询
	 * page 第几页
	 * rows 每页显示的条数
	 */
	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		//查询商品列表
		TbItemExample example = new TbItemExample(); 
		//分页处理
		PageHelper.startPage(page, rows);  //此工具的执行原理是：在executor执行器之前，mapperstatement之后执行的（mybaits执行SQL的语句的时候会先将SQL语句封装为mapperstatement对象，然后再由executor执行器执行）
		List<TbItem> itemList = itemMapper.selectByExample(example);
		
		//创建一个返回值对象
		EasyUIDataGridResult dataGridEesult = new EasyUIDataGridResult();
		dataGridEesult.setRows(itemList);
		//取总记录数
		PageInfo<TbItem> pageInfo = new PageInfo<>(itemList);
		dataGridEesult.setTotal(pageInfo.getTotal());
		
		return dataGridEesult;
	}

}
