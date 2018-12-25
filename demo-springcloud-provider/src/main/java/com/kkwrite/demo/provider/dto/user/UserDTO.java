package com.kkwrite.demo.provider.dto.user;

import java.util.Date;

/** 
 * 类说明 
 *
 * @author Soosky Wang
 * @date 2018年12月25日 下午10:06:07 
 * @version 1.0.0
 */
public class UserDTO {

	private Long userId;
	private String username;
	private Integer age;
	private Date birthdate;
	
	public UserDTO() {
	}
	
	public UserDTO(Long userId, String username) {
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
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
}
