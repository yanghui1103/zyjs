package com.bw.fit.zyjs.fair.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.fair.dao.FairDao;
import com.bw.fit.zyjs.fair.entity.TFair;
@Repository
public class FairDaoImpl implements FairDao {

	@Autowired
	private DaoTemplete daoTemplete;
	
	@Override
	public void insert(TFair tf) throws RbackException {
		daoTemplete.insert("fairSql.create", tf);
	}

}
