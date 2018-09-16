package com.bw.fit.zyjs.innerMail.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.innerMail.dao.MailDao;
import com.bw.fit.zyjs.innerMail.entity.TMail;
@Repository
public class MailDaoImpl implements MailDao{

	@Autowired
	private DaoTemplete daoTemplete;

	@Override
	public void insert(TMail tm) throws RbackException {
		daoTemplete.insert("mailSql.insert", tm);
	}
	
}
