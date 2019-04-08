package com.bw.fit.zyjs.fine.service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.fine.entity.TFine;

public interface FineService {

	public JSONObject update(TFine fine) throws RbackException ;
	public JSONObject create(TFine fine) throws RbackException ;
}
