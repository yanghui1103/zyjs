package com.bw.fit.system.common.data.source.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.bw.fit.system.common.data.source.KvdbDataSource;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PropertiesUtil;

/****
 * k-v 数据库 单机服务模式（组件）
 * @author yangh
 *
 */

public class KvdbDataSourceImpl  implements KvdbDataSource{
	 @Autowired
	 private RedisTemplate redisTemplate ;

	@Override
	public void set(String key, Object value) throws RbackException {
		try {
			redisTemplate.opsForValue().set(key, value); 
			if(Long.valueOf(PropertiesUtil.getValueByKey("kvDB.key.expire"))>0){
				redisTemplate.expire(key,Long.valueOf(PropertiesUtil.getValueByKey("kvDB.key.expire")),TimeUnit.SECONDS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RbackException("1",e.getMessage());
		}
	}

	@Override
	public String get(String key) { 
		return  (String)(redisTemplate.opsForValue().get(key)) ; 
	}

	@Override
	public void del(String key) throws RbackException {
		try {
			redisTemplate.delete(key);
		} catch (Exception e) {
			throw new RbackException("1",e.getMessage());
		}
	}

	@Override
	public java.util.Set getKeysByPattern(String pattern) {
		return redisTemplate.keys("*" + pattern + "*");
	}


	 
}
