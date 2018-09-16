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
			onclick="sendMail();"  style="width: 150px">发送</button>
	</div>
	
	<div style="margin:30px 0px;"></div>
	<form id="mailSendFm"  class="easyui-form" method="post"
		data-options="novalidate:false">
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>名称</div>
			<input class="easyui-textbox" readonly value="${esta.name }" style="width: 80%;paddding-right:2px"   >
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>类型</div>
			<select class="easyui-combogrid" name="type" editable="false"
				style="width: 30%"
				data-options="limitToList:true,
					panelWidth: 300,
					idField: 'dict_value',
					textField: 'dict_name',
					url: '<%=basePath%>dict/getDictsByParentValue/mailType',
					method: 'get', 
					columns: [[
						{field:'dict_value',title:'值',width:50},
						{field:'dict_name',title:'名称',width:140} 
					]],
					fitColumns: true, 
					required:true
				">
			</select>
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>发送内容</div>
			<input class="easyui-textbox" name="remark" style="width: 80%;paddding-right:2px;height:60px;"  
				data-options="required:true,validType:['length[0,200]'],multiline:true">
		</div>
		<input name="objId" value="${esta.id }" type="hidden">
	</form>
	
<script type="text/javascript">
function sendMail(){
	promptMessageCallBack("3","是否确认发送站内信？",function(){					
		$.ajax({
			type : 'POST',
			url : ctx + "innerMail/innerMail" ,
			data :  serializeFormToJSON($("#mailSendFm").serializeArray()),
			success : function(data) {
				promptMessageCallBack(data.res, data.msg,function(){
				} );
			},
			dataType : "JSON"
		});
	});
}

</script>
</body>
</html>