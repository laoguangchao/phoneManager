package com.briup.cms.service;
import java.util.List;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.Cellphone;
import com.briup.cms.bean.Category;
public interface ICellphoneService {
	//添加
	void add(Cellphone cellphone);
	//通过栏目查询
	List<Cellphone> listByCategory(long c_id);
	//查询
		List<Cellphone> list();
		//通过id查询
		Cellphone findById(long id);
		//修改手机产品信息
		void update(Cellphone cellphone);
		//删除
		void delete(Long id);
}
