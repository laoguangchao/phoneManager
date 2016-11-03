package com.briup.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.Category;
import com.briup.cms.dao.ArticleDao;
import com.briup.cms.dao.CategoryDao;
import com.briup.cms.model.CategoryModel;
import com.briup.cms.service.IArticleService;

public class ArticleServiceImpl implements IArticleService {

	private ArticleDao articleDao = new ArticleDao();
	private CategoryDao categoryDao = new CategoryDao();
	@Override
	public void add(Article article) {
		articleDao.save(article);
	}

	@Override
	public void remove(long id) {
		
	}
 
	@Override
	public List<Article> list() {
		return articleDao.findAll();
	}
	
/*	@Override
	public Article findById(long id) {
		return articleDao.findById(id);
	}
*/
	@Override
	public Article findById(long id) {
		// TODO Auto-generated method stub
		return articleDao.findById(id);
	}

	
	@Override
	public void update(Article article) {
		// TODO Auto-generated method stub
		articleDao.update(article);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		articleDao.deleteById(id);
	}

	@Override
	public List<Article> listByCategory(long c_id) {
		//只根据c_id找
		return articleDao.query(null, null, c_id);
	}
	/**
	 * 浏览文章
	 *  
	 * */
	@Override
	public Article scanner(Long id) {
		// TODO Auto-generated method stub
		List<Article> list = articleDao.query(id, null, null);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<CategoryModel> listAll() {
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		
		List<Category> cs= categoryDao.findAll();
		for(Category c: cs){
			CategoryModel model = new CategoryModel();
			model.setCategory(c);
			List<Article> as = articleDao.query(null, null, c.getId());
			model.setArticles(as);
			list.add(model);
			
		}
		return list;
	}

}
