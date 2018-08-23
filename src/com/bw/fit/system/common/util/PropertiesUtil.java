package com.bw.fit.system.common.util;

import java.util.*;

import org.springframework.stereotype.Component;

public class PropertiesUtil {
	private static String fileName ="com/bw/fit/system/common/conf/keyValuePropConf" ;	
	public static String getValueByKey(String key){
		ResourceBundle rb=null;
		try {
			rb = ResourceBundle.getBundle(fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return rb.getString(key);
	} 
}
