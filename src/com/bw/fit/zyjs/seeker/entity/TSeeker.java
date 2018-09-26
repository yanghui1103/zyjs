package com.bw.fit.zyjs.seeker.entity;

import com.bw.fit.system.common.entity.BaseEntity;

public class TSeeker extends BaseEntity {

	private String name;
	private String education ;
	private String language;
	private String languageLevel;
	private String wantPlace;
	private String email;
	
	
	
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
