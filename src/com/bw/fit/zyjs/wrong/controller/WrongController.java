package com.bw.fit.zyjs.wrong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/****
 * 举报
 * @author yangh
 *
 */
@RequestMapping("wrong")
@Controller
public class WrongController {

	@RequestMapping("gotoListPage/{area}")
	public String gotolist(@PathVariable String area,Model model){
		model.addAttribute("area", area);
		return "zyjs/wrong/wrongListPage"; 
	}
	
	@RequestMapping(value="wrong/{id}",method=RequestMethod.GET)
	public String detail(@PathVariable String id,Model model){
		
		return "zyjs/wrong/wrongDetailPage";
	}
}
