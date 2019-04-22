package com.bw.fit.train.report.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.train.report.dao.RptDao;
import com.bw.fit.train.report.entity.TTrainSign;

@Repository
public class RptDaoImpl implements RptDao {
	@Autowired
	private DaoTemplete daoTemplete;

	@Override
	public List<TTrainSign> selectAll(TTrainSign tr) {
		return daoTemplete.getListData("trainSignSql.selectAll", tr);
	}
	

}
