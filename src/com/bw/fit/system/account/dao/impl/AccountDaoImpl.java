package com.bw.fit.system.account.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.account.dao.AccountDao;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.organization.entity.TOrganization;
import com.bw.fit.system.position.entity.TPosition;
import com.bw.fit.system.role.entity.TRole;
import com.bw.fit.system.role.entity.TRole2Account;
import com.bw.fit.system.role.model.Role2Account;
import com.bw.fit.system.user.model.User;
import com.bw.fit.system.user.service.UserService;
@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private DaoTemplete daoTemplete;
	@Autowired
	private UserService userService;
	@Override
	public Account getAccount(String id) {
		return (Account)daoTemplete.getOneData("accountSql.getAccount", id);
	}

	@Override
	public Account getAccountByName(String logName) {
		Account account = new Account();
		account =  (Account)daoTemplete.getOneData("accountSql.getAccountIdByName", logName);
		String tempId = account.getId();
		User user = userService.get(account.getUserId());
		PubFun.copyProperties(account, user);
		account.setId(tempId);
		TOrganization org = getOrgByAccount(logName);
		account.setCurrentOrgId(org.getId());
		return account; 
	}

	@Override
	public List<TRole> getRolesByAccount(String logName) {
		return daoTemplete.getListData("accountSql.getRolesByAccount", logName);
	}

	@Override
	public TOrganization getOrgByAccount(String logName) {
		return (TOrganization)daoTemplete.getOneData("accountSql.getOrgByAccount", logName);
	}

	@Override
	public List<Account> getAccounts(Account account) {
		return daoTemplete.getListData("accountSql.getAccounts", account);
	}

	@Override
	public void delete(String id) throws RbackException {
		daoTemplete.update("accountSql.delete", id);
	}

	@Override
	public void insert(Account account) throws RbackException {
		daoTemplete.insert("accountSql.insert", account);
	}

	@Override
	public void insertAccount2Position(String accountId, String positionId)
			throws RbackException {
		Map<String,String> map = new HashMap<>();
		map.put("accountId", accountId);
		map.put("positionId", positionId);
		
		daoTemplete.insert("accountSql.insertAccount2Position", map);
	}

	@Override
	public void insertAccount2Org(String accountId, String orgId)
			throws RbackException {
		Map<String,String> map = new HashMap<>();
		map.put("accountId", accountId);
		map.put("orgId", orgId);
		daoTemplete.insert("accountSql.insertAccount2Org", map);
	}

	@Override
	public void insertAccount2Role(String accountId, String roleId)
			throws RbackException {
		Map<String,String> map = new HashMap<>();
		map.put("accountId", accountId);
		map.put("roleId", roleId);
		daoTemplete.insert("accountSql.insertAccount2Role", map);
	}

	@Override
	public List<TPosition> getPositionsOfTheAccount(String accountId) {
		return daoTemplete.getListData("accountSql.getPositionsOfTheAccount", accountId);
	}

	@Override
	public void transferAccount(Account account) throws RbackException {
		daoTemplete.update("accountSql.transferAccount", account);
	}

	@Override
	public void updateRole2Account(TRole2Account ra) throws RbackException {
		List list = daoTemplete.getListData("roleSql.getRole2Account", ra);
		if(list!=null ){
			daoTemplete.insert("roleSql.deleteRole2Account", ra);
		}
		daoTemplete.insert("roleSql.insertRole2Account", ra);
	}

}
