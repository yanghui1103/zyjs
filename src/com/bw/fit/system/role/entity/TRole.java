package com.bw.fit.system.role.entity;

import com.bw.fit.system.common.entity.BaseEntity;
/****
 * 角色实体
 * @author yangh
 *
 */
public class TRole extends BaseEntity {

	private String name;
	private String desp ;
	
	
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
		return "TRole [name=" + name + ", desp=" + desp + "]";
	}
	
}
