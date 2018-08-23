package com.bw.fit.system.organization.service;

import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.organization.model.Organization;

public interface OrganizationService {

	/****
	 * 新增组织
	 * @param org
	 * @return
	 * @throws RbackException
	 */
	public JSONObject add(Organization org) throws RbackException ;
	/****
	 * 删除组织
	 * @param org
	 * @return
	 * @throws RbackException
	 */
	public JSONObject delete(String id) throws RbackException ;
	/****
	 * 获取该组织
	 * @param id
	 * @return
	 */
	public Organization get(String id);
	/*****
	 * 获取当前组织的父组织（尾部跟随当前组织）
	 * @param currentOrgId
	 * @return
	 */
	public String getParentOrgByCurtOrgId(String currentOrgId);
	/*****
	 * 获取当前组织及其子孙组织列表
	 * @param cuurentOrgId
	 * @return
	 */
	public List<Organization> getChildrenAndCurt(String cuurentOrgId);
	/*****
	 * 获取当前组织及其父组织列表
	 * @param cuurentOrgId
	 * @return
	 */
	public List<Organization> getParentsAndCurt(String cuurentOrgId);
}
