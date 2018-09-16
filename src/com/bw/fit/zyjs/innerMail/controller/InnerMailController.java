package com.bw.fit.zyjs.innerMail.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.zyjs.company.dao.EstaDao;
import com.bw.fit.zyjs.company.entity.TEsta;
import com.bw.fit.zyjs.innerMail.model.Mail;
import com.bw.fit.zyjs.innerMail.service.MailService;

@RequestMapping("innerMail")
@Controller
public class InnerMailController extends BaseController{

	@Autowired
	private EstaDao estaDao;
	@Autowired
	private MailService mailService;
	
	@RequestMapping("opensendMail/{id}/{type}")
	public String openmail(@PathVariable(value="id") String id,
			@PathVariable(value="type") String type,Model model){
		TEsta te = estaDao.getSubject(id);
		te.setName((te.getName()==null||"".equals(te.getName()))?"未知(个人或无获取)":te.getName());
		model.addAttribute("esta", te);
		return "zyjs/innerMail/mailAddPage";
	}
	
	@RequestMapping("innerMail")
	@ResponseBody
	public JSONObject create(@Valid @ModelAttribute Mail mail,BindingResult result) throws RbackException{
		JSONObject json = new JSONObject();
		if (result.hasErrors()) {
			FieldError error = result.getFieldError();
			json.put("res", "1");
			returnFailJson(json, error.getDefaultMessage());
			return json;
		}
		Session session = PubFun.getCurrentSession();
		PubFun.fillCommonProptities(mail, true, session);
		json = mailService.insert(mail);
		return json ;
	}
}
