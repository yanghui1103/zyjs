package com.bw.fit.system.organization.entity;

import com.bw.fit.system.common.entity.BaseEntity;

/****
 * 组织实体
 * @author yangh
 *
 */
public class TOrganization extends BaseEntity {
	private String name;
	private String code ;
	private String simpleName;
	private String type;
	private String isVisible;
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
		return "TOrganization [name=" + name + ", code=" + code
				+ ", simpleName=" + simpleName + ", type=" + type
				+ ", isVisible=" + isVisible + ", parentId=" + parentId
				+ ", adminer=" + adminer + ", phone=" + phone + ", address="
				+ address + ", postCode=" + postCode + ", summary=" + summary
				+ "]";
	}
	
	
}
