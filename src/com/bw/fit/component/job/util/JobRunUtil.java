package com.bw.fit.component.job.util;

import java.util.List;

import javax.annotation.PostConstruct;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bw.fit.component.job.dao.JobDao;
import com.bw.fit.component.job.entity.TJob;
import com.bw.fit.system.common.util.QuartzManager;
import com.bw.fit.system.common.util.Test;


public class JobRunUtil {

    public static String JOB_NAME = "任务调度";  
    public static String TRIGGER_NAME = "系统任务触发器";  
    public static String JOB_GROUP_NAME = "XLXXCC_JOB_GROUP";  
    public static String TRIGGER_GROUP_NAME = "XLXXCC_JOB_GROUP"; 
    
    @Autowired
    private JobDao jobDao;
    
	@PostConstruct
	public void runAllJobTask() throws Exception{
		TJob t = new TJob();
		t.setIsValid("1");
		List<TJob> list = jobDao.all(t);
		for(TJob tb:list){
	        QuartzManager.addJob(tb.getId(), JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, Class.forName(tb.getCodeData()), tb.getRunTime()); 
		}   
	}
	
	public void remove(String jobName) {
		QuartzManager.removeJob(jobName,JOB_GROUP_NAME,TRIGGER_NAME,TRIGGER_GROUP_NAME); 
	}
}
