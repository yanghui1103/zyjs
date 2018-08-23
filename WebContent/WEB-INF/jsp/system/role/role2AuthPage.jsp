<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="<%=basePath%>common/fit/v4/common/common.js"></script>
<link href="<%=basePath%>common/fit/v4/static/lightblue/css/base.css"
	rel="stylesheet">
<link
	href="<%=basePath%>common/fit/v4/custom/lightblue/uimaker/easyui.css"
	rel="stylesheet">
<link href="<%=basePath%>common/fit/v4/static/lightblue/css/index.css"
	rel="stylesheet">
<link
	href="<%=basePath%>common/fit/v4/static/lightblue/css/basic_info.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>common/fit/v4/custom/lightblue/uimaker/icon.css">
<script type="text/javascript"
	src="<%=basePath%>common/fit/v4/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>common/fit/v4/js/jquery.easyui.min.js"></script>

</head>
<body>
	<div style="float: right;margin-right:30px;margin-top:5px" >
		<button class="easyui-linkbutton" type=button iconCls="icon-add" data-options="selected:true"
			onclick="addRole2Auths();" style="width: 150px">保存</button>
	</div>
	<form id="role2AuthFm">
	 <div class="easyui-tabs1" style="width: 100%;">
		<div class="column">
			<span class="current">角色信息</span>
		</div>
		<div class="easyui-panel"
			style="width: 100%; max-width: 900px; padding: 30px 60px;">
			<ul><label>${role.name }	</label>
			</ul>
		</div>
		<input name="temp_str1"  value=${role.id } type="hidden">
		<input name="_method"  value="PUT" type="hidden">
		
		<div class="column">
			<span class="current">功能权限信息</span>
		</div>
		<div class="easyui-panel"
			style="width: 100%; max-width: 900px; padding: 30px 60px;">
			<ul>
			<c:forEach items="${all}" var ="item" varStatus="status">
				<li>
				<c:if test="${item.desp =='checked'}">
				<input name="id" value='${item.code }' checked='checked' type="checkbox" /><label>${item.name }</label>
				</c:if>
				<c:if test="${item.desp !='checked'}">
				<input name="id" value='${item.code }'   type="checkbox" /><label>${item.name }</label>
				</c:if>
				
				
				</li>
			</c:forEach>
			</ul>
		</div>
	 </div>
	</form>
	<script type="text/javascript">
		function addRole2Auths(){
			promptMessageCallBack("3","是否该角色修改功能权限？",function(){					
				$.ajax({
					type : 'POST',
					url : ctx + "role/authsOfRole" ,
					data :   ($("#role2AuthFm").serialize()),
					success : function(data) {
						promptMessage(data.res, data.msg );
					},
					dataType : "JSON"
				});
			});
		}
	</script>
</body>
</html>