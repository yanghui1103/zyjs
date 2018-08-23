package com.bw.fit.component.flow.service.impl;
import java.util.*;

import org.activiti.engine.HistoryService;  
import org.activiti.engine.IdentityService;  
import org.activiti.engine.ProcessEngine;  
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;  
import org.activiti.engine.RepositoryService;  
import org.activiti.engine.RuntimeService;  
import org.activiti.engine.TaskService;  
import org.activiti.engine.history.HistoricTaskInstance;  
import org.activiti.engine.identity.Group;  
import org.activiti.engine.identity.User;  
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;  
import org.activiti.engine.impl.pvm.PvmActivity;  
import org.activiti.engine.impl.pvm.PvmTransition;  
import org.activiti.engine.impl.pvm.process.ActivityImpl;  
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;  
import org.activiti.engine.impl.pvm.process.TransitionImpl;  
import org.activiti.engine.runtime.ProcessInstance;  
import org.activiti.engine.task.Task;  
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;
  
@Component
public class ActivitiUtil { 
 
	// 创建流程引擎
    static ProcessEngine  processEngine =  ProcessEngines.getDefaultProcessEngine();
	// 得到流程存储服务组件
    static RepositoryService repositoryService = processEngine.getRepositoryService(); 
	// 得到运行时服务组件
    static RuntimeService runtimeService = processEngine.getRuntimeService(); 
	// 获取流程任务组件
    static TaskService taskService = processEngine.getTaskService();
    static HistoryService historyService = processEngine.getHistoryService();
    static IdentityService identityService = processEngine.getIdentityService();
    
    public static void taskRollBack(String taskId){  
        try {  
            Map<String, Object> variables;  
            // 取得当前任务  
            HistoricTaskInstance currTask = historyService
                    .createHistoricTaskInstanceQuery().taskId(taskId)  
                    .singleResult();
            // 取得流程实例 
            ProcessInstance instance = runtimeService  
                    .createProcessInstanceQuery()  
                    .processInstanceId(currTask.getProcessInstanceId())  
                    .singleResult();  
            if (instance == null) {  
                //流程结束  
            }  
            variables = instance.getProcessVariables();  
            // 取得流程定义  
            ProcessDefinitionEntity definition = (ProcessDefinitionEntity) (processEngine.getRepositoryService().getProcessDefinition(currTask  
                            .getProcessDefinitionId()));  
             
            if (definition == null) {  
                //log.error("流程定义未找到");  
                return ;  
            }  
            // 取得上一步活动  
            ActivityImpl currActivity = ((ProcessDefinitionImpl) definition)  
                    .findActivity(currTask.getTaskDefinitionKey());  
            List<PvmTransition> nextTransitionList = currActivity  
                    .getIncomingTransitions();  
            // 清除当前活动的出口  
            List<PvmTransition> oriPvmTransitionList = new ArrayList<PvmTransition>();  
            List<PvmTransition> pvmTransitionList = currActivity  
                    .getOutgoingTransitions();  
            for (PvmTransition pvmTransition : pvmTransitionList) {  
                oriPvmTransitionList.add(pvmTransition);  
            }  
            pvmTransitionList.clear();  
   
            // 建立新出口  
            List<TransitionImpl> newTransitions = new ArrayList<TransitionImpl>();  
            for (PvmTransition nextTransition : nextTransitionList) {  
                PvmActivity nextActivity = nextTransition.getSource();  
                ActivityImpl nextActivityImpl = ((ProcessDefinitionImpl) definition)  
                        .findActivity(nextActivity.getId());  
                TransitionImpl newTransition = currActivity  
                        .createOutgoingTransition();  
                newTransition.setDestination(nextActivityImpl);  
                newTransitions.add(newTransition);  
            }  
            // 完成任务  
            List<Task> tasks = taskService.createTaskQuery()  
                    .processInstanceId(instance.getId())  
                    .taskDefinitionKey(currTask.getTaskDefinitionKey()).list();  
            for (Task task : tasks) {  
                taskService.complete(task.getId(), variables);  
                historyService.deleteHistoricTaskInstance(task.getId());  
            }  
            // 恢复方向  
            for (TransitionImpl transitionImpl : newTransitions) {  
                currActivity.getOutgoingTransitions().remove(transitionImpl);  
            }  
            for (PvmTransition pvmTransition : oriPvmTransitionList) {  
                pvmTransitionList.add(pvmTransition);  
            }  
   
            
            return ;  
        } catch (Exception e) {  
             
            return ;  
        }  
    }  
}
