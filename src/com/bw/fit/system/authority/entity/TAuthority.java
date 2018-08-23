package com.bw.fit.system.authority.entity;

import com.bw.fit.system.common.entity.BaseEntity;

public class TAuthority  extends BaseEntity{

	private String code;
	private String name;
	private String desp ;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
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
	@Override
	public String toString() {
		return "TAuthority [code=" + code + ", name=" + name + ", desp=" + desp
				+ "]";
	}
	
}
