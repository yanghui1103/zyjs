package com.bw.fit.system.role.entity;

import com.bw.fit.system.common.entity.BaseEntity;

public class TRole2Authority extends BaseEntity {

	private String roleId;
	private String authorityId;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}
	@Override
	public String toString() {
		return "TRole2Authority [roleId=" + roleId + ", authorityId="
				+ authorityId + "]";
	}
	
}
