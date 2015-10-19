package com.ycy.model;

import java.util.List;

public class QueryVo {
	
	private User user;
	
	//自定义用户扩展类
	private UserCustom userCustom;
	
	//传递多个用户id
	private List<Integer> ids;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}



}
