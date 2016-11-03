package com.briup.cms.web.action.manager;

import javax.swing.JOptionPane;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.User;
import com.briup.cms.service.IUserService;
import com.briup.cms.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String nickname;
	private Integer password;
	private IUserService userService = new UserServiceImpl();

	
	@Action(value = "register")
	public void addUser() {
		// 将接收到的参数进行封装，封装为一个对象
		User user = new User(username,nickname,password);
		userService.add(user);
		
	}

	
	@Action(value = "loginUser",results = { @Result(name = "loginsuccess", location = "/WEB-INF/jsp/manager/index.jsp")
	,@Result(name = "loginerro", location = "/WEB-INF/jsp/manager/login.jsp")})
	public String loginUser() {
		// 将接收到的参数进行封装，封装为一个对象
		
		User user = new User(username, password);
		user = userService.login(user);
		if (user == null) { // 登录失败
			JOptionPane.showMessageDialog(null,
					"登录失败!", "系统信息", JOptionPane.INFORMATION_MESSAGE);
			return "loginerro";

		} else {
			
			return "loginsuccess";
			

		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
	
