package com.bw.fit.zyjs.hunter.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.zyjs.hunter.dao.HunterDao;
import com.bw.fit.zyjs.hunter.entity.THunter;
import com.bw.fit.zyjs.hunter.model.Hunter;
import com.bw.fit.zyjs.hunter.service.HunterService;
import com.github.pagehelper.PageHelper;

@Service
public class HunterServiceImpl implements HunterService {

	@Autowired
	private HunterDao hunterDao;
	
	@Override
	public List<Hunter> selectAll(Hunter hunter) {
		PageHelper.startPage(hunter.getPage(), hunter.getRows()); 
		THunter th = new THunter();
		PubFun.copyProperties(th, hunter);
		List<THunter> huns = hunterDao.selectAll(th);
		List<Hunter> huns2 =  null ;
		if(huns !=null ||huns.size()>0){
			huns2 = new ArrayList<>();
			for(THunter t:huns){
				Hunter h = new Hunter();
				PubFun.copyProperties(h, t);
				huns2.add(h);
			}
		}
		return huns2;
	}

}
