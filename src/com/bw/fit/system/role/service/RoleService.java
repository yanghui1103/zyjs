package com.bw.fit.system.role.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.role.entity.TRole2Authority;
import com.bw.fit.system.role.entity.TRole2dataauthOrgs;
import com.bw.fit.system.role.model.Role;

public interface RoleService {

	/****
	 * 作废角色
	 * @param id
	 * @return
	 * @throws RbackException
	 */
	public JSONObject delete(String id) throws RbackException;
	/*****
	 * 增加
	 * @param role
	 * @return
	 * @throws RbackException
	 */
	public JSONObject insert(Role role) throws RbackException;
	/*****
	 * 角色赋权
	 * @param taa
	 * @return
	 * @throws RbackException
	 */
	public JSONObject grantAuthority2Role(TRole2Authority taa) throws RbackException;
	public JSONObject updateAuthsOfRole(String temp_str1,String[] id) throws RbackException;
	/*****
	 * 分配数据权限
	 * @param roleId
	 * @param authId
	 * rorgids 那些指定的组织
	 * @return
	 * @throws RbackException
	 */
	public JSONObject saveDataAuthsOfRole(String roleId,String authId,String rorgids)  throws RbackException;
	
	/****
	 * 角色分配菜单权限
	 * @param roleId
	 * @param menuIds
	 * @return
	 * @throws RbackException
	 */
	public JSONObject saverole2Menu(String roleId,String menuIds)  throws RbackException;
	/****
	 * 查询所有符合的角色
	 * @return
	 */
	public List<Role> getAllRoles(String keyWords);
	/*****
	 * 此角色下数据权限指定的别的组织 
	 * @param roleId
	 * @return
	 */
	public TRole2dataauthOrgs getTRole2dataauthOrgs(String roleId);
	/****
	 * 获取此角色分配得账号
	 * @param roleId
	 * @return
	 */
	public List<Account> getAccountOfRole(String roleId);
}
