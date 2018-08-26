package com.bw.fit.zyjs.hunter.dao;

import java.util.List;

import com.bw.fit.zyjs.hunter.entity.THunter;

public interface HunterDao {

	public THunter get(String id);
	/****
	 * 查询招聘企业
	 * @param th
	 * @return
	 */
	public List<THunter> selectAll(THunter th);
}
