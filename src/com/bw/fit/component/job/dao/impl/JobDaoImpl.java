package com.bw.fit.component.job.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.component.job.dao.JobDao;
import com.bw.fit.component.job.entity.TJob;
import com.bw.fit.system.common.dao.DaoTemplete;
@Repository
public class JobDaoImpl implements JobDao {

	@Autowired
	private DaoTemplete daoTemplete;
	
	@Override
	public List<TJob> all(TJob tb) {
		return daoTemplete.getListData("jobSql.all", tb);
	}

	@Override
	public TJob get(String id) {
		return (TJob)daoTemplete.getOneData("jobSql.get", id);
	}

}
