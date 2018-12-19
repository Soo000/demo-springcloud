package com.kkwrite.demo.provider.entity;

import java.util.Date;

public class BaseEntity {

	private Date creationTime;
	private String creator;
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
}
