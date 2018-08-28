package com.bw.fit.zyjs.seeker.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.zyjs.hunter.entity.THunter;
import com.bw.fit.zyjs.hunter.model.Hunter;
import com.bw.fit.zyjs.seeker.dao.SeekerDao;
import com.bw.fit.zyjs.seeker.entity.TSeeker;
import com.bw.fit.zyjs.seeker.model.Seeker;
import com.bw.fit.zyjs.seeker.service.SeekerService;
import com.github.pagehelper.PageHelper;
@Service
public class SeekerServiceImpl implements SeekerService {

	@Autowired
	private SeekerDao seekerDao;

	@Override
	public List<Seeker> selectAll(Seeker seeker) {
		PageHelper.startPage(seeker.getPage(), seeker.getRows());
		TSeeker th = new TSeeker();
		PubFun.copyProperties(th, seeker);
		List<TSeeker> huns = seekerDao.selectAll(th);
		List<Seeker> huns2 =  null ;
		if(huns !=null ){
			huns2 = new ArrayList<>();
			for(TSeeker t:huns){
				Seeker h = new Seeker();
				PubFun.copyProperties(h, t);
				huns2.add(h);
			}
		}
		return huns2;
	}
	
}
