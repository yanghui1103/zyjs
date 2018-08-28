package com.bw.fit.zyjs.audit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.zyjs.audit.dao.AuditDao;
import com.bw.fit.zyjs.audit.entity.TAudit;
import com.bw.fit.zyjs.audit.model.Audit;
import com.bw.fit.zyjs.audit.service.AuditService;
import com.bw.fit.zyjs.hunter.entity.THunter;

@Service
public class AuditServiceImpl implements AuditService {
	@Autowired
	private AuditDao auditDao ;
	
	@Override
	public JSONObject create(Audit au) throws RbackException {
		JSONObject json = new JSONObject();
		try {
			TAudit th = new TAudit();
			PubFun.copyProperties(th, au);
			auditDao.create(th);
			json.put("res", "2");
			json.put("msg", "审核录入成功");
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
