package com.bw.fit.system.address.controller;

import static com.bw.fit.system.common.util.PubFun.getCurrentSession;
import static com.bw.fit.system.common.util.PubFun.returnFailJson;
import static com.bw.fit.system.common.util.PubFun.returnSuccessJson;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.address.dao.AddressDao;
import com.bw.fit.system.address.entity.VAddress;
import com.bw.fit.system.address.service.AddressService;
import com.bw.fit.system.common.model.BaseModel;
import com.bw.fit.system.organization.dao.OrganizationDao;
import com.bw.fit.system.organization.model.Organization;
import com.bw.fit.system.position.dao.PositionDao;
import com.bw.fit.system.position.model.Position;
import com.bw.fit.system.position.service.PositionService;

@RequestMapping("address")
@Controller
public class AddressController {
	
	@Autowired
	private AddressService addressService ;
	
	/***
	 * 打开地址本页面
	 * @param model
	 * @param o 是否查询组织
	 * @param p 是否查询岗位
	 * @param a 是否查询账户
	 * @param ids 已选列表的id
	 * @param isMultiple 是否多选
	 * @return
	 */
	@RequestMapping("openAddressPage/{o}/{p}/{a}/{ids}/{isMultiple}")
	public String openAddressPage(Model model,@PathVariable boolean o,
			@PathVariable boolean p,@PathVariable boolean a,
			@PathVariable(value="ids",required=false) String ids,
			@PathVariable boolean isMultiple){
		Session session = getCurrentSession();
		Account account = (Account)session.getAttribute("CurrentUser");
		String orgId = account.getCurrentOrgId();
		//待选列表
		model.addAttribute("selectMap", addressService.getSelectAddr(o, p, a, orgId,false));
		//已选列表
		if(!"-9".equals(ids)) {
			model.addAttribute("selectedMap", addressService.getSelectedAddr(ids));
		}
		model.addAttribute("ifshow_org", o);
		model.addAttribute("ifshow_position", p);
		model.addAttribute("ifshow_account", a);
		if(isMultiple) {
			model.addAttribute("isMultiple", "multiple");
		}
		return "system/address/addressPage" ;
	}
	
	/*****
	 * 地址本中点击左侧组织树(或者查询)，响应右侧待选
	 * @param orgId 组织id
	 * @param o是否查询组织
	 * @param p是否查询岗位
	 * @param a是否查询账号
	 * @param type查询类型：true:搜索框查询false：点击左侧组织树查询
	 * @return
	 */
	@RequestMapping(value="address/{keyWords}/{o}/{p}/{a}/{type}",method=RequestMethod.GET,produces="application/json;charset=UTF8")
	@ResponseBody
	public JSONObject get(@PathVariable String keyWords,@PathVariable boolean o,@PathVariable boolean p,@PathVariable boolean a,@PathVariable boolean type){
		JSONObject json = new JSONObject();
		try {
			keyWords = (URLDecoder.decode(keyWords, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		json = new JSONObject();
		returnSuccessJson(json);
		json.put("addressMap", (JSONObject)
				JSONObject.toJSON(addressService.getSelectAddr(o, p, a, keyWords,type)));
		return json ;
	}
	
	@RequestMapping(value="addressDetail/{id}",method=RequestMethod.GET,produces="application/json;charset=UTF8")
	@ResponseBody
	public JSONObject addressDetail(@PathVariable String id){
		JSONObject json  = new JSONObject();
		if(id!=null&&id.indexOf("-")!=-1) {
			json.put("detali",addressService.getDetali(id.split("-")[0], id.split("-")[1]));
		}
		returnSuccessJson(json);
		return json;
	}
}
