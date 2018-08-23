package com.bw.fit.system.address.dao;

import java.util.List;

import com.bw.fit.system.address.entity.VAddress;

public interface AddressDao {
	/***
	 * 根据underOrgId和addressType获取地址
	 * @param addressType类型
	 * @param underOrgId组织id
	 * @return
	 */
	public List<VAddress> getAddressByOrgId(String addressType,String underOrgId);
	
	/***
	 * 根据underOrgId和key获取地址
	 * @param addressType类型
	 * @param keyWords关键词
	 * @return
	 */
	public List<VAddress> getAddressByKey(String addressType,String keyWords);
	
	/***
	 * 根据id获取地址
	 * @param id
	 * @return
	 */
	public List<VAddress> get (String id);
	/***
	 * 根据id数组获取地址本名称数组
	 * @param ids
	 * @return
	 */
	public String[] getNames(String [] ids);
}
