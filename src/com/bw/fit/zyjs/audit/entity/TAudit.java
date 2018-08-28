package com.bw.fit.zyjs.audit.entity;

import com.bw.fit.system.common.entity.BaseEntity;

public class TAudit extends BaseEntity {

	private String foreignId;
	private String code ;
	private String remark;
	
	public String getForeignId() {
		return foreignId;
	}
	public void setForeignId(String foreignId) {
		this.foreignId = foreignId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
