package com.bw.fit.system.authority.entity;

import com.bw.fit.system.common.entity.BaseEntity;

public class TRole2dataauth  extends BaseEntity{

	private String roleId;
	private String authId;
	
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	@Override
	public String toString() {
		return "TRole2dataauth [roleId=" + roleId + ", authId=" + authId + "]";
	}
	
}
