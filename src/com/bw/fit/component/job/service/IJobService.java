package com.bw.fit.component.job.service;

import java.util.List;

import com.bw.fit.component.job.entity.TJob;

/*****
 * 定时任务组件
 * @author yangh
 *
 */
public interface IJobService {

	/****
	 * 查询符合的定时任务
	 * @return
	 */
	public List<TJob> all(TJob tb);
	/*****
	 * 禁用任务，正在运行系统时候
	 * @param taskName
	 */
	public void remove(String taskName);
	/****
	 * 获取详情
	 * @param id
	 * @return
	 */
	public TJob get(String id);
}
