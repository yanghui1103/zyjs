package com.bw.fit.zyjs.fine.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.account.service.AccountService;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.zyjs.fine.dao.FineDao;
import com.bw.fit.zyjs.fine.entity.TFine;
import com.bw.fit.zyjs.fine.service.FineService;

@RequestMapping("fine")
@Controller
public class FineController extends BaseController{

	@Autowired
	private FineDao fineDao;
	@Autowired
	private FineService fineService;
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("fines/{area}")
	@ResponseBody
	public JSONArray fines(@ModelAttribute TFine fine,@PathVariable String area){
		fine.setArea(area);
		List<TFine> list = fineDao.selectAll(fine);
		list.stream().forEach(x->{
			x.setCreator(accountService.get(x.getCreator())==null?"":accountService.get(x.getCreator()).getName());
		});
		return (JSONArray)JSONArray.toJSON(list) ;
	}
	
	@RequestMapping(value="update/{state}/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public JSONObject update(@ModelAttribute TFine fine,@PathVariable(value="state") String state
			,@PathVariable(value="id") String id) throws RbackException{
		fine.setIsdeleted(state);
		JSONObject json = fineService.update(fine) ;
		return json ;
	}
	
	@RequestMapping("fine")
	@ResponseBody
	public JSONObject create(@ModelAttribute TFine fine,HttpSession session ) throws RbackException{ 
		fine.setCreator(PubFun.getCurrentAccount().getId());
		JSONObject json = fineService.create(fine) ;
		return json ;
	}
	
}
