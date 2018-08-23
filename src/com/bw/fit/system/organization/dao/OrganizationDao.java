package com.bw.fit.system.organization.dao;

import java.util.List;

import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.organization.model.Organization;

public interface OrganizationDao {

	/*****
	 * 根据组织字段条件获取组织
	 * @param org 组织
	 * @return
	 */
	public List<Organization> getOrganizations(Organization org );
	/****
	 * 新增组织
	 * @param org
	 * @throws RbackException
	 */
	public void insert(Organization org ) throws RbackException ;
	/****
	 * 修改组织
	 * @param org
	 * @throws RbackException
	 */
	public void update(Organization org ) throws RbackException ;
	/****
	 * 删除组织
	 * @param id
	 * @throws RbackException
	 */
	public void delete(String id) throws RbackException ;
	/****
	 * 获取组织
	 * @param id
	 * @throws RbackException
	 */
	public Organization get(String id) ;
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
