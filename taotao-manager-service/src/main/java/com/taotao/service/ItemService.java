package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	
	TbItem getItemById(long itemId);
	EasyUIDataGridResult getItemList(int total, int rows);

}
