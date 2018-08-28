package com.bw.fit.zyjs.seeker.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.zyjs.seeker.dao.SeekerDao;
import com.bw.fit.zyjs.seeker.entity.TSeeker;
@Repository
public class SeekerDaoImpl implements SeekerDao {

	@Autowired
	private DaoTemplete daoTemplete;

	@Override
	public List<TSeeker> selectAll(TSeeker s) {
		return daoTemplete.getListData("seekerSql.all", s);
	}
	
}
