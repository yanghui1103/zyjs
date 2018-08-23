package com.bw.fit.system.dict.dao;

import java.util.List;

import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.dict.entity.TdataDict;
import com.bw.fit.system.dict.model.DataDict;
import com.bw.fit.system.dict.model.Dict;

public interface DictDao {

	public Dict getDictByValue(String value);
	/****
	 * 根据只获取id
	 * @param value
	 * @return
	 */
	public String getIdByDictValue(String value);
	
	/****
	 * 根据父节点id查询所有子孙节点（数据字典）
	 * @param parentId
	 * @return
	 */
	public List<DataDict> getDictsByParentId(String parentId);

	/****
	 * 获取父节点下所有子孙节点
	 * @param c
	 * @return
	 */
	public List<TdataDict> getDataDictList(String parent_id);
	
	/****
	 * 获取数据字典
	 * @param id
	 * @return
	 */
	public Dict get(String id);
	/***
	 * 删除
	 * @param id
	 * @throws RbackException
	 */
	public void delete(String id) throws RbackException ;
	/***
	 * 新增
	 * @param dict
	 * @throws RbackException
	 */
	public void insert(Dict dict) throws RbackException ;
	/***
	 * 修改
	 * @param dict
	 * @throws RbackException
	 */
	public void update(Dict dict) throws RbackException ;
	/****
	 * 根据父节点id查询所有有效的数据字典记录
	 * @param parentId
	 * @return
	 */
	public List<TdataDict> getDictsByPid(String parentId);
}
