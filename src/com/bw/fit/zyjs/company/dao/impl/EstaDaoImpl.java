package com.bw.fit.zyjs.company.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.company.dao.EstaDao;
import com.bw.fit.zyjs.company.entity.TEsta;
import com.github.pagehelper.PageHelper;
@Repository
public class EstaDaoImpl implements EstaDao {
	@Autowired
	private DaoTemplete daoTemplete;
	
	@Override
	public List<TEsta> selectAll(TEsta te) {
		PageHelper.startPage(te.getPage(), te.getRows()); 
		return daoTemplete.getListData("estaSql.selectAll", te);
	}

	@Override
	public void updateExtenalUserStatus(String id, String isdeleted,String tableName)
			throws RbackException {
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		map.put("isdeleted", isdeleted);
		map.put("tableName", tableName);
		daoTemplete.update("estaSql.updateExtenalUserStatus", map);
	}

	@Override
	public String getExtenalType(String id) {
		TEsta te = (TEsta)daoTemplete.getOneData("estaSql.getExtenalType", id);
		return (te!=null)?te.getTemp_str1():"";
	}

	@Override
	public TEsta get(String id) {
		return (TEsta)daoTemplete.getOneData("estaSql.get", id);
	}

	@Override
	public void initPasswd(String id, String passwdmm)throws RbackException {
		TEsta te = (TEsta)daoTemplete.getOneData("estaSql.getExtenalType", id);
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		map.put("tableName", te.getTemp_str1());
		map.put("pwd", passwdmm);
		daoTemplete.update("estaSql.initPasswd", map);
	}

	@Override
	public TEsta getSubject(String id) {
		return (TEsta)daoTemplete.getOneData("estaSql.getSubject", id);
	}

	@Override
	public TEsta getOne(String id) {
		return (TEsta)daoTemplete.getOneData("estaSql.getOne", id);
	}

}
