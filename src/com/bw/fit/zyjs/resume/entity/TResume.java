package com.bw.fit.zyjs.resume.entity;

import com.bw.fit.system.common.entity.BaseEntity;

public class TResume extends BaseEntity {

	private String seekerId;
	private String jobName;  //职业名称
	private String major;
	private int years;
	private String backGround;
	private String welware;
	private String reward;
	private String evaluate;
	private String remark;
	
	
	public String getSeekerId() {
		return seekerId;
	}
	public void setSeekerId(String seekerId) {
		this.seekerId = seekerId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public String getBackGround() {
		return backGround;
	}
	public void setBackGround(String backGround) {
		this.backGround = backGround;
	}
	public String getWelware() {
		return welware;
	}
	public void setWelware(String welware) {
		this.welware = welware;
	}
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	
	


	
}
