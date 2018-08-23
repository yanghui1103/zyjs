package com.bw.fit.system.common.util;

import java.util.Arrays;
import java.util.List;
import static com.bw.fit.system.common.util.PubFun.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;

import com.fasterxml.jackson.databind.ObjectMapper; 
public class LogAspect implements  Ordered { 

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 1;
	}
	  public Object aroundMethod(ProceedingJoinPoint pjd) { 
		  return
				  null ;
	  } 
}
