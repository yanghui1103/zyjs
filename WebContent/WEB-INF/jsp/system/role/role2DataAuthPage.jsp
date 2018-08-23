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
	<form id="role2dataAuthFm">
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
			<span class="current">数据权限信息</span>
		</div>
		<div class="easyui-panel"
			style="width: 100%; max-width: 900px; padding: 30px 60px;">
			<ul>
			<c:forEach items="${all}" var ="item" varStatus="status">
				<li>
				<c:if test="${item.logId =='checked'}">
				<input name="id" value='${item.dict_value }' checked='checked' type="radio" /><label>${item.dict_name }</label>
				</c:if>
				<c:if test="${item.logId !='checked'}">
				<input name="id" value='${item.dict_value }'   type="radio" /><label>${item.dict_name }</label>
				</c:if>
				
				
				</li>
			</c:forEach>
			<li>
				<label>其他组织:</label>				
			<input class="easyui-textbox address-select" 
			style="width: 80%;paddding-right:2px"   editable="false" value="${orgNames }">
			<input type="hidden" value="${orgIds }" name="rorgids"  >
			</li>
			</ul>
		</div>
	 </div>
	</form>
	<script type="text/javascript" src="<%=basePath%>common/js/system/address/addressPage.js"></script>
	<script type="text/javascript">
		function addRole2Auths(){
			promptMessageCallBack("3","是否该角色修改数据权限？",function(){					
				$.ajax({
					type : 'POST',
					url : ctx + "role/saveDataAuthsOfRole" ,
					data :   ($("#role2dataAuthFm").serialize()),
					success : function(data) {
						promptMessage(data.res, data.msg );
					},
					dataType : "JSON"
				});
			});
		}
		

		$(function(){
				$(".address-select").textbox({
					icons: [{
						iconCls:'icon-search',
						handler: function(e){
							openAddress($("#_loadDialog_address"),$("input[name='rorgids']"),$(".address-select"),'O',true);
						}
					}]
				})
			});
	</script>
</body>
</html>