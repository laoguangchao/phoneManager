package com.briup.cms.web.action.manager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * 跳转到后台首页
	 * ip:port/命名空间/url
	 * http://localhost:8888/manager/toIndex.action
	 * */
	@Action(value="toLogin",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/login.jsp")})
	public String toLogin(){

		return "success";
	}
	
	@Action(value="toIndex",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/index.jsp")})
	public String toIndex(){
		return "success";
	}
	
}
