package com.bw.fit.zyjs.fine.dao;

import java.util.List;

import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.fine.entity.TFine;

public interface FineDao {

	public List<TFine> selectAll(TFine fine);
	
	void update(TFine fine) throws RbackException;
	void insert(TFine fine) throws RbackException;
}
