package com.bw.fit.zyjs.black.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.zyjs.black.dao.BlackDao;
import com.bw.fit.zyjs.black.entity.TBlack;
import com.github.pagehelper.PageHelper;
@Repository
public class BlackDaoImpl implements BlackDao {

	@Autowired
	private DaoTemplete daoTemplete;
	
	@Override
	public List<TBlack> selectAll(TBlack b) {
		return daoTemplete.getListData("blackSql.selectAll", b);
	}

}
