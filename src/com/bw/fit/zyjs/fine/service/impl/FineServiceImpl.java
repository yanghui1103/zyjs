package com.bw.fit.zyjs.fine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.zyjs.fair.entity.TFair;
import com.bw.fit.zyjs.fine.dao.FineDao;
import com.bw.fit.zyjs.fine.entity.TFine;
import com.bw.fit.zyjs.fine.service.FineService;

@Service
public class FineServiceImpl implements FineService{

	@Autowired
	private FineDao fineDao;

	@Override
	public JSONObject update(TFine fine) throws RbackException {
		JSONObject json = new JSONObject();
		try {
			Account account = PubFun.getCurrentAccount();
			account.setCreator(account.getId());
			fineDao.update(fine);
			json.put("res", "2");
			json.put("msg", "操作成功");
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
