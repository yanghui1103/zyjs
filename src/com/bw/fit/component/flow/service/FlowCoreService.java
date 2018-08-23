package com.bw.fit.component.flow.service;

import java.util.*;


import org.activiti.engine.history.HistoricIdentityLink;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Attachment;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task; 

import com.bw.fit.system.common.model.RbackException;

import java.awt.image.*;
import java.io.IOException;
import java.io.InputStream;

/****
 * 流程引擎组件（核心部件）
 * @author yangh
 *
 */
public interface FlowCoreService {

	/*****
	 * 部署资源
	 * @param resourcePath
	 * @return
	 */
	public Deployment deployFlowResource(String resourcePath); 
	/****
	 * 启动流程
	 * @param key 流程定义Key
	 * @param vars 发起时候所带的参数
	 * @return
	 */
	public ProcessInstance startProcessInstanceByKey(String key,Map<String,Object> vars);
	/** 
     * 驳回流程 
     * @param taskId  当前任务ID 
     * @param activityId   驳回节点ID 
     * @param variables  流程存储参数 
     * @throws Exception 
     */  
    public void rollBack(String taskId, String backActivityId,Map<String, Object> variables) throws Exception;
    /*****
     * 挂起流程定义，流程就不能被启动
     * @param defId
     */
    public void suspendProcessDefinitionById(String defId); 
    /****
     * 挂起流程定义，流程就不能被启动
     * @param defKey
     */
    public void suspendProcessDefinitionByKey(String defKey);
    /*****
     * 激活流程定义
     * @param defId
     */
    public void activateProcessDefinitionById(String defId);
    /*****
     * 激活流程定义
     * @param defKey
     */
    public void activateProcessDefinitionByKey(String defKey);
    /****
     * 这个用户组可以启动流程，创建流程实例
     * @param defId 定义id
     * @param groupId 用户组id
     */
    public void addCandidateStarterGroup(String defId,String groupId);
    /****
     * 这个用户组可以启动流程，创建流程实例
     * @param defId 定义id
     * @param userId 用户id
     */
    public void addCandidateStarterUser(String defId,String userId);
    /*****
     * 这个用户id有权利启动的流程列表
     * @param userId
     * @return
     */
    public List<ProcessDefinition> getCanStartableByUser(String userId); 
    /****
     * 获取定义的流程图
     * @param defId
     * @return
     * @throws Exception
     */
    public BufferedImage getProcessDiagramByDefId(String defId) throws Exception; 
    /*****
     * 删除部署资源及相关联全部数据
     * @param defId 定义的ID
     * @param b 是否删除相关数据
     * @throws Exception
     */
    public void deleteDeploymentCasCade(String defId,boolean b) throws Exception; 
    /****
     * 创建任务
     */
    public void createTask(); 
    /****
     * 新建任务，并分配任务id
     * @param taskId 被分配的任务id
     */
    public void createTask(String taskId);
    /****
     * 删除任务,及相关数据
     * @param taskId
     * @param b 是否级联删除相关数据
     */
    public void deleteTaskCascade(String taskId,boolean b); 
    /****
     * 删除任务集合,及相关数据
     * @param taskIds
     * @param b 是否级联删除相关数据
     */
    public void deleteTaskCascade(Collection<String> taskIds,boolean cascade);
    /****
     * 创建用户组与任务之间的关联关系，即绑定候选关系
     * @param taskId
     * @param groupId
     */
    public void createTaskGroupRelation(String taskId,String groupId);  
    /****
     * 创建人与任务之间的关联关系，绑定候选关系
     * @param taskId
     * @param userId
     */
    public void createTaskUserRelation(String taskId,String userId);	 
    /****
     * 删除用户组与任务之间的关联关系
     * @param taskId
     * @param groupId
     */
    public void deleteGroupTaskRelation(String taskId,String groupId); 
    /****
     * 删除用户与任务之间候选关系，
     * @param taskId
     * @param userId
     * @param type
     */
    public void deleteUserTaskRelation(String taskId,String userId,String type);
    /****
     * 这个用户组带处理的任务集合
     * @param groupId
     * @return
     */
    public List<Task> getTasksOfTheGroup(String groupId);  
    /****
     * 此用户拥有的待办任务
     * @param userId
     * @return
     */
    public List<Task> getTasksOfTheUser(String userId);   
    /****
     * 重点：设置任务的持有人（非受理人）
     * @param taskId
     * @param userId
     */
    public void createTaskOwner(String taskId,String userId); 
    /****
     * 设置任务的受理人，这个人处理代办(道理同转办)
     * @param taskId
     * @param userId
     */
    public void createTaskAssignee(String taskId,String userId); 
    /***
     * 上传附件
     * @param taskId
     * @param processinstanceId
     * @param name
     * @param descp
     * @param type
     * @param url
     */
    public void createAttachment(String taskId,String processinstanceId,String name,String descp,String type,String url);
    public void createAttachment(String taskId,String processinstanceId,String name,String descp,String type,String url,InputStream is);
    /****
     * 删除附件
     * @param attachmentId
     */
    public void deleteAttachment(String attachmentId);
    /****
     * 此流程定义下所有附件
     * @param processInstanceId
     * @return
     */
    public List<Attachment> getAttachmentsOfProccesInstance(String processInstanceId);
    /****
     * 此任务下所有附件
     * @param taskId
     * @return
     */
    public List<Attachment> getAttachmentsOfTheTask(String taskId);
    
