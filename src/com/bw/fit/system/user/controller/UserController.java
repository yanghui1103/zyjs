package com.bw.fit.system.user.controller;

import static com.bw.fit.system.common.util.PubFun.getUUID;
import static com.bw.fit.system.common.util.PubFun.returnFailJson;

import java.util.List;

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
import com.bw.fit.system.account.service.AccountService;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.dict.dao.DictDao;
import com.bw.fit.system.menu.model.Menu;
import com.bw.fit.system.menu.service.MenuService;
import com.bw.fit.system.organization.model.Organization;
import com.bw.fit.system.user.dao.UserDao;
import com.bw.fit.system.user.entity.TUser;
import com.bw.fit.system.user.model.User;
import com.bw.fit.system.user.service.UserService;

/****
 * 用户层，controller
 * @author yangh
 *
 */
@RequestMapping("user")
@Controller
public class UserController  extends BaseController{

	@Autowired
	private DictDao dictDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="users",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject users(@ModelAttribute User user){
		JSONObject json = new JSONObject(); 
		TUser u = new TUser();
		PubFun.copyProperties(u, user);
		u.setPaginationEnable("1");
		List<TUser> list = userDao.getUsers(u);
		for(TUser tu:list){
			tu.setType(dictDao.getDictByValue(tu.getType()).getDictName());
		}
		u.setPaginationEnable("0");
		List<TUser> listTotal = userDao.getUsers(u);
		if (listTotal != null && listTotal.size() > 0) {
			json.put("total", listTotal.size());
		} else {
			json.put("total", 0);
		}
		json.put("rows", JSONObject.toJSON(list));
		return json;
	}
	
	@RequestMapping("openUserDetail/{id}")
	public String openUserDetail(@PathVariable String id,Model model){
		User user = new User();
		TUser tu = userDao.getByCode(id);
		PubFun.copyProperties(user, tu);
		user.setType(dictDao.getDictByValue(user.getType())==null?"":dictDao.getDictByValue(user.getType()).getDictName());
		user.setGender(dictDao.getDictByValue(user.getGender())==null?"":dictDao.getDictByValue(user.getGender()).getDictName());
		user.setIsVisible(dictDao.getDictByValue(user.getIsVisible())==null?"":dictDao.getDictByValue(user.getIsVisible()).getDictName());
		model.addAttribute("user", user);
		return "system/user/userDetailPage";
	}	
	
	@RequestMapping(value = "user",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject insert(@Valid @ModelAttribute User user,Model model,BindingResult result){
		JSONObject json = new JSONObject();
		if (result.hasErrors()) {
			FieldError error = result.getFieldError();
			json.put("res", "1");
			returnFailJson(json, error.getDefaultMessage());
			return json ;
		}
		try {
			Session session = PubFun.getCurrentSession();
			//PubFun.fillCommonProptities(org, true,session);
			user.setId(getUUID());
			json = userService.add(user);
		} catch (RbackException e) {
			e.printStackTrace();
			json = new JSONObject();
			returnFailJson(json, e.getMsg());
		}finally{
			return json  ;
		}
	}
	

	@RequestMapping(value = "user/{id}",method=RequestMethod.DELETE,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject delete(@PathVariable String id){
		JSONObject json = new JSONObject();
		try {
			json = userService.delete(id); 
		} catch (RbackException e) {
			e.printStackTrace();
			json = new JSONObject();
			returnFailJson(json, e.getMsg());
		}finally{
			return json  ;
		}
	}
}
