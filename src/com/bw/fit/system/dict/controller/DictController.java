package com.bw.fit.system.dict.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.dict.dao.DictDao;
import com.bw.fit.system.dict.model.DataDict;
import com.bw.fit.system.dict.model.Dict;
import com.bw.fit.system.dict.service.DictService;
/****
 * 数据字典Controller
 * @author yangh
 *
 */
@RequestMapping("dict")
@Controller
public class DictController extends BaseController {

	@Autowired
	private   DictDao dictDao;	
	@Autowired
	private DictService dictService;
	
	/*****
	 * 根据值获取数据字典名称
	 * @param value
	 * @return
	 */
	@RequestMapping("getDictNameByValue/{value}")
	@ResponseBody
	public JSONObject getDictNameByValue(@PathVariable String value){
		JSONObject json = new JSONObject();
		Dict dict = dictDao.getDictByValue(value);
		if(dict==null){
			json = new JSONObject();
			PubFun.returnFailJson(json, "不存在该数据字典");
			json.put("dictName", "");
			return json ;
		}
		json = new JSONObject();
		PubFun.returnSuccessJson(json);
		json.put("dictName", dict.getDictName());
		return json ;
	}
	
	/*****
	 * 根据值 ，查询子孙节点
	 * @param parentValue
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "getDictsByParentValue/{parentValue}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public JSONObject getDictsByParentValue(@PathVariable(value = "parentValue") String parentValue)
			throws Exception {
		JSONObject json = new JSONObject();
		String parent_id = dictDao.getIdByDictValue(parentValue);
		List<DataDict> list = dictDao.getDictsByParentId(parent_id); 
		json.put("total", list.size());
		json.put("rows", JSONObject.toJSON(list));		
		return json ;
	}
	

	@RequestMapping(value = "getDataDictList/{parent_id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public JSONArray getDataDictList(
			@PathVariable(value = "parent_id") String parent_id)
			throws Exception {
		DataDict json = dictService.getAllDataDict(parent_id);
		return (JSONArray) JSONArray.parse("[" + json.toString() + "]");
	}

	
	@RequestMapping(value="dict/{id}",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject get(@PathVariable String id){		
		Dict dict = dictDao.get(id);		
		return (JSONObject)JSONObject.toJSON(dict) ;
	}
	

	@RequestMapping(value="dict/{id}",method=RequestMethod.DELETE,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject delete(@PathVariable String id){	
		JSONObject json = new JSONObject();		
		try {
			dictDao.delete(id);
			PubFun.returnSuccessJson(json);
		} catch (RbackException e) {
			e.printStackTrace();
			json =  new JSONObject();
			PubFun.returnFailJson(json, e.getMsg());
		}		finally{
			return json ;
		}
	}
	
	/*****
	 * 打开新增数据字典页
	 * @param parentId
	 * @param model
	 * @return
	 */
	@RequestMapping("openDictAddPage/{parentId}")
	public String openDictAddPage(@PathVariable String parentId,Model model){
		Dict dict = dictDao.get(parentId);		
		model.addAttribute("parentDict", dict);		
		return "system/dict/dictAddPage" ;
	}

	/*****
	 * 打开update数据字典页
	 * @param parentId
	 * @param model
	 * @return
	 */
	@RequestMapping("openDictEditPage/{id}")
	public String openDictEditPage(@PathVariable String id,Model model){
		Dict dict = dictDao.get(id);		
		model.addAttribute("dict", dict);		
		return "system/dict/dictEditPage" ;
	}
	
	

	@RequestMapping(value="dict",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject insert(@Valid @ModelAttribute Dict dict){
		JSONObject json = new JSONObject();
		Session session  = PubFun.getCurrentSession();
		PubFun.fillCommonProptities(dict, true, session);
		try {
			json = dictService.createDict(dict);
		} catch (RbackException e) { 
			json = new JSONObject();
			PubFun.returnFailJson(json, e.getMsg());
		}finally{
			return json ;
		}
	}
	
	


	@RequestMapping(value="dict",method=RequestMethod.PUT,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject update(@ModelAttribute Dict dict){
		JSONObject json = new JSONObject();
		Session session  = PubFun.getCurrentSession();
		PubFun.fillCommonProptities(dict, false, session);
		try {
			json = dictService.updateDict(dict);
		} catch (RbackException e) { 
			json = new JSONObject();
			PubFun.returnFailJson(json, e.getMsg());
		}finally{
			return json ;
		}
	}
}
