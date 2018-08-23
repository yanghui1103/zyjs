package com.bw.fit.system.common.data.source;

import com.bw.fit.system.common.model.RbackException;

public interface NoSQLDataSource {
	
	/*****
	 * 删除集合里数据
	 * @param listName 队列的名称
	 */
	public void del_list(String listName);
	/*****
	 * 从左侧push数据
	 * @param listName 队列名称
	 * @param object  数据
	 */
	public void lPush_list(String listName,String str);
	/****
	 * 获取队列里的数据，从左侧开始数
	 * @param listName 队列名称
	 * @param start 开始  从0开始
	 * @param end 结束，-1 代表无限大
	 */
	public void lrange(String listName,long start ,long end);
	/*****
	 * 做右侧push数据
	 * @param listName 队列名称
	 * @param object 数据
	 */
	public void rPush(String listName,String str)  throws RbackException ;
	/****
	 * 清除数据，从左侧数
	 * @param listName 队列名称 
	 * @param index 
	 */
	public void lRemove(String listName,long index);
	/****
	 * 获取数据，从左侧数
	 * @param listName 队列名称 
	 * @param index 
	 */
	public String lIndex(String listName,long index);
	/****
	 * 从左侧pop数据
	 * @param listName
	 */
	public String lPop(String listName);
	/****
	 * 从右侧pop数据
	 * @param listName
	 */
	public String rPop(String listName);
	
	//------------SET----------------
	/*****
	 * 往Set集合里add数据
	 * @param setName 集合名称
	 * @param object 数据
	 */
	public void sAdd(String setName ,String object);
	/****
	 * 清除数据，
	 * @param setName 集合名称
	 * @param object 数据
	 */
	public void sRemove(String setName ,String object);
	/****
	 * 返回集合元素个数
	 * @param setName set集合名称
	 * @return
	 */
	public long sCard(String setName);
	/****
	 * 判断object是不是这个集合里的数据
	 * @param setName 集合名称
	 * @param object 数据
	 * @return
	 */
	public boolean sisMember(String setName,String object);
	/*****
	 * 键的失效时间
	 * @param key
	 * @param seconds
	 * @return
	 */
	public Long expire(String key,int seconds);
	
}
