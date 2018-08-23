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
	function clearForm2() {
		$('#createpostionPageFm').form('clear');
	}

	function createPostSubmitFm() {
		if (!$("#createpostionPageFm").form('enableValidation')
				.form('validate')) {
			return;
		}
		$.ajax({
			type : 'POST',
			url : ctx + "system/createPostion",
			data : serializeFormToJSON($("#createpostionPageFm")
					.serializeArray()),
			success : function(data) {
				promptMessageCallBack(data.res, data.msg, function() {
					completeSubmitCall(data, "2", "postionlisttdg", "close");
				});
			},
			dataType : "JSON"
		});
	}
</script>
</head>
<body>
	<form 
		id="createpostionPageFm" class="easyui-form" method="post"
		data-options="novalidate:false">
		<div class="fit_form_row">
			<input class="easyui-textbox" name="postion_name" 
				data-options="label:'岗位名称:',required:true">
		</div>
		<div class="fit_form_row">
			<input class="easyui-textbox" name="desp"
				 data-options="label:'岗位说明:',required:true">
		</div>
	</form>
	<div style="position: fixed; right: 30px; bottom: 20px;">
		<button class="easyui-linkbutton" type=button
			onclick="createPostSubmitFm()" style="width: 80px">保存</button>
	</div>
</body>
</html>