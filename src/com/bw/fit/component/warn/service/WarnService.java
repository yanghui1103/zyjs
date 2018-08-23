package com.bw.fit.component.warn.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.component.warn.entity.TWarn;
import com.bw.fit.system.common.model.RbackException;

public interface WarnService {
	/*****
	 * 接收来自各个模块的预警需求
	 * @param warningLevel 预警级别:值详见数据字典
	 * @param warningType 预警方式:值详见数据字典
	 * @param target_number 手机号码;用户ID;email邮箱名称
	 * @param message 消息数据
	 * @return
	 * @throws RbackException
	 */
	public JSONObject createWarning(String warningLevel,String warningType ,String target_number,String subject,String message) throws RbackException;
	/****
	 * 获取全部预警信息
	 * @param warn
	 * @return
	 */
	public List<TWarn> all(TWarn warn);
	/***
	 * 发送等待预警
	 * @return
	 */
	public void sdaitWarns(String runner);
}
