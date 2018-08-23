package com.bw.fit.system.organization.model;

import org.hibernate.validator.constraints.NotEmpty;

import com.bw.fit.system.common.model.BaseModel;
/****
 * 组织模型
 * @author yangh
 *
 */
public class Organization extends BaseModel{

	@NotEmpty(message="组织名称不得为空")
	private String name;
	@NotEmpty(message="组织编码不得为空")
	private String code ;
	private String simpleName;
	@NotEmpty(message="类型不得为空")
	private String type;
	private String isVisible;
	@NotEmpty(message="父组织不得为空")
	private String parentId;
	private String adminer;
	private String phone;
	private String address;
	private String postCode;
	private String summary;
	
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
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getAdminer() {
		return adminer;
	}
	public void setAdminer(String adminer) {
		this.adminer = adminer;
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSimpleName() {
		return simpleName;
	}
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
	@Override
	public String toString() {
		return "Organization [name=" + name + ", code=" + code
				+ ", simpleName=" + simpleName + ", type=" + type
				+ ", isVisible=" + isVisible + ", parentId=" + parentId
				+ ", adminer=" + adminer + ", phone=" + phone + ", address="
				+ address + ", postCode=" + postCode + ", summary=" + summary
				+ "]";
	}
	
	
	
}
