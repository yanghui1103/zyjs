package com.bw.fit.system.common.listenter;

import static com.bw.fit.system.common.util.PubFun.getLicneceMiWen;

import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.util.EncryptUtil;
import com.bw.fit.system.common.util.PubFun; 

/*****
 * 登录/在线用户/及验证
 * @author yangh
 *
 */
public class MultiSessionListener implements HttpSessionListener,
		HttpSessionAttributeListener {
	private Log log = LogFactory.getLog(MultiSessionListener.class);
	ServletContext sc; 
	// 新建一个session时触发此操作
	public void sessionCreated(HttpSessionEvent event) {
		sc = event.getSession().getServletContext();
		log.info("新建一个session");
	}

	// 销毁一个session时触发此操作
	public void sessionDestroyed(HttpSessionEvent se) {
//		log.info("销毁一个session");
//		if (!list.isEmpty()) {
//			list.remove((LogUser) se.getSession().getAttribute("LogUser"));
//			sc.setAttribute("onLineUserList", list);
//		}
	}

	// 在session中添加对象时触发此操作，在list中添加一个对象
	public void attributeAdded(HttpSessionBindingEvent sbe)  {	
//		try {
//			Object s = ((JSONObject.parse((EncryptUtil.decrypt(getLicneceMiWen("FitLicence")))))); 			
//			if(list ==null || list.size()<1){
//				return ;
//			}
//			List<String> lsall = list.stream().map(x->x.getUser_cd()).distinct().collect(Collectors.toList());
//			if(lsall.size() <= Integer.valueOf(((JSONObject)s).get("user_total").toString())){
//				list.add((LogUser)sbe.getSession().getAttribute("LogUser")); 
//			}else{
//				log.info("Licence人数限制,总数为:"+lsall.size());
//			}
//			if(list!=null && list.size()>0){
//				list.stream().map(x->x.getUser_cd()).forEach(str->System.out.println(str));
//				List<String> ls = list.stream().map(x->x.getUser_cd()).distinct().collect(Collectors.toList());			
//				log.info("当前在线人数:"+ls.size());
//			} 
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	// 修改、删除session中添加对象时触发此操作
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
	}
}