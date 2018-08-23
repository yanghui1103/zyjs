package com.bw.fit.component.warn.entity;

import com.bw.fit.system.common.entity.BaseEntity;

/****
 * 通知实体
 * @author yangh
 *
 */
public class TWarn extends BaseEntity{

	private String title ;
	private String content;
	private String url;
	private String tLevel;
	private String modes;
	private String runner;
	private String runTime;
	private String result;
	private String target_number ;
	
	
	
	
	public String getTarget_number() {
		return target_number;
	}
	public void setTarget_number(String target_number) {
		this.target_number = target_number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String gettLevel() {
		return tLevel;
	}
	public void settLevel(String tLevel) {
		this.tLevel = tLevel;
	}
	public String getModes() {
		return modes;
	}
	public void setModes(String modes) {
		this.modes = modes;
	}
	public String getRunner() {
		return runner;
	}
	public void setRunner(String runner) {
		this.runner = runner;
	}
	public String getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
}
