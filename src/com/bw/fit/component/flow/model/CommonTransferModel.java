package com.bw.fit.component.flow.model;

import java.util.List;
import java.util.Map;

import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.common.util.PubFun; 

public class CommonTransferModel {
	/***
	 * 起草时候，就把这些信息填写。
	 * 后面流程节点里就能获取到
	 * 这些信息，以便分辨，和利用。
	 * 如果在中间的节点中增加信息的话，那么就扩充字段。
	 * ***/
	private String fdid =PubFun.getUUID();
	private Account account ;
	private String flow_flag ;
	private Map<String,Object> node_info; /***key保存的是节点id值，value保存的参数信息***/
	
	
	
	
	public String getFdid() {
		return fdid;
	}
	
	public Map<String, Object> getNode_info() {
		return node_info;
	}

	public void setNode_info(Map<String, Object> node_info) {
		this.node_info = node_info;
	}

	public void setFdid(String fdid) {
		this.fdid = fdid;
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getFlow_flag() {
		return flow_flag;
	}
	public void setFlow_flag(String flow_flag) {
		this.flow_flag = flow_flag;
	}
	
}
