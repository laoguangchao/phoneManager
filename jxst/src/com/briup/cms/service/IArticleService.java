package com.briup.cms.service;

import java.util.List;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.Category;
import com.briup.cms.model.CategoryModel;

public interface IArticleService {
	//添加
	void add(Article article);
	//删除
	void remove(long id);
	//查询
	List<Article> list();
	//通过id查询
	Article findById(long id);
	//通过栏目查询,添加到前台首页
	List<Article> listByCategory(long c_id);
	//修改
	void update(Article article);
	//删除
	void delete(long id);
	//
	Article scanner(Long id);
	
	//查询所有
		List<CategoryModel> listAll();
	
}
