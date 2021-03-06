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
import com.bw.fit.zyjs.hunter.entity.THunter;

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

	@Override
	public JSONObject updateStatus(String id,String status) throws RbackException {
		JSONObject json = new JSONObject();
		TFair tf = new TFair();
		tf.setId(id);
		tf.setStatus(status);
		try {
			fairDao.updateStatus(tf);
			json.put("res", "2");
			json.put("msg", "执行成功");
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
	public JSONObject update(Fair fair) throws RbackException {
		JSONObject json = new JSONObject();
		TFair tf = new TFair();
		PubFun.copyProperties(tf, fair);
		try {
			fairDao.update(tf);
			json.put("res", "2");
			json.put("msg", "执行成功");
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
	public JSONObject saveSort(String id, int seriralNumber, String ptCode,String fairId)
			throws RbackException {
		JSONObject json = new JSONObject();
		THunter t = new THunter();
		t.setId(id);
		t.setSerialNumber(seriralNumber);
		t.setPtCode(ptCode);
		t.setTemp_str1(fairId);
		try {
			fairDao.saveSort(t);
			json.put("res", "2");
			json.put("msg", "执行成功");
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
	public JSONObject delJob(String jobId) throws RbackException {
		JSONObject json = new JSONObject(); 
		try {
			fairDao.delJob(jobId);
			json.put("res", "2");
			json.put("msg", "执行成功");
		} catch (RbackException e) {
			json = new JSONObject();
			json.put("res", "1");
			json.put("msg", e.getMsg());
			throw e;
		}finally{
			return json ;
		}
	}

}
