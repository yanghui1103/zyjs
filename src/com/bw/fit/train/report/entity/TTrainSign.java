package com.bw.fit.train.report.entity;

import com.bw.fit.system.common.entity.BaseEntity;

public class TTrainSign extends BaseEntity {

	private String personName ;
	private String age;
	private String phone;
	private String workType;
	private String isWorking;
	private String companyName;
	private String personNum;
	
	
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public String getIsWorking() {
		return isWorking;
	}
	public void setIsWorking(String isWorking) {
		this.isWorking = isWorking;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPersonNum() {
		return personNum;
	}
	public void setPersonNum(String personNum) {
		this.personNum = personNum;
	}
	

}
