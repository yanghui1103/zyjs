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

	@Autowired
	private MqDataSource mqDataSource ;
	@Autowired
	private KvdbDataSource kvdbDataSource; 
	@Autowired
	private RmdbDataSource rmdbDataSource ;
	@Autowired
	private NoSQLDataSource noSQLDataSource ;
	
	@Override
	public void sendDataToExchange(String message) throws RbackException {
		mqDataSource.sendDataToExchange(message);
	}

	@Override
	public void sendDataToQueue(String queueName, String message)
			throws RbackException {
		mqDataSource.sendDataToQueue(queueName, message);
	}

	@Override
	public String consumeDataFormQueue(String queueName) throws RbackException {
		return mqDataSource.consumeDataFormQueue(queueName);
	}

	@Override
	public void del_list(String listName) {
		noSQLDataSource.del_list(listName);
	}

	@Override
	public void lPush_list(String listName, String str) {
		noSQLDataSource.lPush_list(listName, str);
	}

	@Override
	public void lrange(String listName, long start, long end) {
		 noSQLDataSource.lrange(listName, start, end);
	}

	@Override
	public void rPush(String listName, String str)  throws RbackException  {
		try {
			noSQLDataSource.rPush(listName, str);
		} catch (RbackException e) {
			 throw new RbackException("1",e.getMessage())  ;
		}
	}

	@Override
	public void lRemove(String listName, long index) {
	}

	@Override
	public String lIndex(String listName, long index) {
		return noSQLDataSource.lIndex(listName, index);
	}

	@Override
	public String lPop(String listName) {
		return noSQLDataSource.lPop(listName);
	}

	@Override
	public String rPop(String listName) {
		return noSQLDataSource.rPop(listName);
	}

	@Override
	public void sAdd(String setName, String object) {
		noSQLDataSource.sAdd(setName, object);
	}

	@Override
	public void sRemove(String setName, String object) {
		noSQLDataSource.sRemove(setName, object);
	}

	@Override
	public long sCard(String setName) {
		return noSQLDataSource.sCard(setName);
	}

	@Override
	public Long expire(String key, int seconds) {
		return noSQLDataSource.expire(key, seconds);
	}

	@Override
	public boolean sisMember(String setName, String object) {
		return noSQLDataSource.sisMember(setName, object);
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
	public void join() {
		
	}

	@Override
	public void set(String key, Object value) throws RbackException {
		kvdbDataSource.set(key, value);
	}

	@Override
	public String get(String key)  {
		return kvdbDataSource.get(key)  ;
	}

	@Override
	public void del(String key) throws RbackException {
		kvdbDataSource.del(key);
	}

	@Override
	public Set getKeysByPattern(String pattern) {
		return kvdbDataSource.getKeysByPattern(pattern);
	}

}
