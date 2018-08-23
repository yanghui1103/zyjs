package com.bw.fit.zyjs.company.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PropertiesUtil;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.zyjs.company.dao.EstaDao;
import com.bw.fit.zyjs.company.entity.TEsta;
import com.bw.fit.zyjs.company.service.EstaService;

@Service
public class EstaServiceImpl implements EstaService {

	@Autowired
	private EstaDao estaDao;
	
	@Override
	public List<TEsta> selectAll(TEsta ta) {
		return estaDao.selectAll(ta);
	}

	@Override
	public JSONObject forbiddenExtenalUser(String id) throws RbackException {
		JSONObject json = new JSONObject();
		try {
			String tableName = estaDao.getExtenalType(id);
			estaDao.updateExtenalUserStatus(id, "1", tableName);
			json.put("res", "2");
			json.put("msg", "禁用成功");
		} catch (RbackException e) {
			json = new JSONObject();
			json.put("res", "1");
			json.put("msg", e.getMsg());
			throw new RbackException("1",e.getMsg());
		}finally{
			return json ;
		}
	}

	@Override
	public JSONObject startExtenalUser(String id) throws RbackException {
		JSONObject json = new JSONObject();
		try {
			String tableName = estaDao.getExtenalType(id);
			estaDao.updateExtenalUserStatus(id, "0", tableName);
			json.put("res", "2");
			json.put("msg", "禁用成功");
		} catch (RbackException e) {
			json = new JSONObject();
			json.put("res", "1");
			json.put("msg", e.getMsg());
			throw new RbackException("1",e.getMsg());
		}finally{
			return json ;
		}
	}

	@Override
	public JSONObject initExtenalUserPwd(String id) throws RbackException {
		JSONObject json = new JSONObject();
		try {
			TEsta te = estaDao.get(id);
			estaDao.initPasswd(id, PubFun.getUserPasswordShiro(te.getPhone(), PropertiesUtil.getValueByKey("user.default.pwd"), "MD5", 10));
			json.put("res", "2");
			json.put("msg", "初始化密码成功，"+PropertiesUtil.getValueByKey("user.default.pwd"));
		} catch (RbackException e) {
			json = new JSONObject();
			json.put("res", "1");
			json.put("msg", e.getMsg());
			throw new RbackException("1",e.getMsg());
		}finally{
			return json ;
		}
	}

	
}
