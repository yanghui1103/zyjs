package com.bw.fit.system.common.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.bw.fit.system.common.model.BaseModel;


public abstract class BaseController {
	
//	private Logger logger = LoggerFactory.getLogger(BaseController.class);  	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}	

	/*****
	 *	适用于跨域请求
	 * @param response
	 */
	@ModelAttribute
	public void initControlKReq(HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
	}
	
	
	
}
