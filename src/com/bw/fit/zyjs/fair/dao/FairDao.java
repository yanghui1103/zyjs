package com.bw.fit.zyjs.fair.dao;

import java.util.List;

import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.fair.entity.TFair;
import com.bw.fit.zyjs.fair.entity.TJobp;
import com.bw.fit.zyjs.hunter.entity.THunter;

public interface FairDao {

	public void insert(TFair tf) throws RbackException ;
	
	public List<TFair> all(TFair t); 
	public List<TJobp> allJobs(TFair t); 
	
	public TFair get(String id);
	
	public TJobp getJobDetail(String jobId);
	
	public void updateStatus(TFair tf) throws RbackException ;
	public void update(TFair tf) throws RbackException ;
	public void delJob(String jobId) throws RbackException ;
	/***
	 * 保存排序
	 * @param tf
	 * @throws RbackException
	 */
	public void saveSort(THunter t) throws RbackException ;
	
}
