package com.bw.fit.system.account.model;

import org.hibernate.validator.constraints.NotEmpty;

public class LogAccount {
	@NotEmpty(message="账号不得为空")
	private String logName;
	@NotEmpty(message="密码不得为空")
	private String logPwd;
	private String verificationCode;
	
	
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
	public String getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	@Override
	public String toString() {
		return "LogAccount [logName=" + logName + ", logPwd=" + logPwd
				+ ", verificationCode=" + verificationCode + "]";
	}
	
}
