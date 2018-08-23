package com.bw.fit.system.authority.dao;

import java.util.List;

import com.bw.fit.system.authority.entity.TAuthority;

public interface AuthorityDao {

	/***
	 * 获取功能权限
	 * @param code
	 * @return
	 */
	public TAuthority get(String code);
	/*****
	 * 查询权限列表
	 * @param ta
	 * @return
	 */
	public List<TAuthority> authoritys(TAuthority ta);
}
