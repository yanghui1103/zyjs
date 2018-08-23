<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><jsp:include page="/common.jsp" />
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
</head>
<body><div style="margin:20px 0;"></div>
	<form  id="createrolePageFm" class="easyui-form" method="post"
		data-options="novalidate:false">
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<input class="easyui-textbox" name="role_name" id="role_name222" style="width: 80%"
				data-options="required:true">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px"> 
			<label>组织名称3:</label>
			<input class="easyui-textbox" name="role_name" style="width: 80%"
				data-options="required:true">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px"> 
			<label>组织简拼:</label>
			<input class="easyui-textbox" name="role_name" style="width: 80%"
				data-options="required:true">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px"> 
			<label>父组织:</label>
			<input class="easyui-textbox" name="role_name" style="width: 80%"
				data-options="required:true">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px"> 
			<label>类型:</label>
			<input class="easyui-textbox" name="role_name" style="width: 80%"
				data-options="required:true">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px"> 
			<label>地址薄显示与否:</label>
			<input class="easyui-textbox" name="role_name" style="width: 80%"
				data-options="required:true">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px"> 
			<label>法人/负责人:</label>
			<input class="easyui-textbox" name="role_name" style="width: 80%"
				data-options="required:true">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px"> 
			<label>联系电话:</label>
			<input class="easyui-textbox" name="role_name" style="width: 80%"
				data-options="required:true">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px"> 
			<label>地址:</label>
			<input class="easyui-textbox" name="role_name" style="width: 80%"
				data-options="required:true">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px"> 
			<label>邮编:</label>
			<input class="easyui-textbox" name="role_name" style="width: 80%"
				data-options="required:true">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px"> 
			<label>组织简介:</label>
			<input class="easyui-textbox" name="role_name" style="width: 80%"
				data-options="required:true">
		</div>
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#role_name222').textbox({
				label: 'Email:'  
			});
		});
	</script>
	</form>	
</body>
</html>