package com.bw.fit.zyjs.resume.dao;

import java.util.List;

import com.bw.fit.zyjs.resume.entity.TResume;

public interface ResumeDao {

	/*****
	 * 求职者的简历
	 * @param seekerId
	 * @return
	 */
	public List<TResume> getResumes(String seekerId);
	
	public TResume get(String id);
}
