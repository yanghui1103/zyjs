package com.bw.fit.component.log.aspect;

import java.lang.reflect.Method;
import java.util.*;

import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import static com.bw.fit.system.common.util.PubFun.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.session.Session;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.component.log.model.LogInfo;
import com.bw.fit.component.log.service.LogService; 

/****
 * 拦截controller请求的日志切面
 * @author yangh
 *
 */
@Component(value="mainLogAspect")
public class ControllerLogAspect implements Ordered {
	@Autowired  
	HttpServletRequest request; 
	@Autowired
	private LogService logService;

	@Override
	public int getOrder() {
		return 1;
	}

	public Object aroundMethod(ProceedingJoinPoint pjd) {
		// 通过分析aop监听参数分析出request等信息
		List<Object> list = Arrays.asList(pjd.getArgs());
		Object obj = null;
		try {
			Signature sig = pjd.getSignature();
			MethodSignature msig = null;
			if (!(sig instanceof MethodSignature)) {
				throw new IllegalArgumentException("该注解只能用于方法");
			}
			msig = (MethodSignature) sig;
			Object target = pjd.getTarget();
			Method currentMethod = target.getClass().getMethod(msig.getName(),
					msig.getParameterTypes());

			obj = pjd.proceed(); // 执行
			LogInfo t = new LogInfo();   
			Account account = PubFun.getCurrentAccount();
			if(account==null){ //如果为空，疑似系统本身发起
				account = new Account();
				account.setLogName("-9");
				account.setName("SYSTEM");
			}
			t.setId(getUUID());
			t.setCreator(account.getLogName()+account.getName());
			t.setOperateFunction(target.getClass().getName()+"."+currentMethod.getName());
			String classType = pjd.getTarget().getClass().getName();    
	        Class<?> clazz = Class.forName(classType);   
			String clazzName = clazz.getName();    
	        String methodName = pjd.getSignature().getName(); //获取方法名称   
	        Object[] args = pjd.getArgs();//参数  
			Map<String,Object > nameAndArgs = PubFun.getFieldsNameAndValue(this.getClass(), clazzName, methodName,args);   
			t.setParams(nameAndArgs.toString());
			t.setResult(obj==null?"":obj.toString());
			t.setLogType("mainlog");
			logService.notice(t);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}
	
}
