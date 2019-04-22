package com.bw.fit.train.report.dao;

import java.util.List;

import com.bw.fit.train.report.entity.TTrainSign;


public interface RptDao {

	public List<TTrainSign> selectAll(TTrainSign tr);
}
