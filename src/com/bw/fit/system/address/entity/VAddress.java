package com.bw.fit.system.address.entity;

import com.bw.fit.system.common.entity.BaseEntity;

public class VAddress extends BaseEntity{
	private String name;
	private String addressType;
	private String underOrgId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getUnderOrgId() {
		return underOrgId;
	}
	public void setUnderOrgId(String underOrgId) {
		this.underOrgId = underOrgId;
	}
	@Override
	public String toString() {
		return "VAddress [name=" + name + ", addressType=" + addressType + ", underOrgId=" + underOrgId + "]";
	}
	
}
