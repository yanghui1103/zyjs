package com.bw.fit.zyjs.resume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.dict.service.DictService;
import com.bw.fit.zyjs.hunter.model.Hunter;

@RequestMapping("resume")
@Controller
public class ResumeController extends BaseController {

	@Autowired
	private DictService dictService;


	@RequestMapping("gotoResumeListPage/{area}")
	public String git(@PathVariable String area,Model model ){
		model.addAttribute("area", area);
		return "zyjs/resume/resumeListPage" ;
	}
	
}
