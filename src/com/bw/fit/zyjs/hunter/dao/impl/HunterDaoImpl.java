package com.bw.fit.zyjs.hunter.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.hunter.dao.HunterDao;
import com.bw.fit.zyjs.hunter.entity.THunter;
@Repository
public class HunterDaoImpl implements HunterDao {
	@Autowired
	private DaoTemplete daoTemplete;

	@Override
	public THunter get(String id) {
		return (THunter)daoTemplete.getOneData("hunterSql.get", id);
	}

	@Override
	public List<THunter> selectAll(THunter th) {
		return daoTemplete.getListData("hunterSql.selectAll", th);
	}

	@Override
	public void update(THunter hunter) throws RbackException {
		daoTemplete.update("hunterSql.update", hunter);
	}

	@Override
	public List<THunter> huntersOfFair(String fairId) {
		return daoTemplete.getListData("hunterSql.huntersOfFair", fairId);
	}
	

}
