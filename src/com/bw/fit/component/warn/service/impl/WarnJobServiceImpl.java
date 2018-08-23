package com.bw.fit.component.warn.service.impl;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.bw.fit.component.warn.service.WarnJobService;
import com.bw.fit.component.warn.service.WarnService;
import com.bw.fit.system.common.util.PropertiesUtil;

public class WarnJobServiceImpl implements WarnJobService,Job {
	
	@Override
	public void warn() {
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		WarnService warnService = (WarnService) wac.getBean("warnService");
		warnService.sdaitWarns(PropertiesUtil.getValueByKey("job_robot"));
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		warn();
	}

}
