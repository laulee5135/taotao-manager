package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面显示Controller
 * @author LauLee
 *
 * 2017年7月9日
 */
@Controller
public class PageController {
	
	/**
	 * 显示首页
	 * @return
	 */
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	
	/**
	 * 显示其他页面
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	

}
