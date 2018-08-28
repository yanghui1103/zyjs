package com.bw.fit.zyjs.audit.service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.audit.model.Audit;

public interface AuditService {

	public JSONObject create(Audit au) throws RbackException ;
}
