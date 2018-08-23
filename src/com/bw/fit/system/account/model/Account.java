package com.bw.fit.system.account.model;

import com.bw.fit.system.user.model.User;
/****
 * 账户模型
 * @author yangh
 *
 */
public class Account extends User{

	private String logName;
	private String logPwd;
	private String verificationCode;
	private String currentOrgId; /****归属组织id***/
	private String userId; 
	private String positionIds;
	private String roleIds;
	
	
	
	public String getPositionIds() {
		return positionIds;
	}
	public void setPositionIds(String positionIds) {
		this.positionIds = positionIds;
	}
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getVerificationCode() {
		return verificationCode;
	}
	public String getCurrentOrgId() {
		return currentOrgId;
	}
	public void setCurrentOrgId(String currentOrgId) {
		this.currentOrgId = currentOrgId;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	public String getLogPwd() {
		return logPwd;
	}
	public void setLogPwd(String logPwd) {
		this.logPwd = logPwd;
	}
	
	@Override
	public String toString() {
		return "Account [logName=" + logName + ", logPwd=" + logPwd
				+ ", verificationCode=" + verificationCode + ", currentOrgId="
				+ currentOrgId + ", userId=" + userId + ", positionIds="
				+ positionIds + ", roleIds=" + roleIds + "]";
	}
	
	
	
}
