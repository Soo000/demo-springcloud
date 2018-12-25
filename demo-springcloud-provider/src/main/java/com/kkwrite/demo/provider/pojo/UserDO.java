package com.kkwrite.demo.provider.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserDO extends BaseDO {

	private static final long serialVersionUID = 3289865486522416549L;
	
	@Id
    @Column(name = "user_id")
	private Long userId;
	private String username;
	private Integer age;
	
	public UserDO() {
	}
	
	public UserDO(Long userId, String username) {
		this.userId = userId;
		this.username = username;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
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
	
}
