package com.bw.fit.system.position.entity;

import com.bw.fit.system.common.entity.BaseEntity;

public class TPosition extends BaseEntity{
	private String name;
	private String code ;
	private String simpleName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSimpleName() {
		return simpleName;
	}
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
	@Override
	public String toString() {
		return "TPosition [name=" + name + ", code=" + code + ", simpleName=" + simpleName + "]";
	}
	
}
