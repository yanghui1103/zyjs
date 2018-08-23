package com.bw.fit.system.common.data.source;

import java.util.Set;

import com.bw.fit.system.common.model.RbackException;

public interface KvdbDataSource {

	/****
	 * 存放数据入库
	 * @param key
	 * @param value
	 * @throws RbackException
	 */
	public void set(String key ,Object value) throws RbackException;
	/****
	 * 按照key查询
	 * @param key
	 * @return
	 */
	public String get(String key);
	/****
	 * 删除key
	 * @param key
	 * @throws RbackException
	 */
	public void del(String key) throws RbackException;
	/****
	 * 根据键的关键词进行模糊查询
	 * @param pattern
	 * @return
	 */
	public Set getKeysByPattern(String pattern);
	
}
