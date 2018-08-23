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
			onclick="transferAccount();" style="width: 150px">保存</button>
	</div>
	
	<div style="margin:30px 0px;"></div>
	<form id="accountTransferFm"  class="easyui-form" method="post"
		data-options="novalidate:false">
		
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>账号</div>
			<input class="easyui-textbox"  value="${account.logName }" style="width: 80%;paddding-right:2px"  
				readonly="readonly">
		</div>
				
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>原用户姓名</div>
			<input class="easyui-textbox"  value="${account.name }" style="width: 80%;paddding-right:2px"  
				>
		</div>		
		
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>新用户编码</div>
			<input class="easyui-textbox"  name="userId" style="width: 80%;paddding-right:2px"  
				data-options="required:true">
		</div>		
		<input name="id" value="${account.id }" type="hidden">
		<input name="_method" value="PUT" type="hidden">
	</form>	
	
	
	<script type="text/javascript" src="<%=basePath%>common/js/system/address/addressPage.js"></script>
	<script type="text/javascript">
		function transferAccount(){ 
			if (!$("#accountTransferFm").form('enableValidation')
					.form('validate')) {
				return;
			}
			$.ajax({
				type : 'PUT',
				url : ctx + "account/account",
				data :  $("#accountTransferFm").serialize(),
				success : function(data) {
					promptMessageCallBack(data.res, data.msg,function(){
						accountReloadgrid();
					} );
				},
				dataType : "JSON"
			});

		}
	</script>
</body>
</html>