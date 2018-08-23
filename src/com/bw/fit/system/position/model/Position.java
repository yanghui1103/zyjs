package com.bw.fit.system.position.model;

import java.util.List;

import com.bw.fit.system.common.model.BaseModel;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.organization.model.Organization;
/****
 * 岗位模型
 * @author jiaw
 *
 */
public class Position extends BaseModel{
	private String name;
	private String code ;
	private String simpleName;
	private Organization organization;
	private List<Account> accounts;
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
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	@Override
	public String toString() {
		return "Position [name=" + name + ", code=" + code + ", simpleName=" + simpleName + ", organization="
				+ organization + ", accounts=" + accounts + "]";
	}
	
	
}
