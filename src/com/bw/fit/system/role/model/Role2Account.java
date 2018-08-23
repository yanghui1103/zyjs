package com.bw.fit.system.role.model;

import com.bw.fit.system.common.model.BaseModel;
/****
 * 角色分配账号
 * @author yangh
 *
 */
public class Role2Account extends BaseModel {
	
	private String roleId;
	private String accountIds;
	
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getAccountIds() {
		return accountIds;
	}
	public void setAccountIds(String accountIds) {
		this.accountIds = accountIds;
	}
	
	
}
