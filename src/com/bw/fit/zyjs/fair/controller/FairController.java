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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aspose.words.List;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.account.service.AccountService;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.dict.service.DictService;
import com.bw.fit.zyjs.fair.dao.FairDao;
import com.bw.fit.zyjs.fair.entity.TFair;
import com.bw.fit.zyjs.fair.model.Fair;
import com.bw.fit.zyjs.fair.service.FairService;
import com.bw.fit.zyjs.hunter.model.Hunter;
import com.bw.fit.zyjs.hunter.service.HunterService;

/****
 * 招聘会
 * @author yangh
 *
 */
@RequestMapping("fair")
@Controller
public class FairController  extends BaseController{

	@Autowired
	private HunterService hunterService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private DictService dictService;
	@Autowired
	private FairService fairService;
	@Autowired
	private FairDao fairDao ;
	
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
		Fair f = fairService.get(id);
		f.setCreator(accountService.get(f.getCreator()).getName());
		model.addAttribute("fair", f);
		return "zyjs/fair/fairDetailPage";
	}
	
	@RequestMapping(value="update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable String id,Model model){
		Fair f = fairService.get(id);
		model.addAttribute("fair", f);
		return "zyjs/fair/fairEditPage";
	}
	
	@RequestMapping(value="sort/{id}",method=RequestMethod.GET)
	public String detail2(@PathVariable String id,Model model){
		Fair f = fairService.get(id);
		f.setCreator(accountService.get(f.getCreator()).getName());
		model.addAttribute("fair", f);
		return "zyjs/fair/fairEstaSortPage";
	}
	
	@RequestMapping(value="hunters/{fairId}",method=RequestMethod.GET)
	@ResponseBody
	public JSONArray hs(@PathVariable String fairId){
		java.util.List<Hunter> hs = hunterService.huntersOfFair(fairId);
		if(hs !=null){
			for(Hunter h:hs){
				h.setScale(dictService.getDictByValue(h.getScale()).getDictName());
				h.setIndustry(dictService.getDictByValue(h.getIndustry()).getDictName());
				h.setCompType(dictService.getDictByValue(h.getCompType()).getDictName());
			}
		}
		return (JSONArray)JSONArray.toJSON(hs);
	}

	@RequestMapping(value="fairAdd/{area}",method=RequestMethod.GET)
	public String add(@PathVariable String area,Model model){
		model.addAttribute("area", area);
		return "zyjs/fair/fairAddPage";
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
	
	@RequestMapping(value="fairs/{area}",method=RequestMethod.GET)
	@ResponseBody
	public JSONArray selectAll(@PathVariable String area,@ModelAttribute Fair fair){
		TFair t = new TFair();
		PubFun.copyProperties(t, fair);
		java.util.List<TFair> fs = fairDao.all(t);
		if(fs !=null){
			for(TFair tt:fs){
				tt.setTypeCode(dictService.getDictByValue(tt.getTypeCode()).getDictName());
				tt.setStatus((dictService.getDictsByParentValue(tt.getStatus())==null)?"未知":(dictService.getDictsByParentValue(tt.getStatus())).getDictName());
			}
			return (JSONArray)JSONArray.toJSON(fs) ;
		}else{
			return null ;
		}
	}
	
	@RequestMapping(value="close/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public JSONObject close(@PathVariable String id) throws RbackException{
		JSONObject json = new JSONObject();
		json = fairService.updateStatus(id,"ended");		
		return json  ;
	}

	@RequestMapping(value="start/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public JSONObject start(@PathVariable String id) throws RbackException{
		JSONObject json = new JSONObject();
		json = fairService.updateStatus(id,"starting");		
		return json  ;
	}
	
	@RequestMapping(value="fair",method=RequestMethod.PUT)
	@ResponseBody
	public JSONObject update(@Valid @ModelAttribute Fair fair,BindingResult result) throws RbackException{
		JSONObject json = new JSONObject();
		if (result.hasErrors()) {
			FieldError error = result.getFieldError();
			json.put("res", "1");
			returnFailJson(json, error.getDefaultMessage());
			return json;
		}
		json = fairService.update(fair);		
		return json  ;
	}
	
	@RequestMapping(value="sortSave/{id}/{fairId}/{number}/{ptCode}",method= RequestMethod.PUT)
	@ResponseBody
	public JSONObject save(@PathVariable(value="fairId") String fairId,@PathVariable(value="id") String id,
			@PathVariable(value="number") int number,@PathVariable(value="ptCode") String ptCode) throws RbackException{
		if(ptCode.length()<1 || ptCode.length()>10){
			JSONObject j = new JSONObject();
			j.put("res", "1");
			j.put("msg", "展位编码不得超过10位");
			return j ;
		}
		JSONObject json = fairService.saveSort(id, number, ptCode, fairId);
		return json ;
	}
}