    /*****
     * 给此任务增加评论
     * @param taskId
     * @param processInstanceId
     * @param message
     */
    public void createTaskComment(String taskId,String processInstanceId,String message);
    /*****
     * 给此任务增加评论
     * @param task
     * @param message
     */
    public void createTaskComment(Task task,String message);  
    /****
     * 获取此任务上所有的评论
     * @param taskId
     * @return
     */
    public List<Comment> getCommentOfTheTask(String taskId);
    /****
     * 该流程实例上所有评论
     * @param instanceId
     * @return
     */
    public List<Comment> getCommentOfProcessInstance(String instanceId);
    /****
     * 完成任务
     * @param task
     * @param vars
     */
    public void completeTask(Task task,Map<String,Object> vars); 
    /****
     * 启动流程
     * @param processDefiniedId
     */
    public void startProcessByPdId(String processDefiniedId);
    /****
     * 启动流程
     * @param processDefiniedId
     * @param vars
     */
    public void startProcessByPdId(String processDefiniedId,Map<String,Object> vars);
    /****
     * 启动流程
     * @param processDefiniedId
     * @param bussiness_key
     */
    public void startProcessByPdId(String processDefiniedId,String bussiness_key);
    /***
     * 启动流程
     * @param processDefiniedId
     * @param bussiness_key
     * @param vars
     */
    public void startProcessByPdId(String processDefiniedId,String bussiness_key,Map<String,Object> vars);
    /****
     * 
     * @param exeId
     */
    public void signalProcess(String exeId);
    /****
     * 触发流程继续执行下去,并往下传值(这个参数值将在整个流程中有效)
     * @param exeId
     * @param vars 这个参数值将在整个流程中有效
     */
    public void signalProcess(String exeId,Map<String,Object> vars); 
    /****
     * 挂起流程实例
     * @param processInstanceId
     */
    public void suspendProcessInstanceByPiId(String processInstanceId); 
    /****
     * 实例是否挂起
     * @param processInstanceId
     * @return
     */
    public boolean isProcessSuspend(String processInstanceId); 
    /****
     *  实例是否结束
     * @param processInstanceId
     * @return
     */
    public boolean isProcessEnd(String processInstanceId);  
    /****
     * 激活流程实例
     * @param processInstanceId
     */
    public void activateProcessInstanceByPiId(String processInstanceId); 
    /****
     * 删除流程实例
     * @param piid
     * @param reason
     */
    public void deleteProcessInstance(String piid,String reason);  
    /****
     * 驳回当前这个任务[此任务非多人任务]
     * @param currentTaskId
     * @throws Exception
     */
    public void rollBackProcess(String currentTaskId) throws Exception;
    /****
     * 当前执行分支是否完毕，多人任务
     * @param execution
     * @return
     */
    public boolean isJonitTaskCompleted(ActivityExecution execution) ;
    /****
     * 这个任务的候选人和直接参与人，候选人是组用户
     * @param taskId
     * @return
     */
    public List<HistoricIdentityLink> getDealersOfTheTask(String taskId);
    /****
     * 判断任务是不是多例任务会审/会签任务   true 为多例任务
     * @param taskId
     * @return
     */
    public boolean getMultiInstanceTask(String taskId);
    /***
     * 获取一个用户的组任务，个人代办任务并集
     * @param userId
     * @return
     */
    public List<Task> getCurrentTasksOfUser(String userId);
    /***
     * 获取用户参与过的历史任务,finished:true 只查询已经完成的历史任务，false为全部历史任务
     * @param userId
     * @param finished
     * @return
     */
    public List<HistoricTaskInstance> getUserhistoryTaskInstance(String userId,boolean finished);
    /***
     * 根据流程实例id查询历史的任务列表
     * @param processInstanceId
     * @return
     */
    public List<HistoricTaskInstance> getHistoryTaskInstance(String processInstanceId);
    /***
     * 根据流程定义ID,节点Code,查询出，这个节点上处理人们
     */
    // public String getThisNodeDealers(String flowDefiniedId,String nodeCode);
    /***
     * 认领任务
     * @param taskId
     * @param userId
     */
    public void cliamTaskToUser(String taskId,String userId);
    /***
     * 把这个待办委托给别人
     * @param taskId
     * @param userId
     */
    public void delegateTask(String taskId,String userId);
    /****
     * 被委托人处理任务
     * @param taskId
     */
    public void resolveTask(String taskId);
    /****
     * 被委托人处理任务
     * @param taskId
     * @param vars
     */
    public void resolveTask(String taskId,Map<String,Object> vars);
    /***
     * 如果所有者，当前处理者是不是同一个用户ID,(用于委托办理，如果这俩者不同，那就需要使用完成委托的事情)
     * @param task
     * @return
     */
    public boolean isOwnerAssigneeSameUser(Task task);
    
}
