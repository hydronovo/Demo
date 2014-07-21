package com.example.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "User")
public class User {

	private String	id;
	private String	username;
	private String	password;
	private Date	createTime;
	private Date	expireTime;

	@Column(name = "id", nullable = false, unique = true)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "createTime")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "expireTime")
	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
}