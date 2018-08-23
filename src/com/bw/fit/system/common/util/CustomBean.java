package com.bw.fit.system.common.util;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

@Component
public class CustomBean {

	@PostConstruct  
    public void  initApp(){  
		System.out.println("init...");
		// context.setAttribute("ctx", PropertiesUtil.getValueByKey("system.default.url"));
    }  
}
