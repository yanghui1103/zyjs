package com.bw.fit.zyjs.wrong.entity;

import com.bw.fit.system.common.entity.BaseEntity;

/****
 * 举报，实体
 * @author yangh
 *
 */
public class TWrong extends BaseEntity {
	private String remark;
	private String otherId;
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOtherId() {
		return otherId;
	}
	public void setOtherId(String otherId) {
		this.otherId = otherId;
	}
	
}
