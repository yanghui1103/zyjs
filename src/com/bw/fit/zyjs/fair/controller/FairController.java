package com.bw.fit.zyjs.fair.controller;

import static com.bw.fit.system.common.util.PubFun.returnFailJson;

import javax.validation.Valid;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.zyjs.fair.model.Fair;
import com.bw.fit.zyjs.fair.service.FairService;

/****
 * 招聘会
 * @author yangh
 *
 */
@RequestMapping("fair")
@Controller
public class FairController  extends BaseController{

	@Autowired
	private FairService fairService;
	
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
	
	@RequestMapping(value="fairSort/{id}",method=RequestMethod.GET)
	public String detail2(@PathVariable String id,Model model){
		
		return "zyjs/fair/fairEstaSortPage";
	}
	
	@RequestMapping(value="fair",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject create(@Valid @ModelAttribute Fair fair,BindingResult result) throws RbackException{
		JSONObject json = new JSONObject();
		if (result.hasErrors()) {
			FieldError error = result.getFieldError();
			json.put("res", "1");
			returnFailJson(json, error.getDefaultMessage());
			return json;
		}

		Session session = PubFun.getCurrentSession();
		PubFun.fillCommonProptities(fair, true, session);
		json = fairService.add(fair);
		return json;
	}
}
