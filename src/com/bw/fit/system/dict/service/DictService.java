package com.bw.fit.system.dict.service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.dict.model.DataDict;
import com.bw.fit.system.dict.model.Dict;

public interface DictService {

	/****
	 * 根据一个数据字典值，获取到他下
	 * 所有的子孙节点
	 * @param value
	 * @return
	 */
	public Dict getDictsByParentValue(String value);
	/*****
	 * 获取这个节点（parnet_id）下所有数据字典信息
	 * @param parent_id
	 * @return
	 */
	public DataDict getAllDataDict(String parent_id) ;
	
	/****
	 * 新增数据字典
	 * @param dict
	 * @return
	 * @throws RbackException
	 */
	public JSONObject createDict(Dict dict) throws RbackException ;
	/****
	 * 修改数据字典
	 * @param dict
	 * @return
	 * @throws RbackException
	 */
	public JSONObject updateDict(Dict dict) throws RbackException ;
	/****
	 * 根据值获取数据字典数据
	 * @param dictValue
	 * @return
	 */
	public Dict getDictByValue(String dictValue);
}
