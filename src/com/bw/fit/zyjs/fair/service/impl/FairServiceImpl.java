package com.bw.fit.zyjs.fair.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.zyjs.fair.dao.FairDao;
import com.bw.fit.zyjs.fair.entity.TFair;
import com.bw.fit.zyjs.fair.model.Fair;
import com.bw.fit.zyjs.fair.service.FairService;

@Service
public class FairServiceImpl implements FairService {

	@Autowired
	private FairDao fairDao;
	
	@Override
	public JSONObject add(Fair fair) throws RbackException {
		JSONObject json = new JSONObject();
		TFair tf = new TFair();
		PubFun.copyProperties(tf, fair);
		try {
			fairDao.insert(tf);
			json.put("res", "2");
			json.put("msg", "录入成功");
		} catch (RbackException e) {
			json = new JSONObject();
			json.put("res", "1");
			json.put("msg", e.getMsg());
			throw e;
		}finally{
			return json ;
		}
	}

	@Override
	public Fair get(String id) {
		TFair t = fairDao.get(id);
		Fair fair  = new Fair();
		PubFun.copyProperties(fair, t);
		return fair;
	}

}
