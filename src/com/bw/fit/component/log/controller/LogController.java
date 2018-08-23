package com.bw.fit.component.log.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.component.log.dao.LogDao;
import com.bw.fit.component.log.model.LogInfo;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.dict.dao.DictDao;
import com.bw.fit.system.dict.service.DictService;

@RequestMapping("log")
@Controller
public class LogController {

	@Autowired
	private LogDao logDao;
	@Autowired
	private DictService dictService ;
	
	@RequestMapping(value="log/{id}",method=RequestMethod.GET)
	public String get(@PathVariable String id,Model model ){
		model.addAttribute("log",logDao.get(id));
		return "system/log/logDetailPage";
	}
	
	@RequestMapping(value="logs",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject getlogs(@ModelAttribute LogInfo log){
		JSONObject js = new JSONObject();
		log.setPaginationEnable("1");
		List<LogInfo> list = logDao.getLogs(log);
		for(LogInfo lg :list){
			lg.setLogType(dictService.getDictByValue(lg.getLogType()).getDictName());
		}
		log.setPaginationEnable("0");
		List<LogInfo> listTatol = logDao.getLogs(log);
		js.put("total", (listTatol!=null&& listTatol.size() > 0)?listTatol.size():0);
		js.put("rows",  JSONObject.toJSON(list));
		return js ;
	}
}
