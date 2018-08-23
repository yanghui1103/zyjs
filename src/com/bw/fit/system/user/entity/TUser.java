package com.bw.fit.system.user.entity;

import com.bw.fit.system.common.entity.BaseEntity;

public class TUser extends BaseEntity {

	private String name;
	private String name_pinyin;
	private String code;
	private String gender;
	private String card;
	private String type;
	private String isVisible;
	private String email;
	private String phone;
	private String address;
	private String postCode;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName_pinyin() {
		return name_pinyin;
	}
	public void setName_pinyin(String name_pinyin) {
		this.name_pinyin = name_pinyin;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIsVisible() {
		return isVisible;
	}
	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	@Override
	public String toString() {
		return "TUser [name=" + name + ", name_pinyin=" + name_pinyin
				+ ", code=" + code + ", gender=" + gender + ", card=" + card
				+ ", type=" + type + ", isVisible=" + isVisible + ", email="
				+ email + ", phone=" + phone + ", address=" + address
				+ ", postCode=" + postCode + "]";
	}
	
	
}
