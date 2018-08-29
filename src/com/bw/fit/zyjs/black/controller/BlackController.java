package com.bw.fit.zyjs.black.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bw.fit.system.common.controller.BaseController;

@RequestMapping("black")
@Controller
public class BlackController  extends BaseController{

	@RequestMapping("blacks/{area}")
	public String list(@PathVariable String area,Model model){
		model.addAttribute("area", area);
		return "zyjs/black/blackListPage";
	}
	
	@RequestMapping("black/{id}")
	public String detail(@PathVariable String id,Model model){
		
		return "zyjs/black/blackDetailPage";
	}
}
