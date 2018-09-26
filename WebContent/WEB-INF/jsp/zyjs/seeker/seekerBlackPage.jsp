<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
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
					<td class="kv-label">姓名</td>
					<td class="kv-content"><span id="name1">${seeker.name }</span></td>
					<td class="kv-label">电子邮箱</td>
					<td class="kv-content"><span id="code">${seeker.email }</span></td>
					<td class="kv-label">联系电话</td>
					<td class="kv-content"><span id="simpleName">${seeker.temp_str1 }</span></td>
				</tr>
				<tr>
					<td class="kv-label">学历</td>
					<td class="kv-content"><span id="type">${seeker.education }</span></td>
					<td class="kv-label">外语</td>
					<td class="kv-content"><span id="isVisible">${seeker.language }</span></td>
					<td class="kv-label">外语水平</td>
					<td class="kv-content"><span id="adminer">${seeker.languageLevel }</span></td>
				</tr>
				<tr>
					<td class="kv-label">意向工作地</td>
					<td class="kv-content"><span id="type">${seeker.wantPlace }</span></td>
				</tr>
			</tbody>
		</table>
		
		
		<table class="easyui-datagrid"  tyle="width:100%;height:auto" title="简历列表"  > 
			<thead>
				<tr>
					<th data-options="field:'code1',width:'30%'">求职职位</th>
					<th data-options="field:'code2',width:'40%'">专业</th>
					<th data-options="field:'code3',width:'30%'">期望薪资</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${resumes }">
				<tr>
					<td>${item.jobName }</td>
					<td>${item.major }</td>
					<td>${item.welware }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
	</div>
	
	<form id="seekerblack">
		<div style="margin-bottom: 20px; margin-left: 5px">
			<div>审核结果</div>
			<select  name="code"  >
				<option value="1">进入黑名单</option>
				<option value="0">退出黑名单</option>
			</select>
		</div>
		<div style="margin-bottom: 20px; margin-left: 5px">
			<div>其他说明</div>
			<input class="easyui-textbox" name="remark"
				style="width: 30%; paddding-right: 2px"
				data-options="required:true,validType:['length[0,30]']">
		</div>
		<input name="id" value="${seeker.id }" type="hidden">
	</form>
	<script type="text/javascript">
		function addAuditHunter() {
			promptMessageCallBack("3", "是否确认此操作？", function() {
				$.ajax({
					type : 'POST',
					url : ctx + "seeker/black",
					data : ($("#hunterblack").serialize()),
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