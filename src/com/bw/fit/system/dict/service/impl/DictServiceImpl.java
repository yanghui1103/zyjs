package com.bw.fit.system.dict.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.dict.dao.DictDao;
import com.bw.fit.system.dict.entity.TdataDict;
import com.bw.fit.system.dict.model.DataDict;
import com.bw.fit.system.dict.model.Dict;
import com.bw.fit.system.dict.model.treeHandler.DataDictJsonTreeHandler;
import com.bw.fit.system.dict.service.DictService;

@Service
public class DictServiceImpl implements DictService {

	@Autowired
	private DictDao dictDao ;
	
	@Override
	public Dict getDictsByParentValue(String value) {
		Dict d = dictDao.getDictByValue(value);
		return d ;
		
	}

	@Override
	public DataDict getAllDataDict(String parent_id) {
		List<TdataDict> list = dictDao.getDataDictList(parent_id);
		List<DataDict> lis = new ArrayList<>();
		for (TdataDict d : list) {
			DataDict dd = new DataDict();
			PubFun.copyProperties(dd, d);
			if ("0".equals(dd.getParent_id())) {
				dd.setParent_id("");
			}
			lis.add(dd);
		}

		List dataList = new ArrayList();
		for (DataDict d : lis) {
			HashMap dataRecord1 = new HashMap();
			dataRecord1.put("id", d.getId());
			dataRecord1.put("dict_value", d.getDict_value());
			dataRecord1.put("dict_remark", d.getDict_remark());
			dataRecord1.put("dict_name", d.getDict_name());
			dataRecord1.put("parent_id", d.getParent_id());
			dataRecord1.put("can_add", d.getCan_add());
			dataRecord1.put("can_edit", d.getCan_edit());
			dataRecord1.put("can_del", d.getCan_del());
			dataRecord1.put("num", d.getNum());
			dataList.add(dataRecord1);
		}
		DataDict node = DataDictJsonTreeHandler.getJSONTree(dataList);
		return node;
	}

	@Override
	public JSONObject createDict(Dict dict) throws RbackException {
		JSONObject json = new JSONObject();		
		try {
			dictDao.insert(dict);
			PubFun.returnSuccessJson(json);
		} catch (RbackException e) {
			e.printStackTrace();
			PubFun.returnFailJson(json, e.getMsg());
			throw   e;
		}finally{
			return json ;
		}
	}

	@Override
	public JSONObject updateDict(Dict dict) throws RbackException {
		JSONObject json = new JSONObject();		
		try {
			dictDao.update(dict);
			PubFun.returnSuccessJson(json);
		} catch (RbackException e) {
			e.printStackTrace();
			PubFun.returnFailJson(json, e.getMsg());
			throw   e;
		}finally{
			return json ;
		}
	}

	@Override
	public Dict getDictByValue(String dictValue) {
		return dictDao.getDictByValue(dictValue);
	}

	
}
