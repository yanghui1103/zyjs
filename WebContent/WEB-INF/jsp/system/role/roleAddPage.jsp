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
<body>
	<div style="float: right;margin-right:30px;margin-top:5px" >
		<button class="easyui-linkbutton" type=button iconCls="icon-add" data-options="selected:true"
			onclick="addNewRole();" style="width: 150px">保存</button>
	</div>
	
	<div style="margin:30px 0px;"></div>
	<form id="roleAddFm"  class="easyui-form" method="post"
		data-options="novalidate:false">
		
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>名称</div>
			<input class="easyui-textbox"  name="name" style="width: 80%;paddding-right:2px"  
				data-options="required:true,validType:['length[0,20]']">
		</div>
		
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>描述</div>
			<input class="easyui-textbox"  name="desp" style="width: 80%;paddding-right:2px"  
				data-options="validType:['length[0,30]']">
		</div>
	</form>	
	
	
	<script type="text/javascript" src="<%=basePath%>common/js/system/role/roleAddPage.js"></script>
</body>
</html>