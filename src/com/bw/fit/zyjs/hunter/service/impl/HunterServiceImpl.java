package com.bw.fit.zyjs.hunter.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.dict.service.DictService;
import com.bw.fit.zyjs.audit.model.Audit;
import com.bw.fit.zyjs.audit.service.AuditService;
import com.bw.fit.zyjs.hunter.dao.HunterDao;
import com.bw.fit.zyjs.hunter.entity.THunter;
import com.bw.fit.zyjs.hunter.model.Hunter;
import com.bw.fit.zyjs.hunter.service.HunterService;
import com.github.pagehelper.PageHelper;

@Service
public class HunterServiceImpl implements HunterService {

	@Autowired
	private HunterDao hunterDao;
	@Autowired
	private DictService dictService;
	@Autowired
	private AuditService auditService;
	
	@Override
	public List<Hunter> selectAll(Hunter hunter) {
		PageHelper.startPage(hunter.getPage(), hunter.getRows()); 
		THunter th = new THunter();
		PubFun.copyProperties(th, hunter);
		List<THunter> huns = hunterDao.selectAll(th);
		List<Hunter> huns2 =  null ;
		if(huns !=null ){
			huns2 = new ArrayList<>();
			for(THunter t:huns){
				Hunter h = new Hunter();
				PubFun.copyProperties(h, t);
				h.setCompType(dictService.getDictByValue(h.getCompType()).getDictName());
				h.setIndustry(dictService.getDictByValue(h.getIndustry()).getDictName());
				h.setScale(dictService.getDictByValue(h.getScale()).getDictName());
				h.setStatus(dictService.getDictByValue(h.getStatus()).getDictName());
				huns2.add(h);
			}
		}
		return huns2;
	}

	@Override
	public Hunter get(String id) {
		Hunter hunter = new Hunter();
		THunter th = hunterDao.get(id);
		PubFun.copyProperties(hunter, th);
		return hunter ;
	}

	@Override
	public JSONObject update(Hunter hunter) throws RbackException {
		JSONObject json = new JSONObject();
		try {
			THunter th = new THunter();
			PubFun.copyProperties(th, hunter);
			hunterDao.update(th);
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
	public JSONObject updateAndAudit(Audit audit) throws RbackException {
		JSONObject json = new JSONObject();
		try {
			THunter th = new THunter();
			th.setId(audit.getForeignId());
			th.setStatus(audit.getCode());
			hunterDao.update(th);
			
			PubFun.fillCommonProptities(audit, true, null);
			auditService.create(audit);
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
	public List<Hunter> huntersOfFair(String fairId) {
		List<THunter> hs = hunterDao.huntersOfFair(fairId);
		if(hs !=null){
			List<Hunter> hhs = new ArrayList<>();
			for(THunter t:hs){
				Hunter h = new Hunter();
				PubFun.copyProperties(h, t);
				hhs.add(h);
			}
			return hhs;
		}
		return null;
	}

}
