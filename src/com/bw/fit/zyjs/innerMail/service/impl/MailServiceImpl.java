package com.bw.fit.zyjs.innerMail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.zyjs.innerMail.dao.MailDao;
import com.bw.fit.zyjs.innerMail.entity.TMail;
import com.bw.fit.zyjs.innerMail.model.Mail;
import com.bw.fit.zyjs.innerMail.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private MailDao mailDao;
	
	@Override
	public JSONObject insert(Mail mail) throws RbackException {
		JSONObject json = new JSONObject();
		TMail tm = new TMail();
		try {
			PubFun.copyProperties(tm, mail);
			mailDao.insert(tm);
			json.put("res", "2");
			json.put("msg", "发送成功");
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
