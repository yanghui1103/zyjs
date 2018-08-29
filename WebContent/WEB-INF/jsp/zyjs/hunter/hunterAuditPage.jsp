<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div style="float: right; margin-right: 30px; margin-top: 5px">
		<button class="easyui-linkbutton" type=button iconCls="icon-add"
			data-options="selected:true" onclick="addAuditHunter();"
			style="width: 150px">保存</button>
	</div>

	<div title="基本信息" data-options="closable:false" class="basic-info">
		<div class="column">
			<span class="current">注册信息</span>
		</div>
		<table class="kv-table">
			<tbody>
				<tr>
					<td class="kv-label">企业名称</td>
					<td class="kv-content"><span id="name1">${hunter.name }</span></td>
					<td class="kv-label">电子邮箱</td>
					<td class="kv-content"><span id="code">${hunter.email }</span></td>
					<td class="kv-label">联系电话</td>
					<td class="kv-content"><span id="simpleName">${hunter.phone }</span></td>
				</tr>
				<tr>
					<td class="kv-label">地址</td>
					<td class="kv-content"><span id="type">${hunter.address }</span></td>
					<td class="kv-label">性质</td>
					<td class="kv-content"><span id="isVisible">${hunter.compType }</span></td>
					<td class="kv-label">行业</td>
					<td class="kv-content"><span id="adminer">${hunter.industry }</span></td>
				</tr>
				<tr>
					<td class="kv-label">规模</td>
					<td class="kv-content"><span id="type">${hunter.scale }</span></td>
					<td class="kv-label">官网</td>
					<td class="kv-content"><span id="isVisible">${hunter.netUrl }</span></td>
					<td class="kv-label">社会信用代码证号</td>
					<td class="kv-content"><span id="adminer">${hunter.cardId }</span></td>
				</tr>
				<tr>
					<td class="kv-label">简介</td>
					<td class="kv-content"><span id="type">${hunter.introduction }</span></td>
				</tr>
			</tbody>
		</table>
	</div>
	<form id="hunterAudit">
		<div style="margin-bottom: 20px; margin-left: 5px">
			<div>审核结果</div>
			<select class="easyui-combogrid" name="code" editable="false"
				style="width: 30%"
				data-options="limitToList:true,
					panelWidth: 200,
					idField: 'dict_value',
					textField: 'dict_name',
					url: '<%=basePath%>dict/getDictsByParentValue/datastatus',
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
		<div style="margin-bottom: 20px; margin-left: 5px">
			<div>其他说明</div>
			<input class="easyui-textbox" name="remark"
				style="width: 30%; paddding-right: 2px"
				data-options="required:true,validType:['length[0,30]']">
		</div>
		<input name="foreignId" value="${hunter.id }" type="hidden">
		<input name="_method" value=PUT" type="hidden">
	</form>
	<script type="text/javascript">
		function addAuditHunter() {
			promptMessageCallBack("3", "是否确认？", function() {
				$.ajax({
					type : 'PUT',
					url : ctx + "hunter/audit",
					data : ($("#hunterAudit").serialize()),
					success : function(data) {
						promptMessage(data.res, data.msg);
					},
					dataType : "JSON"
				});
			});
		}
	</script>
</body>
</html>