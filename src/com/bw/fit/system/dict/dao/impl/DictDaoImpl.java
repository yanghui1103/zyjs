package com.bw.fit.system.dict.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.dict.dao.DictDao;
import com.bw.fit.system.dict.entity.TdataDict;
import com.bw.fit.system.dict.model.DataDict;
import com.bw.fit.system.dict.model.Dict;
@Repository
public class DictDaoImpl implements DictDao {

	@Autowired
	private DaoTemplete daoTemplete;
	@Override
	public Dict getDictByValue(String value) {
		return (Dict)daoTemplete.getOneData("dictSql.getDictByValue", value);
	}
	@Override
	public String getIdByDictValue(String value) {
		return (String)daoTemplete.getOneData("dictSql.getIdByDictValue", value);
	}
	@Override
	public List<DataDict> getDictsByParentId(String parentId) {
		return daoTemplete.getListData("dictSql.getDictsByParentId", parentId);
	}
	@Override
	public List<TdataDict> getDataDictList(String parent_id) {
		return daoTemplete.getListData("dictSql.getDataDictList", parent_id);
	}
	@Override
	public Dict get(String id) {
		return (Dict)daoTemplete.getOneData("dictSql.get", id);
	}
	@Override
	public void delete(String id) throws RbackException {
		daoTemplete.update("dictSql.delete", id);
	}
	@Override
	public void insert(Dict dict) throws RbackException {
		daoTemplete.insert("dictSql.insert", dict);
	}
	@Override
	public void update(Dict dict) throws RbackException {
		daoTemplete.update("dictSql.update", dict);
	}
	@Override
	public List<TdataDict> getDictsByPid(String parentId) {
		return daoTemplete.getListData("dictSql.getDictsByPid", parentId);
	}

}
