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

	<div title="基本信息" data-options="closable:false" class="basic-info">

		<div class="column">
			<span class="current">注册信息</span>
		</div>
		<table class="kv-table">
			<tbody>
				<tr>
					<td class="kv-label">企业名称</td>
					<td class="kv-content"><span id="name1">${esta.name }</span></td>
					<td class="kv-label">电子邮箱</td>
					<td class="kv-content"><span id="code">${esta.email }</span></td>
					<td class="kv-label">联系电话</td>
					<td class="kv-content"><span id="simpleName">${esta.phone }</span></td>
				</tr>
				<tr>
					<td class="kv-label">地址</td>
					<td class="kv-content"><span id="type">${esta.address }</span></td>
					<td class="kv-label">性质</td>
					<td class="kv-content"><span id="isVisible">${esta.compType }</span></td>
					<td class="kv-label">行业</td>
					<td class="kv-content"><span id="adminer">${esta.industry }</span></td>
				</tr>
				<tr>
					<td class="kv-label">规模</td>
					<td class="kv-content"><span id="type">${esta.scale }</span></td>
					<td class="kv-label">官网</td>
					<td class="kv-content"><span id="isVisible">${esta.netUrl }</span></td>
					<td class="kv-label">简介</td>
					<td class="kv-content"><span id="introduction">${esta.introduction }</span></td>
<!-- 					<td class="kv-label">社会信用代码证号</td> -->
<%-- 					<td class="kv-content"><span id="adminer">${esta.cardId }</span></td> --%>
				</tr>
<!-- 				<tr> -->
<!-- 				</tr> -->
			</tbody>
		</table>
</body>
</html>