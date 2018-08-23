package com.bw.fit.system.role.model;

import java.util.List;

import com.bw.fit.system.authority.entity.TAuthority;
import com.bw.fit.system.common.model.BaseModel;
import com.bw.fit.system.menu.model.Menu;

/****
 * 角色领域模型
 * @author yangh
 *
 */
public class Role extends BaseModel {

	private String name;
	private String desp ;
	
	private List<TAuthority> authoritys;  // 所关联功能权限 
	private String dataAuth;		//数据权限
	private List<Menu> menus;		// 所关联菜单
	
	
	public List<TAuthority> getAuthoritys() {
		return authoritys;
	}
	public void setAuthoritys(List<TAuthority> authoritys) {
		this.authoritys = authoritys;
	}
	public String getDataAuth() {
		return dataAuth;
	}
	public void setDataAuth(String dataAuth) {
		this.dataAuth = dataAuth;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
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
		return "Role [name=" + name + ", desp=" + desp + ", authoritys="
				+ authoritys + ", dataAuth=" + dataAuth + ", menus=" + menus
				+ "]";
	}
	
}
