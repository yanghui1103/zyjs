package com.bw.fit.system.position.entity;

import com.bw.fit.system.common.entity.BaseEntity;

public class TOrganization2Position extends BaseEntity{
	private String orgId;
	private String positionId;
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getPositionId() {
		return positionId;
	}
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}
	@Override
	public String toString() {
		return "TOrganization2Position [orgId=" + orgId + ", positionId=" + positionId + "]";
	}
	
	
}
