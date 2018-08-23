package com.bw.fit.component.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.component.job.dao.JobDao;
import com.bw.fit.component.job.entity.TJob;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.common.controller.BaseController;

@RequestMapping("job")
@Controller
public class JobController extends BaseController {

	@Autowired
	private JobDao jobDao;
	
	@RequestMapping(value="jobs",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject jobs(@ModelAttribute TJob tj){
		JSONObject js = new JSONObject();
		tj.setPaginationEnable("1");
		List<TJob> list = jobDao.all(tj);
		for(TJob a:list){
			a.setIsValid("1".equals(a.getIsValid())?"正常":"暂停");
		}
		tj.setPaginationEnable("0");
		List<TJob> listTatol = jobDao.all(tj);
		js.put("total", (listTatol!=null&& listTatol.size() > 0)?listTatol.size():0);
		js.put("rows",  JSONObject.toJSON(list));
		return js ;
	}
}
