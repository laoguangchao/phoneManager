package com.briup.cms.test;

import java.util.List;

import com.briup.cms.bean.Article;
import com.briup.cms.dao.ArticleDao;

public class DaoTest {
	public static void main(String[] args) {
		ArticleDao dao = new ArticleDao();
	//通过id为1的条件查
		//在bean加toString方法
		List<Article> list = dao.query(5L, null,null);
		//通过title为test和外键为long类型的2查询
		//List<Article> list = dao.query(null, "test", 2L);
		for(Article a : list){
			System.out.println(a);
		}
	}
}
