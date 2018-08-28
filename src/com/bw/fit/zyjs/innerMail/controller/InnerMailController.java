package com.bw.fit.zyjs.innerMail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bw.fit.system.common.controller.BaseController;

@RequestMapping("innerMail")
@Controller
public class InnerMailController extends BaseController{

	@RequestMapping("opensendMail/{id}/{type}")
	public String openmail(@PathVariable(value="id") String id,
			@PathVariable(value="type") String type,Model model){
		
		return "zyjs/innerMail/mailAddPage";
	}
}
