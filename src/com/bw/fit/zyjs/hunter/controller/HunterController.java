package com.bw.fit.zyjs.hunter.controller;


import java.util.*;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.dict.service.DictService;
import com.bw.fit.zyjs.audit.model.Audit;
import com.bw.fit.zyjs.hunter.model.Hunter;
import com.bw.fit.zyjs.hunter.service.HunterService;

@RequestMapping("hunter")
@Controller
public class HunterController extends BaseController {
	@Autowired
	private HunterService hunterService;
	@Autowired
	private DictService dictService;

	@RequestMapping(value="hunters/{area}",method=RequestMethod.GET)
	@ResponseBody
	public JSONArray hunters(@PathVariable String area,@ModelAttribute Hunter hunter ){
		hunter.setArea(area);
		List<Hunter> hunters = hunterService.selectAll(hunter);
		
		return (JSONArray) JSONArray.toJSON(hunters);
	}
	
	@RequestMapping("gotohuntersPage/{area}")
	public String git(@PathVariable String area,Model model ){
		model.addAttribute("area", area);
		return "zyjs/hunter/hunterListPage" ;
	}
	
	@RequestMapping("audit/{id}")
	public String audit(@PathVariable String id,Model model){
		Hunter te = hunterService.get(id);
		te.setIndustry(dictService.getDictByValue(te.getIndustry()).getDictName());
		te.setScale(dictService.getDictByValue(te.getScale()).getDictName());
		te.setCompType(dictService.getDictByValue(te.getCompType()).getDictName());
		model.addAttribute("hunter", te) ;
		return "zyjs/hunter/hunterAuditPage" ;
	}

	@RequestMapping("black/{id}")
	public String black(@PathVariable String id,Model model){
		Hunter te = hunterService.get(id);
		te.setIndustry(dictService.getDictByValue(te.getIndustry()).getDictName());
		te.setScale(dictService.getDictByValue(te.getScale()).getDictName());
		te.setCompType(dictService.getDictByValue(te.getCompType()).getDictName());
		model.addAttribute("hunter", te) ;
		return "zyjs/hunter/hunterBlackPage" ;
	}
	
	@RequestMapping(value="audit",method=RequestMethod.PUT)
	@ResponseBody
	public JSONObject auditud(@ModelAttribute Audit audit) throws Exception{
		JSONObject json = hunterService.updateAndAudit(audit);
		return json  ;
	}
}
