package com.briup.cms.web.action.manager;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.Cellphone;
import com.briup.cms.bean.Category;
import com.briup.cms.service.ICellphoneService;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.service.impl.CellphoneServiceImpl;
import com.briup.cms.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
public class CellphoneAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ICategoryService categoryService
	= new CategoryServiceImpl();
	private ICellphoneService cellphoneService = 
			new CellphoneServiceImpl();
	
	private List<Category> cateogryList;
	private List<Cellphone> cellphoneList;
	
	private Long id;		//编号
	private String name;	//产品名称
	private Float price;
	private Long c_id;
	private String information;
	private Cellphone cellphone;
	
	//删除delCellphone
	@Action(value="delCellphone")
	public void delCellphone(){
		cellphoneService.delete(id);
	}
	//修改的处理action
	@Action(value="updateCellphone")
	public void updateCellphone(){
		//将接收到的参数进行封装，封装为一个对象
		Cellphone cellphone = new Cellphone(name,price,information);
		cellphone.setC_id(c_id);
		cellphone.setId(id);
		cellphoneService.update(cellphone);
	}
	//跳转到修改栏目界面
			@Action(value="toUpdateCellphone",results={
					@Result(name="success",location="/WEB-INF/jsp/manager/updateCellphone.jsp")})
			public String toUpdateCellphone(){
				//调用service层的方法查询要修改的栏目信息
				
				cellphone=cellphoneService.findById(id);
				//将Category的栏目信息传到下拉列表
				cateogryList = categoryService.list();
				return "success";
			}
	
	//跳到手机产品信息管理页面
	@Action(value="toCellphoneManager",
			results={@Result(name="success",
			location="/WEB-INF/jsp/manager/cellphoneManager.jsp")})
	public String toCellphoneManager(){
		cellphoneList=cellphoneService.list();
		return SUCCESS;
	}
	//跳到添加手机产品信息页面
	@Action(value="toAddCellphone",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/addCellphone.jsp")})
	public String toAddCellphone(){
		//
		//将Category的栏目信息传到下拉列表
		//
		cateogryList = categoryService.list();
		return "success";
	}
			
	@Action("addCellphone")
	public void addCellphone(){
		Cellphone cellphone = new Cellphone();
		cellphone.setName(name);
		cellphone.setPrice(price);
		cellphone.setC_id(c_id);
		cellphone.setInformation(information);
		cellphoneService.add(cellphone);
	}

	public List<Category> getCateogryList() {
		return cateogryList;
	}

	public void setCateogryList(List<Category> cateogryList) {
		this.cateogryList = cateogryList;
	}

	public List<Cellphone> getCellphoneList() {
		return cellphoneList;
	}

	public void setCellphoneList(List<Cellphone> cellphoneList) {
		this.cellphoneList = cellphoneList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public Cellphone getCellphone() {
		return cellphone;
	}

	public void setCellphone(Cellphone cellphone) {
		this.cellphone = cellphone;
	}

	
}
