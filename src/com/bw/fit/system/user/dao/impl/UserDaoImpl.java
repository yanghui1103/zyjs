package com.bw.fit.system.user.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.user.dao.UserDao; 
import com.bw.fit.system.user.entity.TUser;
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private DaoTemplete daoTemplete ;

	@Override
	public List<TUser> getUsers(TUser u) {
		return daoTemplete.getListData("userSql.getUsers", u);
	}

	@Override
	public TUser get(String id) {
		return (TUser)daoTemplete.getOneData("userSql.get", id);
	}
	

	@Override
	public TUser getByCode(String code) {
		return (TUser)daoTemplete.getOneData("userSql.getByCode", code);
	}

	@Override
	public void insert(TUser tu) throws RbackException {
		daoTemplete.insert("userSql.insert", tu);
	}

	@Override
	public void delete(String id) throws RbackException {
		daoTemplete.update("userSql.delete", id);
	}
	
	
	
}
