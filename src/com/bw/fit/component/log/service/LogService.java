package com.bw.fit.component.log.service;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.component.log.model.LogInfo;

/*****
 * 日志组件
 * @author yangh
 *
 */
public interface LogService {
	/******
	 * 录入日志消息
	 * @param l 日志实体对象
	 */
	public JSONObject notice(LogInfo l) throws RbackException ;
	
	
}
