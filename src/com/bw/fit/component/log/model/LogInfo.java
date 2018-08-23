package com.bw.fit.component.log.model;

import com.bw.fit.system.common.model.BaseModel;

/*****
 * 日志组件：日志的领域模型
 * @author yangh
 *
 */
public class LogInfo extends BaseModel{

	private String params; 
	private String result; 
	private String logType ; // 日志类型
	private String operateFunction ;
	private String resourceId ;  // 被操作的目标资源fdid集合
	private String ip;
	private String url;
		
	
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	public String getOperateFunction() {
		return operateFunction;
	}
	public void setOperateFunction(String operateFunction) {
		this.operateFunction = operateFunction;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
