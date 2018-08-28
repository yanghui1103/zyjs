package com.bw.fit.zyjs.hunter.service;

import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.audit.model.Audit;
import com.bw.fit.zyjs.hunter.model.Hunter;

public interface HunterService {

	public List<Hunter> selectAll(Hunter hunter);
	/****
	 * 获取
	 * @param id
	 * @return
	 */
	public Hunter get(String id);
	public JSONObject update(Hunter hunter) throws RbackException ;
	
	public JSONObject updateAndAudit(Audit audit) throws RbackException ;
}
