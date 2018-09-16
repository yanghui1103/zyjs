package com.bw.fit.zyjs.innerMail.entity;

import com.bw.fit.system.common.entity.BaseEntity;

public class TMail  extends BaseEntity{

	private String type;
	private String objId;
	private String isRead;
	private String remark;
	
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getObjId() {
		return objId;
	}
	public void setObjId(String objId) {
		this.objId = objId;
	}
	public String getIsRead() {
		return isRead;
	}
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
