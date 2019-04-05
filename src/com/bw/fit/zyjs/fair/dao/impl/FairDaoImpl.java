package com.bw.fit.zyjs.fair.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.fair.dao.FairDao;
import com.bw.fit.zyjs.fair.entity.TFair;
import com.bw.fit.zyjs.fair.entity.TJobp;
import com.bw.fit.zyjs.hunter.entity.THunter;
import com.github.pagehelper.PageHelper;
@Repository
public class FairDaoImpl implements FairDao {

	@Autowired
	private DaoTemplete daoTemplete;
	
	@Override
	public void insert(TFair tf) throws RbackException {
		daoTemplete.insert("fairSql.create", tf);
	}

	@Override
	public List<TFair> all(TFair t) {
		PageHelper.startPage(t.getPage(), t.getRows());
		return daoTemplete.getListData("fairSql.selectAll", t);
	}

	@Override
	public TFair get(String id) {
		return (TFair)daoTemplete.getOneData("fairSql.get", id);
	}

	@Override
	public void updateStatus(TFair tf) throws RbackException {
		daoTemplete.update("fairSql.updateStatus", tf);
	}

	@Override
	public void update(TFair tf) throws RbackException {
		daoTemplete.update("fairSql.update", tf);
	}

	@Override
	public void saveSort(THunter t) throws RbackException {
		daoTemplete.update("fairSql.saveSort", t);
	}

	@Override
	public List<TJobp> allJobs(TFair t) {
		PageHelper.startPage(t.getPage(), t.getRows());
		return daoTemplete.getListData("fairSql.selectAllJobs", t);
	}

	@Override
	public TJobp getJobDetail(String jobId) {
		return (TJobp)daoTemplete.getOneData("fairSql.getJobDetail", jobId);
	}

	@Override
	public void delJob(String jobId) throws RbackException {
		daoTemplete.update("fairSql.delJob", jobId);
	}

}
