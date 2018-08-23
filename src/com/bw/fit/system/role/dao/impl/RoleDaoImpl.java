package com.bw.fit.system.role.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.authority.entity.TAuthority;
import com.bw.fit.system.authority.entity.TRole2dataauth;
import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.BaseModel;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.menu.model.Menu;
import com.bw.fit.system.role.dao.RoleDao;
import com.bw.fit.system.role.entity.TRole;
import com.bw.fit.system.role.entity.TRole2Authority;
import com.bw.fit.system.role.entity.TRole2dataauthOrgs;
@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private DaoTemplete daoTemplete;
	
	@Override
	public List<TAuthority> getAuthoritysByRole(String roleId) {
		return daoTemplete.getListData("roleSql.getAuthoritysByRole", roleId);
	}

	@Override
	public List<Menu> getMenusByRole(String roleId) {
		return daoTemplete.getListData("roleSql.getMenusByRole", roleId);
	}

	@Override
	public List<TRole> getRoles(TRole role) {
		List<TRole> list = daoTemplete.getListData("roleSql.getRoles", role);
		for (TRole t:list){
			t.setTemp_str1(String.valueOf((Integer)daoTemplete.getOneData("roleSql.getAccountCntOfRole",t.getId())));
		}
		return list ;
	}

	@Override
	public void delete(String id) throws RbackException {
		daoTemplete.update("roleSql.delete", id);
	}

	@Override
	public void insert(TRole trole) throws RbackException {
		daoTemplete.insert("roleSql.insert", trole);
	}

	@Override
	public List<TAuthority> getAuthsOfThisRole(String roleId) {
		return daoTemplete.getListData("roleSql.getAuthsOfThisRole", roleId);
	}

	@Override
	public TRole get(String id) {
		return (TRole)daoTemplete.getOneData("roleSql.get", id);
	}

	@Override
	public void grantAuthority2Role(TRole2Authority ta) throws RbackException {
		daoTemplete.insert("roleSql.insertAuthority2Role",ta);
	}

	@Override
	public void deleteAuthority2Role(TRole2Authority ta) throws RbackException {
		// TODO Auto-generated method stub
		daoTemplete.delete("roleSql.deleteAuthority2Role", ta);
	}

	@Override
	public List<TAuthority> getAuthority2Role(TRole2Authority ta) {
		return daoTemplete.getListData("roleSql.getAuthority2Role", ta);
	}

	@Override
	public TRole2dataauth getDataAuthoritysByRole(String roleId) {
		return (TRole2dataauth)daoTemplete.getOneData("roleSql.getDataAuthoritysByRole", roleId);
	}

	@Override
	public void grantDataAuthority2Role(BaseModel ta) throws RbackException {
		daoTemplete.insert("roleSql.grantDataAuthority2Role", ta);
	}

	@Override
	public void deleteDataAuthority2Role(String roleId) throws RbackException {
		daoTemplete.delete("roleSql.deleteDataAuthority2Role", roleId);
	}

	@Override
	public void deleteRole2Menus(String roleId) throws RbackException {
		daoTemplete.delete("roleSql.deleteRole2Menus", roleId);
	}

	@Override
	public List<Menu> getMenusOfRole(String roleId) {
		return daoTemplete.getListData("roleSql.getMenusOfRole", roleId);
	}

	@Override
	public void grantMenus2role(BaseModel ta) throws RbackException {
		daoTemplete.insert("roleSql.grantMenus2role", ta);
	}

	@Override
	public List<TRole> getAllRoles(String keyWords) {
		String name = keyWords ;
		return daoTemplete.getListData("roleSql.getAllRoles", name);
	}

	@Override
	public void deleteRoleDataAuthOrgs(String roleId) throws RbackException {
		daoTemplete.delete("roleSql.deleteRoleDataAuthOrgs", roleId);
	}

	@Override
	public void insertRoleDataAuthOrgs(BaseModel b) throws RbackException {
		daoTemplete.insert("roleSql.insertRoleDataAuthOrgs", b);
	}

	@Override
	public BaseModel getRoleDataAuthOrgs(String roleId)   {
		return (BaseModel)daoTemplete.getOneData("roleSql.getRoleDataAuthOrgs", roleId);
	}

	@Override
	public TRole2dataauthOrgs getTRole2dataauthOrgs(String roleId) {
		return (TRole2dataauthOrgs)daoTemplete.getOneData("roleSql.getTRole2dataauthOrgs", roleId);
	}

	@Override
	public List<Account> getAccountOfRole(String roleId) {
		return daoTemplete.getListData("roleSql.getAccountOfRole", roleId);
	}


}
