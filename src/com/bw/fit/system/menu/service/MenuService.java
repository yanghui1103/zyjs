package com.bw.fit.system.menu.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.menu.model.Menu;

public interface MenuService {

	/****
	 * 获取父子节点json
	 * @param menus
	 * @return
	 */
	public JSONArray getMenuTreeJson(List<Menu> menus);
}
