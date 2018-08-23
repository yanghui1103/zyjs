package com.bw.fit.system.address.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.address.dao.AddressDao;
import com.bw.fit.system.address.entity.VAddress;
import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.position.model.Position;
@Repository
public class AddressDaoImpl implements AddressDao{
	@Autowired
	private DaoTemplete daoTemplete;
	@Override
	public List<VAddress> get(String id) {
		return daoTemplete.getListData("addressSql.get", id);
	}
	@Override
	public List<VAddress> getAddressByOrgId(String addressType, String underOrgId) {
		Map<String,String> map = new HashMap<>();
		map.put("addressType",addressType);
		map.put("underOrgId",underOrgId);
		return daoTemplete.getListData("addressSql.getAddressByOrgId", map);
	}
	@Override
	public List<VAddress> getAddressByKey(String addressType, String keyWords) {
		Map<String,String> map = new HashMap<>();
		map.put("addressType",addressType);
		map.put("keyWords",keyWords);
		return daoTemplete.getListData("addressSql.getAddressByKey", map);
	}
	@Override
	public String[] getNames(String[] ids) {
		List<VAddress> lists = daoTemplete.getListData("addressSql.getNames", ids);
		String[] names=lists.stream().map(VAddress::getName).toArray(String[]::new);
		return names;
	}

}
