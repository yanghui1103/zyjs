package com.bw.fit.component.flow.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

/*****
 * 待办（领域模型）
 * @author yangh
 *
 */
public class TodoTask {
	@NotEmpty(message="待办id不得为空")	
	private String fdid ; // 同taskId
	@NotEmpty(message="待办主题不得为空")	
	private String task_title;
	private String url;
	private Date create_time ;
	private String formKey;
	private String nodeCode ; // 节点ID
	private String assignee;
	
	
	
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getNodeCode() {
		return nodeCode;
	}
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}
	
	public String getFormKey() {
		return formKey;
	}
	public void setFormKey(String formKey) {
		this.formKey = formKey;
	}
	public String getFdid() {
		return fdid;
	}
	public void setFdid(String fdid) {
		this.fdid = fdid;
	}
	public String getTask_title() {
		return task_title;
	}
	public void setTask_title(String task_title) {
		this.task_title = task_title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
	
	
}
