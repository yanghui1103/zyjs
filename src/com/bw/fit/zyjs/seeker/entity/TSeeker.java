package com.bw.fit.zyjs.seeker.entity;

import com.bw.fit.system.common.entity.BaseEntity;

public class TSeeker extends BaseEntity {

	private String name;
	private String education ;
	private String language;
	private String languageLevel;
	private String wantPlace;
	private String email;
	private String workStatus;

	private String gender;
	private String huji;
	private String chuYear;
	private String minZu;
		
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHuji() {
		return huji;
	}
	public void setHuji(String huji) {
		this.huji = huji;
	}
	public String getChuYear() {
		return chuYear;
	}
	public void setChuYear(String chuYear) {
		this.chuYear = chuYear;
	}
	public String getMinZu() {
		return minZu;
	}
	public void setMinZu(String minZu) {
		this.minZu = minZu;
	}
	public String getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getLanguageLevel() {
		return languageLevel;
	}
	public void setLanguageLevel(String languageLevel) {
		this.languageLevel = languageLevel;
	}
	public String getWantPlace() {
		return wantPlace;
	}
	public void setWantPlace(String wantPlace) {
		this.wantPlace = wantPlace;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
