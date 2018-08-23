package com.bw.fit.component.log.dao;

import java.util.List;

import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.component.log.model.LogInfo;

/*****
 * 日志组件DAO层
 * @author yangh
 *
 */
public interface LogDao {
	/******
	 * 录入日志消息
	 */
	public void insert(LogInfo l) throws RbackException ;
	
	/****
	 * 获取详情
	 * @param id
	 * @return
	 */
	public LogInfo get(String id);
	/****
	 * 查询日志记录list
	 * @param log
	 * @return
	 */
	public List<LogInfo> getLogs(LogInfo log);
}
