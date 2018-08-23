package com.bw.fit.zyjs.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.company.dao.EstaDao;
import com.bw.fit.zyjs.company.entity.TEsta;
import com.bw.fit.zyjs.company.service.EstaService;

@RequestMapping("esta")
@Controller
public class CompanyController extends BaseController {

	@Autowired
	private EstaDao estaDao;
	@Autowired
	private EstaService estaService;
	
	@RequestMapping("estas/{area}")
	@ResponseBody
	public JSONObject estas(@PathVariable String area){
		JSONObject json = new JSONObject();
		TEsta te = new TEsta();
		te.setArea(area);
		List<TEsta> tes = estaDao.selectAll(te);
		if(tes !=null && tes.size()>0){
			json.put("res", "2");
			json.put("list", JSONArray.toJSON(tes));
		}else{
			json.put("res", "1");
			json.put("msg", "无数据");
		}
		return json  ;
	}
	
	@RequestMapping("gotoEstas/{area}")
	public String gotiesta(@PathVariable String area,Model model){
		model.addAttribute("area", area);
		return "zyjs/esta/estaListPage";
	}
	
	@RequestMapping(value = "esta/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public JSONObject stop(@PathVariable String id) throws RbackException{
		JSONObject json = new JSONObject();
		json = estaService.forbiddenExtenalUser(id);
		return json  ;
	}
	

	@RequestMapping(value = "esta/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public JSONObject restart(@PathVariable String id) throws RbackException{
		JSONObject json = new JSONObject();
		json = estaService.startExtenalUser(id);
		return json  ;
	}
	
	@RequestMapping(value ="password/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public JSONObject initpwd(@PathVariable String id) throws RbackException{
		JSONObject json = new JSONObject();
		json = estaService.initExtenalUserPwd(id);
		return json  ;
	}
	
}