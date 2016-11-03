package com.briup.cms.service;

import java.util.List;

import com.briup.cms.bean.Category;

/**
 * 栏目管理的业务逻辑
 * */
public interface ICategoryService {
	//添加栏目
	void add(Category category);
	//列出所有栏目
	List<Category> list();
	//删除栏目
	void delete(long id);
	
	//通过id获取栏目信息
	Category findById(long id);
	//修改栏目信息
	void update(Category category);
	
}
