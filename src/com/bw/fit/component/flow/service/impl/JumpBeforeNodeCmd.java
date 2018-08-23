package com.bw.fit.component.flow.service.impl;

import org.activiti.engine.impl.TaskServiceImpl;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.task.Comment; 

public class JumpBeforeNodeCmd implements Command<Comment> {  
	/****
	 * 随意往前任意一个节点跳转,
	 * 但是当前任务不是多例任务
	 * ***/
    protected String executionId;  /**当前执行流**/ 
    protected String activityId;  /***目标活动节点id***/
      
      
    public JumpBeforeNodeCmd(String executionId, String activityId) {  
        this.executionId = executionId;  
        this.activityId = activityId;  
    }  

	@Override
    public Comment execute(CommandContext commandContext) {  
        for (TaskEntity taskEntity : Context.getCommandContext().getTaskEntityManager().findTasksByExecutionId(executionId)) {  
            Context.getCommandContext().getTaskEntityManager().deleteTask(taskEntity, "jump", false);  
        }  
        ExecutionEntity executionEntity = Context.getCommandContext().getExecutionEntityManager().findExecutionById(executionId);  
        ProcessDefinitionImpl processDefinition = executionEntity.getProcessDefinition();  
        ActivityImpl activity = processDefinition.findActivity(activityId);  
        executionEntity.executeActivity(activity);  
        return null;  
    }
 
	public static void main(String[] args){

		// 这个是跳转调用方法代码案例
		//TaskServiceImpl taskServiceImpl=(TaskServiceImpl)taskService;  
		//taskServiceImpl.getCommandExecutor().execute(new JumpBeforeNodeCmd(exe.getId(), taskService.getVariable(task.getId(), "activitiId").toString()));  

	}

}
