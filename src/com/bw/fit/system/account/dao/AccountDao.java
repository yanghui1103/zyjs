package com.bw.fit.system.account.dao;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.organization.entity.TOrganization;
import com.bw.fit.system.position.entity.TPosition;
import com.bw.fit.system.role.entity.TRole;
import com.bw.fit.system.role.entity.TRole2Account;
import com.bw.fit.system.role.model.Role2Account;

public interface AccountDao {

	/*****
	 * 获取账号信息
	 * @param id
	 * @return
	 */
	public Account getAccount(String id);
	/*****
	 * 根据登录名，获取账号
	 * @param logName
	 * @return
	 */
	public Account getAccountByName(String logName);
	/****
	 * 获取其所有的角色
	 * @param logName
	 * @return
	 */
	public List<TRole> getRolesByAccount(String logName);
	/****
	 *查询账号所属组织
	 * @param logName
	 * @return
	 */
	public TOrganization getOrgByAccount(String logName);
	/*****
	 * 根据查询条件,查询到账户资料
	 * @param account
	 * @return
	 */
	public List<Account> getAccounts(Account account);
	/*****
	 * 删除帐户 
	 * @param id
	 * @throws RbackException
	 */
	public void delete(String id) throws RbackException ;
	/*****
	 * add帐户 
	 * @param id
	 * @throws RbackException
	 */
	public void insert(Account account) throws RbackException ;
	/****
	 * 账户与岗位
	 * @param accountId
	 * @param positionId
	 * @throws RbackException
	 */
	public void insertAccount2Position(String accountId,String positionId) throws RbackException ;
	/****
	 * 账户与组织
	 * @param accountId
	 * @param orgId
	 * @throws RbackException
	 */
	public void insertAccount2Org(String accountId,String orgId) throws RbackException ;
	/***
	 * 账户与角色
	 * @param accountId
	 * @param roleId
	 * @throws RbackException
	 */
	public void insertAccount2Role(String accountId,String roleId) throws RbackException ;
	/****
	 * 获取此账号的岗位列表
	 * @param accountId
	 * @return
	 */
	public List<TPosition> getPositionsOfTheAccount(String accountId);
	/*****
	 * 过户账户至别的用户
	 * @param account
	 * @return
	 * @throws RbackException
	 */
	public void transferAccount(Account account) throws RbackException;
	/*****
	 * 角色分配账号
	 * @param ra
	 * @throws RbackException
	 */
	public void updateRole2Account(TRole2Account ra) throws RbackException;
	
}
