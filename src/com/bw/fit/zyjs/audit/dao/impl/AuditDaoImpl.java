package com.bw.fit.zyjs.audit.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.audit.dao.AuditDao;
import com.bw.fit.zyjs.audit.entity.TAudit;
@Repository
public class AuditDaoImpl implements AuditDao {
	@Autowired
	private DaoTemplete daoTemplete;

	@Override
	public void create(TAudit ta) throws RbackException {
		daoTemplete.insert("auditSql.create", ta);
	}

}
