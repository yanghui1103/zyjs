package com.bw.fit.system.common.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.data.source.KvdbDataSource;
import com.bw.fit.system.common.data.source.MqDataSource;
import com.bw.fit.system.common.data.source.NoSQLDataSource;
import com.bw.fit.system.common.data.source.RmdbDataSource;
import com.bw.fit.system.common.model.RbackException;

@Repository
public class DaoTempleteImpl  implements DaoTemplete{

//	@Autowired
//	private MqDataSource mqDataSource ;
//	@Autowired
//	private KvdbDataSource kvdbDataSource; 
	@Autowired
	private RmdbDataSource rmdbDataSource ;
//	@Autowired
//	private NoSQLDataSource noSQLDataSource ;
	

	@Override
	public void set(String key, Object value) throws RbackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void del(String key) throws RbackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set getKeysByPattern(String pattern) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insert(String sql, Object object) throws RbackException {
		rmdbDataSource.insert(sql, object);
	}

	@Override
	public void update(String sql, Object object) throws RbackException {
		rmdbDataSource.update(sql, object);
	}

	@Override
	public void delete(String sql, Object object) throws RbackException {
		rmdbDataSource.delete(sql, object);
	}

	@Override
	public List getListData(String sql, Object object) {
		return rmdbDataSource.getListData(sql, object);
	}

	@Override
	public Object getOneData(String sql, Object object) {
		return rmdbDataSource.getOneData(sql, object);
	}


	@Override
	public void del_list(String listName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lPush_list(String listName, String str) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lrange(String listName, long start, long end) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rPush(String listName, String str) throws RbackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lRemove(String listName, long index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String lIndex(String listName, long index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String lPop(String listName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String rPop(String listName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sAdd(String setName, String object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sRemove(String setName, String object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long sCard(String setName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean sisMember(String setName, String object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Long expire(String key, int seconds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void join() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendDataToExchange(String message) throws RbackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendDataToQueue(String queueName, String message)
			throws RbackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String consumeDataFormQueue(String queueName) throws RbackException {
		// TODO Auto-generated method stub
		return null;
	}
 
}
