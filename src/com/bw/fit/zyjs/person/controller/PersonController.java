package com.bw.fit.zyjs.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.zyjs.person.dao.PersonDao;

@RequestMapping("person")
@Controller
public class PersonController extends BaseController {
	@Autowired
	private PersonDao personDao;
	
	@RequestMapping(value="person/{id}",method=RequestMethod.GET)
	public String get(@PathVariable String id,Model model ){
		model.addAttribute("person", personDao.get(id));
		return "zyjs/person/personDetailPage" ;
	}
	
}
