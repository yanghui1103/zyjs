package com.bw.fit.system.position.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.component.warn.service.WarnService;
import com.bw.fit.system.address.service.AddressService;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.dict.model.Dict;
import com.bw.fit.system.organization.dao.OrganizationDao;
import com.bw.fit.system.organization.model.Organization;
import com.bw.fit.system.position.dao.PositionDao;
import com.bw.fit.system.position.entity.TOrganization2Position;
import com.bw.fit.system.position.model.Position;
import com.bw.fit.system.position.service.PositionService;

@RequestMapping("position")
@Controller
public class PositionController {
	@Autowired
	private PositionDao positionDao ;
	@Autowired
	private PositionService positionService ;
	@Autowired
	private WarnService warnService ;
	@Autowired
	private OrganizationDao organizationDao;
	/*****
	 * 查询岗位管理列表
	 * 
	 * @param params
	 * @param model
	 *            UI-Model
	 * @param p
	 *            岗位
	 * @param request
	 *            请求
	 * @param session
	 *            会话
	 * @return
	 */
	@RequestMapping(value="positions/{orgId}",method=RequestMethod.GET)
	@ResponseBody
	public JSONObject companyList(@ModelAttribute Position p, HttpServletRequest request,@PathVariable String orgId) {
		JSONObject json = new JSONObject();
		p.setPaginationEnable("1");
		List<Position> list = positionDao.getPositions(p,orgId);
		if(list!=null&&list.size()>0) {
			for(Position tmp : list) {
				String orgNames="";
				List<Organization> tmpOrgs = positionDao.getOrgByPositionId(tmp.getId());
				if(tmpOrgs!=null&&tmpOrgs.size()>0) {
					for(Organization s1 : tmpOrgs) {
						orgNames += s1.getName()+";";
					}
					orgNames = orgNames.substring(0, orgNames.length()-1);
					tmp.setTemp_str1(orgNames);
				}
			}
			p.setPaginationEnable("0");
			List<Position> listTotal = positionDao.getPositions(p,orgId);
			json.put("total",(listTotal != null && listTotal.size() > 0)?listTotal.size() : 0);
			json.put("rows", JSONObject.toJSON(list));
			return json;
		}else {
			json.put("total",null);
			json.put("rows", 0);
			return json;
		}
		
	}
	
	/***
	 * 打开新增岗位页
	 * @param orgIds
	 * @param orgNames
	 * @param model
	 * @return
	 */
	@RequestMapping("openPositionAddPage/{orgIds}")
	public String openPositionAddPage(@PathVariable String orgIds,Model model){
		model.addAttribute("orgIds", orgIds);
		String orgNames="";
		for(String id : orgIds.split(",")) {
			orgNames += organizationDao.get(id).getName()+";";
		}
		model.addAttribute("orgNames", orgNames);
		return "system/position/positionAddPage" ;
	}
	
	/*****
	 * 打开update岗位页
	 * @param parentId
	 * @param model
	 * @return
	 */
	@RequestMapping("openPositionEditPage/{id}")
	public String openPositionEditPage(@PathVariable String id,Model model){
		Position p = positionDao.get(id);
		List<Organization> orgList = positionDao.getOrgByPositionId(id);
		String ids = "";
		String names = "";
		for(Organization o : orgList) {
			ids += o.getId()+',';
			names += o.getName()+',';
		}
		model.addAttribute("position", p);
		model.addAttribute("orgIds", ids);
		model.addAttribute("orgNames", names);
		
		return "system/position/positionEditPage" ;
	}
	
	@RequestMapping(value="position",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject insert(@Valid @ModelAttribute Position p){
		JSONObject json = new JSONObject();
		Session session  = PubFun.getCurrentSession();
		PubFun.fillCommonProptities(p, true, session);
		try {
			json = positionService.createPosition(p);
		} catch (RbackException e) { 
			json = new JSONObject();
			PubFun.returnFailJson(json, e.getMsg());
		}finally{
			return json ;
		}
	}
	
	@RequestMapping(value="position",method=RequestMethod.PUT,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject update(@Valid @ModelAttribute Position p){
		JSONObject json = new JSONObject();
		Session session  = PubFun.getCurrentSession();
		PubFun.fillCommonProptities(p, false, session);
		try {
			json = positionService.updatePosition(p);
		} catch (RbackException e) { 
			json = new JSONObject();
			PubFun.returnFailJson(json, e.getMsg());
		}finally{
			return json ;
		}
	}
	
	@RequestMapping(value="position/{id}/{orgId}",method=RequestMethod.DELETE,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject delete(@PathVariable String id,@PathVariable String orgId){	
		JSONObject json = new JSONObject();		
		try {
			json = positionService.deletePosition(id,orgId);
		} catch (RbackException e) {
			e.printStackTrace();
			json =  new JSONObject();
			PubFun.returnFailJson(json, e.getMsg());
		}		finally{
			return json ;
		}
	}
}
