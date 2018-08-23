package com.bw.fit.system.common.interceptor;

import java.util.LinkedHashMap;
/*****
 * 配置验证与否
 * @author yangh
 *
 */
public class FilterChainDefinitionMapBuilder {

	public LinkedHashMap<String, String> buildFilterChainDefinitionmap(){
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

		map.put("/common/**", "anon");
		map.put("/themes/**", "anon");
		map.put("/plugins/**", "anon");
		map.put("/upLoadFiles/**", "anon");
		map.put("/system/login", "anon");
		map.put("/system/logout", "logout");

		map.put("/**", "authc");
		return map;
	}
}
