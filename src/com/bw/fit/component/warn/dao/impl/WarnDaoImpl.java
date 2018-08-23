package com.bw.fit.component.warn.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.component.warn.dao.WarnDao;
import com.bw.fit.component.warn.entity.TWarn;
import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
@Repository
public class WarnDaoImpl implements WarnDao{
	@Autowired
	private DaoTemplete daoTemplete;
	@Override
	public List<TWarn> all(TWarn tw) {
		return daoTemplete.getListData("warnSql.all", tw);
	}
	@Override
	public void update(TWarn tw) throws RbackException {
		daoTemplete.update("warnSql.update", tw);
	}

}
