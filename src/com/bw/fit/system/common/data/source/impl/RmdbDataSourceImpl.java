package com.bw.fit.system.common.data.source.impl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.data.source.RmdbDataSource;
import com.bw.fit.system.common.model.RbackException;

@Component
public class RmdbDataSourceImpl implements RmdbDataSource {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(String sql, Object param) throws RbackException {
		int res = 0;
		try {
			res = sqlSessionTemplate.insert(sql, param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RbackException("1", "数据层执行失败，请联系系统管理员"+e.getMessage());
		}
		if (res < 1)
			throw new RbackException("1", "数据层执行失败，请联系系统管理员");
	}

	@Override
	public void update(String sql, Object param) throws RbackException {
		int res = 0;
		try {
			res = sqlSessionTemplate.update(sql, param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RbackException("1", "数据层执行失败，请联系系统管理员"+e.getMessage());
		}
		if (res < 1)
			throw new RbackException("1", "数据层执行失败，请联系系统管理员");
	}

	@Override
	public void delete(String sql, Object param) throws RbackException {
		int res = 0;
		try {
			res = sqlSessionTemplate.delete(sql, param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RbackException("1", "数据层执行失败，请联系系统管理员"+e.getMessage());
		}
		if (res < 1)
			throw new RbackException("1", "数据层执行失败，请联系系统管理员");
	}

	@Override
	public Object getOneData(String sql, Object object) {
		Object obj = null ;
		try {
			obj = sqlSessionTemplate.selectOne(sql, object);
			if(obj ==null){
				return null; 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return obj;
	}
	@Override
	public List getListData(String sql, Object object) {
		List list = new ArrayList();
		try {
			list = (List) sqlSessionTemplate.selectList(sql, object);
			if(list==null || list.size()<1){
				return null ;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
