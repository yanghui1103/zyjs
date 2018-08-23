package com.bw.fit.system.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.menu.dao.MenuDao;
import com.bw.fit.system.menu.model.Menu;
import com.sun.el.stream.Optional;

@RequestMapping("menu")
@Controller
public class MenuController extends BaseController {

	@Autowired
	private MenuDao menuDao;
	
	/****
	 * 获取所有的菜单
	 * @return
	 */
	@RequestMapping(value="menus/{roleId}",method=RequestMethod.GET)
	@ResponseBody
	public JSONArray menus(@PathVariable String roleId){
		List<Menu> menus = menuDao.getMenus();
		List<Menu> myMenus = menuDao.getMyRole2Menus(roleId);
		JSONArray array = new JSONArray();
		for(Menu m:menus){
			JSONObject j = new JSONObject();
			j.put("id", m.getId());
			j.put("name", m.getTitle());
			j.put("pId",m.getParentId());
			j.put("open", true);
			if(myMenus!=null){
				java.util.Optional<Menu> ops = myMenus.parallelStream().filter(x->x.getId().equals(m.getId())).findAny();
				if(ops.isPresent()){
					j.put("checked", true);
				}
			}
			array.add(j);
		}
		return  array ;
	}
}
