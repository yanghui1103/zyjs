package com.bw.fit.system.user.dao;

import java.util.*;

import com.alibaba.fastjson.JSONObject; 
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.role.model.Role;
import com.bw.fit.system.user.entity.TUser;

/****
 * 用户持久层
 * @author yangh
 *
 */
public interface UserDao {

	/****
	 * 获取用户列表
	 * @param u
	 * @return
	 */
	public List<TUser> getUsers(TUser u);
	/***
	 * 根据id获取用户资料
	 * @param id
	 * @return
	 */
	public TUser get(String id);
	/***
	 * 根据code获取用户资料
	 * @param id
	 * @return
	 */
	public TUser getByCode(String code);
	/****
	 * 新增
	 * @param tu
	 * @throws RbackException
	 */
	public void insert(TUser tu) throws RbackException;
	public void delete(String id) throws RbackException;
}
