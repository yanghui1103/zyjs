package com.bw.fit.component.job.dao;

import java.util.List;

import com.bw.fit.component.job.entity.TJob;

public interface JobDao {

	/****
	 * 查询符合的定时任务
	 * @return
	 */
	public List<TJob> all(TJob tb);
	/****
	 * 获取详情
	 * @param id
	 * @return
	 */
	public TJob get(String id);
	
}
