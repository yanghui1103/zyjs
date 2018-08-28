package com.bw.fit.zyjs.fair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bw.fit.system.common.controller.BaseController;

/****
 * 招聘会
 * @author yangh
 *
 */
@RequestMapping("fair")
@Controller
public class FairController  extends BaseController{

	@RequestMapping("gotoList/{area}")
	public String gotolist(@PathVariable String area,Model model){
		model.addAttribute("area", area);
		return "zyjs/fair/fairListPage";
	}

	@RequestMapping("gotoList2/{area}")
	public String gotolist22(@PathVariable String area,Model model){
		model.addAttribute("area", area);
		return "zyjs/fair/fairSortListPage";
	}
	
	@RequestMapping(value="fair/{id}",method=RequestMethod.GET)
	public String detail(@PathVariable String id,Model model){
		
		return "zyjs/fair/fairDetailPage";
	}
}
