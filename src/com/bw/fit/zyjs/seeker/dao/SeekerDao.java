package com.bw.fit.zyjs.seeker.dao;

import java.util.List;

import com.bw.fit.zyjs.seeker.entity.TSeeker;

public interface SeekerDao {

	public List<TSeeker> selectAll(TSeeker s);
	
	public TSeeker get(String id);
}
