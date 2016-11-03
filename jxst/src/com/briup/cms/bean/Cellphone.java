package com.briup.cms.bean;

import java.util.Date;

public class Cellphone {
	private Long id;		//编号
	private String name;	//产品名称
	private Float price;
	private Long c_id; //外键  该手机信息属于哪个栏目
	private String information;
	
	public Cellphone(){
		
	}
	public  Cellphone(String name, Float price, String information){
		super();
		this.name=name;
		this.price=price;
		this.information=information;
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
	
}
