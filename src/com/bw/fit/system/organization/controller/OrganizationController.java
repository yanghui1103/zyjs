package com.bw.fit.system.organization.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;

import static com.bw.fit.system.common.util.PubFun.*;

import com.bw.fit.system.organization.dao.OrganizationDao;
import com.bw.fit.system.organization.model.Organization;
import com.bw.fit.system.organization.service.OrganizationService;

/*****
 * 组织Controller
 * @author yangh
 *
 */
@RequestMapping("org")
@Controller
public class OrganizationController extends BaseController {

	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private OrganizationDao organizationDao;
	/******
	 * 增加组织
	 * @param org
	 * @param result
	 * @return
	 */
	@RequestMapping(value="organization",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject add(@Valid @ModelAttribute Organization org,BindingResult result){
		JSONObject json = new JSONObject();
		if (result.hasErrors()) {
			FieldError error = result.getFieldError();
			json.put("res", "1");
			returnFailJson(json, error.getDefaultMessage());
			return json ;
		}
		try {
			Session session = PubFun.getCurrentSession();
			//PubFun.fillCommonProptities(org, true,session);
			org.setId(getUUID());
			json = organizationService.add(org);
		} catch (RbackException e) {
			e.printStackTrace();
			json = new JSONObject();
			returnFailJson(json, e.getMsg());
		}finally{
			return json  ;
		}
	}
	
	/****
	 * 删除组织
	 * @param id
	 * @return
	 */
	@RequestMapping(value="organization/{id}",method=RequestMethod.DELETE,produces="application/json;charset=UTF8")
	@ResponseBody
	public JSONObject delete(@PathVariable String id){
		JSONObject json = new JSONObject();
		try {
			json = organizationService.delete(id);
		} catch (RbackException e) {
			e.printStackTrace();
			json = new JSONObject();
			returnFailJson(json, e.getMsg());
		}finally{
			return json  ;
		}	
	}
	
	/*****
	 * 修改组织
	 * @param org
	 * @return
	 */
	@RequestMapping(value="organization",method=RequestMethod.PUT,produces="application/json;charset=UTF8")
	@ResponseBody
	public JSONObject update(@Valid @ModelAttribute Organization org){
		
		return null ;
	}
	
	/****
	 * 获取单个组织
	 * @param org
	 * @return
	 */
	@RequestMapping(value="organization/{id}",method=RequestMethod.GET,produces="application/json;charset=UTF8")
	@ResponseBody
	public JSONObject get(@PathVariable String id){
		JSONObject json = new JSONObject();
		Organization  o = organizationDao.get(id);
		if(o==null){
			json = new JSONObject();
			returnFailJson(json, "该组织不存在");
			return json ;
		}
		json = new JSONObject();
		returnSuccessJson(json);
		json.put("org", (JSONObject)JSONObject.toJSON(o) );
		return json ;
	}
	/*****
		 * 可以翻页，获取组织列表
		 * @param org
		 * @return
		 */
		@RequestMapping(value="organizations",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
		@ResponseBody
		public JSONObject organizations(@ModelAttribute Organization org){
			JSONObject js = new JSONObject();
			JSONArray array = new JSONArray();
			org.setPaginationEnable("0");
			List<Organization> list = organizationDao.getOrganizations(org);
			if(list==null||list.size()<1){
				returnFailJson(js, "无数据");
				return js ;
			}
			for(Organization o:list){
				JSONObject j = new JSONObject();
				j.put("id", o.getId());
				j.put("pId", o.getParentId());
				j.put("name", o.getName());
				j.put("open", true); // 默认全部打开
				array.add(j);
			}
			js.put("res", "2");
			js.put("list", array);
			return js ;
		}
}
