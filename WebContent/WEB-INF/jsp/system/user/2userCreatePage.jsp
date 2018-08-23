<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.bw.fit.common.util.*" pageEncoding="UTF-8"%><jsp:include
	page="/common.jsp" /><%@ include file="/include.inc.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"> 
	function userCreateSubmit() {
		if (!$("#userCreatePageFm").form('enableValidation')
				.form('validate')) {
			return;
		}
		$.ajax({
			type : 'POST',
			url : ctx + "system/createUser",
			data : serializeFormToJSON($("#userCreatePageFm")
					.serializeArray()),
			success : function(data) {
				promptMessageCallBack(data.res, data.msg, function() {
					completeSubmitCall(data, "2", "userlisttdg", "close");
				});
			},
			dataType : "JSON"
		});
	}
</script>
</head>
<body>
	<form id="userCreatePageFm" class="easyui-form" method="post"
		data-options="novalidate:false">
		<div style="margin-bottom: 20px">
			<input class="easyui-textbox" name="user_cd" style="width: 50%"
				data-options="label:'用户账号:',required:true">
		</div>
		<div style="margin-bottom: 20px">
			<input class="easyui-textbox" name="user_name" style="width: 50%"
				data-options="label:'用户姓名:',required:true">
		</div>
		<div style="margin-bottom: 20px">
			<input class="easyui-combotree" name="company_id"
				data-options="url:'<%=basePath%>system/getCompanyTree/0',method:'get',label:'上级组织:',required:true"
				style="width: 50%">
		</div>
		<div style="margin-bottom: 20px">
			<input class="easyui-textbox" name="phone" style="width: 50%"
				data-options="label:'联系电话:',required:true">
		</div>
		<div style="margin-bottom:20px">
			<input class="easyui-combobox" name="postion_ids" style="width:50%;" data-options="
					url:'<%=basePath%>system/getPostionList',limitToList:true,
					method:'get',
					valueField:'fdid',
					textField:'postion_name', 
					multiple:true, 
					label: '岗位:' 
					">
		</div>
		<div style="margin-bottom:20px">
			<input class="easyui-combobox" name="role_ids" style="width:50%;" data-options="
					url:'<%=basePath%>system/getAllRoles',limitToList:true,
					method:'get',
					valueField:'fdid',
					textField:'role_name', 
					multiple:true, 
					label: '角色:' 
					">
		</div>
		<div style="margin-bottom: 20px">
			<input class="easyui-numberbox" name="user_order" style="width: 50%"
				data-options="label:'序号:',required:true">
		</div>
	</form>
	<div style="position: fixed; right: 30px; bottom: 20px;">
		<button class="easyui-linkbutton" type=button
			onclick="userCreateSubmit()" style="width: 80px">保存</button>
	</div>
</body>
</html>