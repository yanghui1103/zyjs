<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><jsp:include page="/common.jsp" /><%@ include file="/include.inc.jsp"%>
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
			onclick="addAccount();" style="width: 150px">保存</button>
	</div>
	
	<div style="margin:30px 0px;"></div>
	<form id="accountAddFm"  class="easyui-form" method="post"
		data-options="novalidate:false">
		
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>账号</div>
			<input class="easyui-textbox"  name="logName" style="width: 80%;paddding-right:2px"  
				data-options="required:true,validType:['length[4,10]']">
		</div>
				
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>用户编码</div>
			<input class="easyui-textbox"  name="userId" style="width: 80%;paddding-right:2px"  
				data-options="required:true">
		</div>
		
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>岗位</div>
			<input class="easyui-textbox address-select-position"  editable=false  name="postionNames" style="width: 80%;paddding-right:2px"  
				data-options="required:true">
			<input type="hidden"  name="positionIds"  
				data-options="required:true">
		</div>
		
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>组织</div>
			<input class="easyui-textbox address-select-org"  editable=false   style="width: 80%;paddding-right:2px"  
				data-options="required:true">
			<input type="hidden"  name="currentOrgId"  
				data-options="required:true">
		</div>
		
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>角色</div>
				
			<select class="easyui-combobox" name="roleIds" multiple="true" multiline="true"  editable=false
				data-options="required:true"   style="width: 80%;paddding-right:2px"  >
				<c:forEach var="item" items="${allRoles}" varStatus="status">
					<option value="${item.id }">${item.name }</option>
				</c:forEach>
			</select>
		</div>
		
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>排序号</div>
			<input class="easyui-numberbox" name="sortNumber" style="width: 80%;paddding-right:2px"  
				data-options="">
		</div>
				
	</form>	
	
	
	<script type="text/javascript" src="<%=basePath%>common/js/system/address/addressPage.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/js/system/account/accountAddPage.js"></script>
</body>
</html>