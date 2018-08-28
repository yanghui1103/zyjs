package com.bw.fit.zyjs.person.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.zyjs.person.dao.PersonDao;
import com.bw.fit.zyjs.person.entity.TPerson;
@Repository
public class PersonImpl implements PersonDao {

	@Autowired
	private DaoTemplete daoTemplete;
	
	@Override
	public TPerson get(String id) {
		return (TPerson)daoTemplete.getOneData("personSql.get", id);
	}

}
