package com.bw.fit.zyjs.fine.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.fine.dao.FineDao;
import com.bw.fit.zyjs.fine.entity.TFine;
import com.github.pagehelper.PageHelper;

@Repository
public class FineDaoImpl implements FineDao{

	@Autowired
	private DaoTemplete daoTemplete ;
	
	@Override
	public List<TFine> selectAll(TFine fine) {
		PageHelper.startPage(fine.getPage(), fine.getRows());
		return daoTemplete.getListData("fineSql.selectAll", fine);
	}

	@Override
	public void update(TFine fine) throws RbackException {
		daoTemplete.update("fineSql.update", fine);
	}

	@Override
	public void insert(TFine fine) throws RbackException {
		daoTemplete.insert("fineSql.insert", fine);
	}

	
}
