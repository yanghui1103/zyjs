package com.bw.fit.component.job.entity;

import com.bw.fit.system.common.entity.BaseEntity;

/*****
 * 定时任务实体
 * @author yangh
 *
 */
public class TJob extends BaseEntity{

	private String name;
	private String desp ;
	private String runTime;
	private String isValid;
	private String codeData;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesp() {
		return desp;
	}
	public void setDesp(String desp) {
		this.desp = desp;
	}
	public String getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	public String getCodeData() {
		return codeData;
	}
	public void setCodeData(String codeData) {
		this.codeData = codeData;
	}
	
}
