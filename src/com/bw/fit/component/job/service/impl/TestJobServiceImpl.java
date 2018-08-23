package com.bw.fit.component.job.service.impl;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.bw.fit.component.job.service.TestJobService;

public class TestJobServiceImpl implements TestJobService,Job {
	WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();    
	  
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		 // wac.getBean("");  
		 tt();
	}

	@Override
	public void tt() {
		System.out.println("tt...");
	}

}
