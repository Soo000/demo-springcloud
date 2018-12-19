package com.kkwrite.demo.provider.entity.user;

import java.util.Date;

import com.kkwrite.demo.provider.entity.BaseEntity;

public class User extends BaseEntity {

	private Integer userId;
	private String username;
	private Integer age;
	private Date birthdate;
	
	public User() {
	}
	
	public User(Integer userId, String username) {
		this.userId = userId;
		this.username = username;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
}
