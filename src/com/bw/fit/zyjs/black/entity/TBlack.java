package com.bw.fit.zyjs.black.entity;

import com.bw.fit.system.common.entity.BaseEntity;

public class TBlack extends BaseEntity {

	private String objId;
	private String oType;
	private String reason;
	private String area ;
	
	
	
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getObjId() {
		return objId;
	}
	public void setObjId(String objId) {
		this.objId = objId;
	}
	public String getoType() {
		return oType;
	}
	public void setoType(String oType) {
		this.oType = oType;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
