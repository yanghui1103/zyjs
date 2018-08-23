package com.bw.fit.system.menu.model;

import com.bw.fit.system.common.model.BaseModel;

public class Menu extends BaseModel {

	private String title ;
	private String parentId;
	private String href;
	private String icon;
	private String opened; 
	private boolean isCurrent;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getOpened() {
		return opened;
	}
	public void setOpened(String opened) {
		this.opened = opened;
	}
	public boolean isCurrent() {
		if("true".equals(this.opened)){
			return true;
		}else{
			return false;
		}
	}
	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	@Override
	public String toString() {
		return "Menu [title=" + title + ", parentId=" + parentId + ", href="
				+ href + ", icon=" + icon + ", opened=" + opened
				+ ", isCurrent=" + isCurrent + "]";
	}
	
	
	
}
