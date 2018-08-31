package com.bw.fit.zyjs.fair.service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.fair.model.Fair;

public interface FairService {

	public JSONObject add(Fair fair) throws RbackException ;
	
	public Fair get(String id);
}
