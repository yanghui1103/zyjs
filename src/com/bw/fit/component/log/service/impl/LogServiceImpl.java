package com.bw.fit.component.log.service.impl;

import static com.bw.fit.system.common.util.PubFun.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.component.log.dao.LogDao;
import com.bw.fit.component.log.model.LogInfo;
import com.bw.fit.component.log.service.LogService;  

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDao logDao ;

	@Override
	public JSONObject notice(LogInfo l) throws RbackException {
		JSONObject json = new JSONObject();
		try {
			logDao.insert(l);
			PubFun.returnSuccessJson(json);
		} catch (RbackException e) {
			e.printStackTrace();
			json = new JSONObject();
			PubFun.returnFailJson(json, e.getMsg());
			throw e;
		}finally{
			return json ;
		}
	} 
	
	

}
