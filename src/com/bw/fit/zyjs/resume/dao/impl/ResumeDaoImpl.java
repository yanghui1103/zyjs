package com.bw.fit.zyjs.resume.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.zyjs.resume.dao.ResumeDao;
import com.bw.fit.zyjs.resume.entity.TResume;
@Repository
public class ResumeDaoImpl implements ResumeDao {

	@Autowired
	private DaoTemplete daoTemplete;
	
	@Override
	public List<TResume> getResumes(String seekerId) {
		return daoTemplete.getListData("resumeSql.getResumes", seekerId);
	}

	@Override
	public TResume get(String id) {
		return (TResume)daoTemplete.getOneData("resumeSql.get", id);
	}

}
