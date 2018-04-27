package com.ztf.backend.model;

import java.io.Serializable;

/**
 * 
 * @Title: UserModel.java
 * @Description:
 * @author zhaotf
 * @date 2018年4月27日 下午3:24:40
 */
public class UserModel implements Serializable {
	static final long serialVersionUID = 1L;
	private String id;
	private String username;
	private String pwd;

	public UserModel() {
	}

	public UserModel(String username, String pwd) {
		this.username = username;
		this.pwd = pwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
