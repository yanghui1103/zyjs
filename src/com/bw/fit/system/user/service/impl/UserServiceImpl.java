package com.bw.fit.system.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.user.dao.UserDao;
import com.bw.fit.system.user.entity.TUser;
import com.bw.fit.system.user.model.User;
import com.bw.fit.system.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public JSONObject add(User user) throws RbackException {
		JSONObject json = new JSONObject();
		try{
			TUser tuser = new TUser();
			PubFun.copyProperties(tuser, user);
			userDao.insert(tuser);
			PubFun.returnSuccessJson(json);
		}catch(RbackException ex){
			json = new JSONObject();
			PubFun.returnFailJson(json, ex.getMsg());
		}finally{
			return json;
		}
	}

	@Override
	public JSONObject delete(String id) throws RbackException {
		JSONObject json = new JSONObject();
		try{ 
			userDao.delete(id);
			PubFun.returnSuccessJson(json);
		}catch(RbackException ex){
			json = new JSONObject();
			PubFun.returnFailJson(json, ex.getMsg());
		}finally{
			return json;
		}
	}

	@Override
	public User get(String id) {
		User user = new User();
		TUser tu =  userDao.get(id);
		if(tu!=null){
			PubFun.copyProperties(user, tu);
		}
		return user ;
	}

	@Override
	public User getByCode(String code) {
		User user = new User();
		TUser tu =  userDao.getByCode(code);
		if(tu!=null){
			PubFun.copyProperties(user, tu);
		}
		return user ;
	}

}
