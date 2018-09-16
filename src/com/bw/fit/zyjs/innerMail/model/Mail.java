package com.bw.fit.zyjs.innerMail.model;

import org.hibernate.validator.constraints.NotEmpty;

import com.bw.fit.system.common.model.BaseModel;

public class Mail extends BaseModel {

	private String type;
	@NotEmpty(message="目标用户不能为空")
	private String objId;
	private String isRead;
	@NotEmpty(message="站内信息不得为空")
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
