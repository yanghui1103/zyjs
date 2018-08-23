package com.bw.fit.system.role.entity;

import com.bw.fit.system.common.entity.BaseEntity;

public class TRole2Account extends BaseEntity {

	private String roleId;
	private String accountId;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
}
