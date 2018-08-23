package com.bw.fit.system.role.entity;

import com.bw.fit.system.common.entity.BaseEntity;
/****
 * 角色数据权限指定的其他组织
 * @author yangh
 *
 */
public class TRole2dataauthOrgs extends BaseEntity {

	private String roleId;
	private String orgIds ;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getOrgIds() {
		return orgIds;
	}
	public void setOrgIds(String orgIds) {
		this.orgIds = orgIds;
	}
	
}
