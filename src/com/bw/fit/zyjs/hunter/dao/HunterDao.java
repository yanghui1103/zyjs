package com.bw.fit.zyjs.hunter.dao;

import java.util.List;

import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.hunter.entity.THunter;

public interface HunterDao {

	public THunter get(String id);
	/****
	 * 查询招聘企业
	 * @param th
	 * @return
	 */
	public List<THunter> selectAll(THunter th);
	
	public void update(THunter hunter) throws RbackException ;
	/****
	 * 查询招聘会下已经报名的企业
	 * @param fairId
	 * @return
	 */
	public List<THunter> huntersOfFair(String fairId);
}
