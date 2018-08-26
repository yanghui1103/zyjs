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
import com.bw.fit.zyjs.hunter.model.Hunter;
import com.bw.fit.zyjs.hunter.service.HunterService;

@RequestMapping("hunter")
@Controller
public class HunterController extends BaseController {
	@Autowired
	private HunterService hunterService;

	@RequestMapping(value="hunters/{area}",method=RequestMethod.GET)
	@ResponseBody
	public JSONArray hunters(@PathVariable String area,Session session,@ModelAttribute Hunter hunter ){
		hunter.setArea(area);
		List<Hunter> hunters = hunterService.selectAll(hunter);
		
		return (JSONArray) JSONArray.toJSON(hunters);
	}
}
