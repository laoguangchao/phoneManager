package com.briup.cms.service.impl;

import java.util.List;

import com.briup.cms.bean.Cellphone;
import com.briup.cms.dao.CategoryDao;
import com.briup.cms.dao.CellphoneDao;
import com.briup.cms.service.ICellphoneService;

public class CellphoneServiceImpl implements ICellphoneService {
	
	//声明与定义
	private CellphoneDao cellphoneDao = new CellphoneDao();
	
	
	@Override
	public void add(Cellphone cellphone) {
		// TODO Auto-generated method stub
		cellphoneDao.save(cellphone);
	}

	@Override
	public List<Cellphone> listByCategory(long c_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cellphone> list() {
		// TODO Auto-generated method stub
		return cellphoneDao.findAll();
	}

	@Override
	public Cellphone findById(long id) {
		// TODO Auto-generated method stub
		return cellphoneDao.findById(id);
	}

	@Override
	public void update(Cellphone cellphone) {
		// TODO Auto-generated method stub
		cellphoneDao.update(cellphone);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		cellphoneDao.deleteById(id);
	}

}
