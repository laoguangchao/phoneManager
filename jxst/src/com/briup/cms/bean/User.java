package com.briup.cms.bean;

public class User {
	private String username;
	private Integer password;
	private String nickname;
	//构造函数
		public User() {
			
		}
		public User(String username,String nickname,Integer password){
			super();
			this.username = username;
			this.nickname=nickname;
			this.password = password;
		}
		public User(String username, Integer password) {
			super();
			this.username = username;
			this.password = password;
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
