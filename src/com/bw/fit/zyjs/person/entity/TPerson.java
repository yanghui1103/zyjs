package com.bw.fit.zyjs.person.entity;

import com.bw.fit.system.common.entity.BaseEntity;

public class TPerson extends BaseEntity {

	private String phone;
	private String area;
	private String name;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	
}
