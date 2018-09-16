package com.bw.fit.component.job.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.fit.component.job.dao.JobDao;
import com.bw.fit.component.job.entity.TJob;
import com.bw.fit.component.job.service.IJobService;
import com.bw.fit.component.job.util.JobRunUtil;
import com.bw.fit.system.common.util.QuartzManager;

@Service
public class IJobServiceImpl implements IJobService {

	private JobDao jobDao;
	
	private JobRunUtil jobRunUtil;
	
	@Override
	public List<TJob> all(TJob tb) {
		return jobDao.all(tb);
	}

	@Override
	public void remove(String taskName) {
		jobRunUtil.remove(taskName);
	}

	@Override
	public TJob get(String id) {
		return jobDao.get(id);
	}
 
}
