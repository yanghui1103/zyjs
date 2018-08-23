package com.bw.fit.system.organization.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.organization.dao.OrganizationDao;
import com.bw.fit.system.organization.model.Organization;
import com.bw.fit.system.organization.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationDao organizationDao ;
	
	
	@Override
	public JSONObject add(Organization org) throws RbackException {
		JSONObject json = new JSONObject();
		try{
			organizationDao.insert(org);
			PubFun.returnSuccessJson(json);
		}catch(RbackException ex){
			json = new JSONObject();
			PubFun.returnFailJson(json, ex.getMsg());
		}finally{
			return json;
		}
	}


	@Override
	public JSONObject delete(String id) throws RbackException {
		JSONObject json = new JSONObject();
		try{
			organizationDao.delete(id);
			PubFun.returnSuccessJson(json);
		}catch(RbackException ex){
			json = new JSONObject();
			PubFun.returnFailJson(json, ex.getMsg());
		}finally{
			return json;
		}
	}


	@Override
	public String getParentOrgByCurtOrgId(String currentOrgId) {
		List<Organization>  list = organizationDao.getParentsAndCurt(currentOrgId);
		StringBuffer sb = new StringBuffer();
		List<String> ss = list.stream().map(Organization::getName).collect(Collectors.toList());
		for(int i=ss.size()-1;i>=0 ;i--){
			sb.append(ss.get(i)+"-");
		}
		return sb.substring(0, (sb.toString().length()-1)) ;
	}


	@Override
	public Organization get(String id) {
		return organizationDao.get(id);
	}


	@Override
	public List<Organization> getChildrenAndCurt(String cuurentOrgId) {
		return organizationDao.getChildrenAndCurt(cuurentOrgId);
	}


	@Override
	public List<Organization> getParentsAndCurt(String cuurentOrgId) {
		return organizationDao.getParentsAndCurt(cuurentOrgId);
	}


}
