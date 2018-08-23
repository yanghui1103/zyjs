package com.bw.fit.system.account.service;

import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.menu.model.Menu;
import com.bw.fit.system.organization.entity.TOrganization;
import com.bw.fit.system.organization.model.Organization;
import com.bw.fit.system.position.entity.TPosition;
import com.bw.fit.system.role.model.Role2Account;

public interface AccountService {

	/****
	 * 根据登录名获取账号信息 
	 * @param logName
	 * @return
	 */
	public Account getAccountByLogName(String logName);
	/*****
	 * 根据账号查询拥有的所有菜单
	 * @param logName 账号
	 * @return
	 */
	public List<Menu> getMenusOfThisAccount(String logName);
	/****
	 * 删除账户
	 * @param id
	 * @return
	 * @throws RbackException
	 */
	public JSONObject delete(String id) throws RbackException;
	/****
	 * 新增
	 * @param account
	 * @return
	 * @throws RbackException
	 */
	public JSONObject insert(Account account) throws RbackException;
	public Account get(String id);
	/****
	 * 获取此账号的岗位列表
	 * @param accountId
	 * @return
	 */
	public List<TPosition> getPositionsOfTheAccount(String accountId);
	/*****
	 * 获取此账号的岗位列表转化为字符串
	 * @param accountId
	 * @return
	 */
	public String getPositionStrOfTheAccount(String accountId);
	/******
	 * 此账号的数据权限级别下关联的组织，
	 * 及指定组织
	 * @param accountId
	 * @return
	 */
	public List<Organization> getDataAuthOrgsOfAccount(String accountId);
	/*****
	 * 过户账户至别的用户
	 * @param account
	 * @return
	 * @throws RbackException
	 */
	public JSONObject updateTransferAccount(Account account) throws RbackException;
	/*****
	 * 角色分配账号
	 * @param ra
	 * @return
	 * @throws RbackException
	 */
	public JSONObject updateRole2Account(Role2Account ra) throws RbackException;
}
