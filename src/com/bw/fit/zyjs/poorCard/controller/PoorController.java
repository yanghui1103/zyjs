package com.bw.fit.zyjs.poorCard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bw.fit.system.common.controller.BaseController;

@RequestMapping("poor")
@Controller
public class PoorController extends BaseController {

	@RequestMapping(value="poor/{id}",method=RequestMethod.GET)
	public String detail(@PathVariable String id,Model model){
		return "zyjs/poorCard/poorDetailPage" ;
	}
}
