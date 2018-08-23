package com.bw.fit.system.common.data.source;

import java.util.List;

import com.bw.fit.system.common.model.RbackException;

public interface RmdbDataSource {

	/****
	 * 持久层，新增
	 * @param sql 新增数据SQL脚本
	 * @param object 数据
	 * @throws RbackException
	 */
	public void insert(String sql,Object object) throws RbackException ;
	/****
	 * 持久层，更新
	 * @param sql 更新数据SQL脚本
	 * @param object 数据
	 * @throws RbackException
	 */
	public void update(String sql,Object object) throws RbackException ;
	/****
	 * 持久层，删除
	 * @param sql 删除数据SQL脚本
	 * @param object 数据
	 * @throws RbackException
	 */
	public void delete(String sql,Object object) throws RbackException ;
	/******
	 * 持久层，查询，返回多数据集
	 * @param sql 查询SQL脚本
	 * @param object
	 * @return
	 */
	public List getListData(String sql, Object object); 
	/******
	 * 持久层，查询，返回单个数据
	 * @param sql 查询SQL脚本
	 * @param object
	 * @return
	 */
	public Object getOneData(String sql, Object object); 
}
