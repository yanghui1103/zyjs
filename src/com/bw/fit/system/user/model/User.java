package com.bw.fit.system.user.model;

import org.hibernate.validator.constraints.NotEmpty;

import com.bw.fit.system.common.model.BaseModel;

/****
 * 用户模型
 * @author yangh
 *
 */
public class User  extends BaseModel{

	@NotEmpty(message="姓名不得为空")
	private String name;
	private String name_pinyin;
	@NotEmpty(message="编码不得为空")
	private String code;
	@NotEmpty(message="性别不得为空")
	private String gender;
	@NotEmpty(message="身份证号码不得为空")
	private String card;
	@NotEmpty(message="人员类型不得为空")
	private String type;
	private String isVisible;
	private String email;
	@NotEmpty(message="联系电话不得为空")
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
		return "User [name=" + name + ", name_pinyin=" + name_pinyin
				+ ", code=" + code + ", gender=" + gender + ", card=" + card
				+ ", type=" + type + ", isVisible=" + isVisible + ", email="
				+ email + ", phone=" + phone + ", address=" + address
				+ ", postCode=" + postCode + "]";
	}
	
	
	
	
}
