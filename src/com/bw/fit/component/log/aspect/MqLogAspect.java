package com.bw.fit.component.log.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.bw.fit.system.common.util.PubFun.*;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.component.log.model.LogInfo;
import com.bw.fit.component.log.service.LogService;

/*****
 * 消息队列产品发送数据/消费数据的日志切面
 * 
 * @author yangh
 *
 */
@Component
public class MqLogAspect implements Ordered {
	@Autowired
	private DaoTemplete daoTemplete;
	@Autowired
	private LogService logService;

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 2;
	}

	public void aroundMethod(ProceedingJoinPoint pjd) {
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
			t.setResult(obj.toString());
			t.setLogType("mqlog");
			logService.notice(t);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
