package com.bw.fit.system.organization.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.organization.dao.OrganizationDao;
import com.bw.fit.system.organization.model.Organization;
@Repository
public class OrganizationDaoImpl implements OrganizationDao {

	@Autowired
	private DaoTemplete daoTemplete;
	
	@Override
	public List<Organization> getOrganizations(Organization org) {
		/****
		 * 1，先找KVDB
		 */
//		Set<String> set = daoTemplete.getKeysByPattern("t_org*100:*");
//		List<Organization> list = new ArrayList<>();
//		for(String s:set){
//			Organization sg = (Organization)JSONObject.toJavaObject(JSONObject.parseObject(daoTemplete.get(s)), Organization.class);
//			list.add(sg);
//		}
		/****
		 * 2，如果没有找到，那就弄一个同步锁，先去关系型数据库找
		 */
//		if(list!=null&&list.size()>0)
//			return list ;
		
		List<Organization> os = daoTemplete.getListData("organizationSql.getOrganizations", org);
		/*****
		 * 3，锁里，将查询到的数据同步入库至于KVDB
		 */
//		try {
//			int rownum = 1;
//			for(Organization o:os){
//				daoTemplete.set("t_org:"+rownum+":"+o.getId(), JSONObject.toJSON(o).toString());
//				rownum ++ ;
//			}
//		} catch (RbackException e) {
//			e.printStackTrace();
//		}
		return os;
	}

	@Override
	public void insert(Organization org) throws RbackException {
		daoTemplete.insert("organizationSql.insert", org);
		daoTemplete.del("t_org");
	}

	@Override
	public void update(Organization org) throws RbackException {
		daoTemplete.update("organizationSql.update", org);
	}

	@Override
	public void delete(String id) throws RbackException {
		daoTemplete.update("organizationSql.delete", id);
	}

	@Override
	public Organization get(String id) {
		return (Organization)daoTemplete.getOneData("organizationSql.get", id);
	}

	@Override
	public List<Organization> getChildrenAndCurt(String cuurentOrgId) {
		return daoTemplete.getListData("organizationSql.getChildrenAndCurt", cuurentOrgId);
	}

	@Override
	public List<Organization> getParentsAndCurt(String cuurentOrgId) {
		return daoTemplete.getListData("organizationSql.getParentsAndCurt", cuurentOrgId);
	}

}
